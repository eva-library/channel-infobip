/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.Base64;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.eva.controller.dto.whatssapp.request.OMNIAdvancedRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNIDestinations;
import com.everis.eva.controller.dto.whatssapp.request.OMNIFlow;
import com.everis.eva.controller.dto.whatssapp.request.OMNILocation;
import com.everis.eva.controller.dto.whatssapp.request.OMNIScenarioRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNITo;
import com.everis.eva.controller.dto.whatssapp.request.OMNIWhatsAppMsg;
import com.everis.eva.controller.dto.whatssapp.response.OMNIAdvancedResponse;
import com.everis.eva.controller.dto.whatssapp.response.OMNIScenarioResponse;
import com.everis.eva.domain.Configuration;
import com.everis.eva.domain.InfobipInfo;
import com.everis.eva.domain.enums.InfobipChannelType;
import com.everis.eva.domain.enums.LogType;
import com.everis.eva.domain.enums.ModuleType;
import com.everis.eva.feign.InfobipClient;
import com.everis.eva.utils.EvaStopWatch;
import com.google.gson.Gson;

@Component
public class InfobipService {

	private static final Logger logger = ESAPI.getLogger(InfobipService.class);

	private static final String URL_REGEXP = "(https:)([/.\\w-%+])*\\.(?:jpg|jpeg|png|pdf|docx|doc|pptx|ppt|xlsx|xls|mp4|3gpp|aac|amr|mp3|opus)";

	private static final String LOCATION_PATTERN = "LOCATION-";

	private static final String IMAGE_PNG = ".png";

	private static final String IMAGE_JPG = ".jpg";

	private static final String IMAGE_JPEG = ".jpeg";

	private static final String DOCUMENT_PDF = ".pdf";

	private static final String DOCUMENT_DOC = ".doc";

	private static final String DOCUMENT_DOCX = ".docx";

	private static final String DOCUMENT_PPT = ".ppt";

	private static final String DOCUMENT_PPTX = ".pptx";

	private static final String DOCUMENT_XLS = ".xls";

	private static final String DOCUMENT_XLSX = ".xlsx";

	private static final String VIDEO_MP4 = ".mp4";

	private static final String VIDEO_3GPP = ".3gpp";

	@Autowired
	private TechnicalLogService technicalLogService;

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private InfobipClient client;

