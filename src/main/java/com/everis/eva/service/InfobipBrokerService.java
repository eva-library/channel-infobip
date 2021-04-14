package com.everis.eva.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.everis.eva.controller.dto.whatssapp.service.WhatsAppRequest;
import com.everis.eva.domain.BrokerHeader;
import com.everis.eva.domain.Configuration;
import com.everis.eva.domain.InfobipInfo;
import com.everis.eva.domain.WhatsAppUser;
import com.everis.eva.repository.WhatsAppRepository;
import com.everis.eva.service.cache.WhatsAppCache;
import com.everis.eva.service.dto.AnswerResponseDTO;
import com.everis.eva.service.dto.ConversationResponseDTO;
import com.google.gson.Gson;

@Controller
public class InfobipBrokerService {

	private static final String SCENARIOKEY_LABEL = "scenarioKey";

	private static final String SESSIONCODE_LABEL = "sessionCode";

	private static final String IMAGE = "IMAGE";

	private static final String VOICE = "VOICE";

	private static final String DOCUMENT = "DOCUMENT";
	
	private static final String LOCATION = "LOCATION";

	private static final Logger logger = ESAPI.getLogger(BrokerService.class);

	@Autowired
	private BrokerService brokerService;

	@Autowired
	private WhatsAppCache whatsAppCache;

	@Autowired
	private WhatsAppRepository whatsAppRepository;

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private InfobipService infobipService;

	/**
	 *
	 * @param request
	 */
	@Async
	public void resolve(WhatsAppRequest request) {

		final InfobipInfo infobipInfo = infobipService.getInfobipInfo();

		final String phoneNumber = request.getResults().get(0).getFrom();

		final Map<String, Object> userKeys = whatsAppCache.getUserKeys(phoneNumber);

		final String waCode = request.getResults().get(0).getMessage().getCode();

		String waType = request.getResults().get(0).getMessage().getType();
		
		String waText = request.getResults().get(0).getMessage().getText();

		String waUrl = request.getResults().get(0).getMessage().getUrl();

		String scenarioKey = "";

		String sessionCode = "";

		if (StringUtils.isEmpty(waText)) {

			if (!waType.isEmpty() && waType.contentEquals(VOICE)) {
				waText = VOICE;
			} else if (!waType.isEmpty() && waType.contentEquals(DOCUMENT)) {
				waText = waUrl.concat(" # ").concat(request.getResults().get(0).getMessage().getCaption());
			} else if (!waType.isEmpty() && waType.contentEquals(IMAGE)) {
				waText = waUrl;
			}  else if (!waType.isEmpty() && waType.contentEquals(LOCATION)) {
				waText = request.getResults().get(0).getMessage().getAddress();
			} else {
				waText = waUrl;
			}
		}

		if (org.springframework.util.StringUtils.startsWithIgnoreCase(waText, infobipInfo.getKeyword())) {
			waText = waText.substring(infobipInfo.getKeyword().length() + 1);
		}

		if ((userKeys != null) && (userKeys.get(SCENARIOKEY_LABEL) != null)
				&& (userKeys.get(SESSIONCODE_LABEL) != null)) {
			scenarioKey = userKeys.get(SCENARIOKEY_LABEL).toString();
			sessionCode = userKeys.get(SESSIONCODE_LABEL).toString();

		}

		if (StringUtils.isBlank(scenarioKey)) {
			logger.info(Logger.EVENT_SUCCESS, "[WA] Generating a new scenario...");

			scenarioKey = infobipService.createOMNIScenario(sessionCode);
			final Map<String, Object> scenarioMap = new HashMap<>();
			scenarioMap.put(SCENARIOKEY_LABEL, scenarioKey);

			whatsAppCache.setUserKeys(phoneNumber, scenarioMap);
			whatsAppRepository.save(new WhatsAppUser(Long.parseLong(phoneNumber), new Date(), scenarioKey));
		}

		logger.info(Logger.EVENT_SUCCESS, "ScenarioKey: " + scenarioKey);
		logger.info(Logger.EVENT_SUCCESS, "SessionCode: " + sessionCode);

		final List<String> result = ask(phoneNumber, waCode, waText, sessionCode, scenarioKey);

		if (!CollectionUtils.isEmpty(result)) {

			for (final String content : result) {
				if (!StringUtils.isBlank(content)) {
					logger.info(Logger.EVENT_SUCCESS, "Message: " + result);
					infobipService.sendAdvancedMsg(phoneNumber, content, scenarioKey, sessionCode);
				}
			}
		}
	}

	/**
	 *
	 * @param phoneNumber
	 * @param code
	 * @param text
	 * @param sessionCode
	 * @param scenarioKey
	 * @return
	 */
	private List<String> ask(String phoneNumber, String code, String text, String sessionCode, String scenarioKey) {

		final Map<String, Object> headers = getBrokerHeaders(getBrokerHeadersFromProperties(), phoneNumber);

		final ConversationResponseDTO response = brokerService.callBroker(headers, text, code, sessionCode);

		final List<String> result = new ArrayList<>();
		String resp;

		if (response != null) {
			final Map<String, Object> responseMap = new HashMap<>();
			responseMap.put(SESSIONCODE_LABEL, response.getSessionCode());
			responseMap.put(SCENARIOKEY_LABEL, scenarioKey);
			whatsAppCache.setUserKeys(phoneNumber, responseMap);

			final List<AnswerResponseDTO> listAnswers = response.getAnswers();
			for (final AnswerResponseDTO answer : listAnswers) {

				resp = (String) answer.getContent();

				if (StringUtils.isNotBlank(resp)) {

					resp = resp.replaceAll("\\<.*?>", "").trim();
				}
				result.add(resp);
			}

			logger.info(Logger.EVENT_SUCCESS, "Result: " + result);
		}

		return result;
	}

	public Map<String, Object> getBrokerHeaders(BrokerHeader brokerHeader, String phoneNumber) {
		Map<String, Object> headers = new HashedMap<>();
		if (brokerHeader != null) {
			headers.put("API-KEY", brokerHeader.getApiKey());
			headers.put("PROJECT", brokerHeader.getProject());
			headers.put("CHANNEL", brokerHeader.getChannel());
			headers.put("OS", brokerHeader.getOs());
			headers.put("LOCALE", brokerHeader.getLocale());
			headers.put("USER-REF", phoneNumber);
			headers.put("BUSINESS-KEY", phoneNumber);
		}
		return headers;
	}

	private BrokerHeader getBrokerHeadersFromProperties() {
		Configuration configuration = configurationService.getProperty("whatsapp.broker.info");
		return new Gson().fromJson(configuration.getValue(), BrokerHeader.class);
	}

}