	/**
	 *
	 * @param sessionCode
	 * @return
	 */
	public String createOMNIScenario(String sessionCode) {

		final EvaStopWatch sw = new EvaStopWatch();

		final InfobipInfo info = getInfobipInfo();

		final OMNIScenarioRequest request = new OMNIScenarioRequest();
		request.setName("WhatsAppScenario");

		final OMNIFlow whatsAppFlow = new OMNIFlow();
		final ArrayList<OMNIFlow> flow = new ArrayList<>();
		whatsAppFlow.setChannel(InfobipChannelType.toEnum(info.getChannel()));
		whatsAppFlow.setFrom(info.getWhatsappNumber());
		flow.add(whatsAppFlow);
		request.setFlow(flow);

		try {
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] createOMNIScenario");
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request body: " + request);
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request sessionCode: " + sessionCode);

			OMNIScenarioResponse omniScenarioResponse = this.client.callInfobip(
					this.client.generatedInstanceClient(info.getOmniUrl() + "/scenarios"),
					getAuthHeader(info.getUser(), info.getPassword()), request);

			if (omniScenarioResponse != null) {

				logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Response: " + omniScenarioResponse);
				this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
						"[INFOBIP SERVICE] SCENARIO CREATE PROCESSED", sw.getTime());
				return omniScenarioResponse.getKey();
			} else {

				logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Response Error");
				this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
						"[INFOBIP SERVICE] SCENARIO CREATE ERROR PROCESSED", sw.getTime());
			}
		} catch (final Exception e) {

			logger.error(Logger.EVENT_FAILURE, "[INFOBIP SERVICE] Error: " + e.getMessage(), e);
			this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
					"[INFOBIP SERVICE] SCENARIOCREATE ERROR", e, sw.getTime());
		}

		return null;
	}

	/**
	 *
	 * @param phoneNumber
	 * @param text
	 * @param scenarioKey
	 * @param sessionCode
	 * @return
	 */
	public OMNIAdvancedResponse sendAdvancedMsg(String phoneNumber, String text, String scenarioKey,
			String sessionCode) {

		final EvaStopWatch sw = new EvaStopWatch();

		final InfobipInfo info = getInfobipInfo();

		final OMNIAdvancedRequest request;

		Pattern p = Pattern.compile(URL_REGEXP);
		Matcher m = p.matcher(text);

		if (m.find()) {

			String textAux = text.substring(m.end(), text.length());

			if (m.group().contains(IMAGE_JPG) || m.group().contains(IMAGE_JPEG) || m.group().contains(IMAGE_PNG)) {

				if (!textAux.isEmpty()) {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().imageUrl(m.group()).text(textAux)
									.latitude(null).longitude(null).build())
							.build();
				} else {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().imageUrl(m.group()).text(null).latitude(null)
									.longitude(null).build())
							.build();
				}

			} else if (m.group().contains(DOCUMENT_PDF) || m.group().contains(DOCUMENT_DOC)
					|| m.group().contains(DOCUMENT_DOCX) || m.group().contains(DOCUMENT_PPT)
					|| m.group().contains(DOCUMENT_PPTX) || m.group().contains(DOCUMENT_XLS)
					|| m.group().contains(DOCUMENT_XLSX)) {

				if (!textAux.isEmpty()) {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().fileUrl(m.group()).text(textAux).latitude(null)
									.longitude(null).build())
							.build();
				} else {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().fileUrl(m.group()).text(null).latitude(null)
									.longitude(null).build())
							.build();
				}

			} else if (m.group().contains(VIDEO_MP4) || m.group().contains(VIDEO_3GPP)) {

				if (!textAux.isEmpty()) {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().videoUrl(m.group()).text(textAux)
									.latitude(null).longitude(null).build())
							.build();
				} else {
					request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
							.destinations(OMNIDestinations.builder()
									.to(OMNITo.builder().phoneNumber(phoneNumber).build()).build())
							.whatsApp(OMNIWhatsAppMsg.builder().videoUrl(m.group()).text(null).latitude(null)
									.longitude(null).build())
							.build();
				}

			} else { // AUDIO
				request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
						.destinations(OMNIDestinations.builder().to(OMNITo.builder().phoneNumber(phoneNumber).build())
								.build())
						.whatsApp(OMNIWhatsAppMsg.builder().audioUrl(m.group()).text(null).latitude(null)
								.longitude(null).build())
						.build();
			}

		} else {

			if (text.startsWith(LOCATION_PATTERN)) {

				OMNILocation location = null;

				location = new Gson().fromJson(text.split("-")[1], OMNILocation.class);

				request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
						.destinations(OMNIDestinations.builder().to(OMNITo.builder().phoneNumber(phoneNumber).build())
								.build())
						.whatsApp(OMNIWhatsAppMsg.builder().latitude(location.getLatitude())
								.longitude(location.getLongitude()).address(location.getAddress())
								.locationName(location.getLocationName()).build())
						.build();

			} else {
				request = OMNIAdvancedRequest.builder().scenarioKey(scenarioKey)
						.destinations(OMNIDestinations.builder().to(OMNITo.builder().phoneNumber(phoneNumber).build())
								.build())
						.whatsApp(OMNIWhatsAppMsg.builder().text(text).latitude(null).longitude(null)
								.build())
						.build();
			}

		}

		try {

			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request body: " + request);
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request phoneNumber: " + phoneNumber);
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request scenarioKey: " + scenarioKey);
			logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Request sessionCode: " + sessionCode);

			final OMNIAdvancedResponse omniAdvancedResponse = this.client.callInfobip(
					this.client.generatedInstanceClient(info.getOmniUrl() + "/advanced"),
					this.getAuthHeader(info.getUser(), info.getPassword()), request);

			if (omniAdvancedResponse != null) {

				logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Response: " + omniAdvancedResponse);
				this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
						"[INFOBIP SERVICE] WHATSAPP MESSAGE PROCESSED", sw.getTime());

				return omniAdvancedResponse;
			} else {

				logger.info(Logger.EVENT_FAILURE, "[INFOBIP SERVICE] Response Error");
				this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
						"[INFOBIP SERVICE] WHATSAPP MESSAGE ERROR PROCESSED", sw.getTime());
			}
		} catch (final Exception e) {
			logger.error(Logger.EVENT_FAILURE, "[INFOBIP SERVICE] Error: " + e.getMessage(), e);
			this.technicalLogService.generateLog(sessionCode, ModuleType.SERVICES_ROUTES, LogType.INFO,
					"[INFOBIP SERVICE] WHATSAPP MESSAGE ERROR", e, sw.getTime());
		}

		return null;
	}

	/**
	 *
	 * @return
	 */
	public InfobipInfo getInfobipInfo() {
		final Configuration configuration = this.configurationService.getProperty("whatsapp.infobip.info");
		final InfobipInfo info = new Gson().fromJson(configuration.getValue(), InfobipInfo.class);
		logger.info(Logger.EVENT_SUCCESS, "[INFOBIP SERVICE] Info: " + info);
		return info;
	}

	private String getAuthHeader(String user, String password) {
		return "Basic " + new String(
				Base64.encodeBase64(new String(user + ":" + password).getBytes(StandardCharsets.US_ASCII)));
	}

}
