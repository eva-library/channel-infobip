/*
* eVA
* Version: 2.0
* copyright (c) 2018 everis Spain S.A
* * Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo, Caio Soliani, Leandro Marques
* All rights reserved
*/
package com.everis.eva.infobip.service;

import org.springframework.stereotype.Controller;

@Controller
public class InfobipBrokerServiceTest {

	/*
	 * private static final String SCENARIOKEY_LABEL = "scenarioKey";
	 * 
	 * private static final String SESSIONCODE_LABEL = "sessionCode";
	 * 
	 * @InjectMocks private WhatsAppController whatsAppController;
	 * 
	 * @Mock private WhatsAppUserDAO whatsAppUserDAO;
	 * 
	 * @Mock private WhatsAppCache waCache;
	 * 
	 * @Mock InfobipService waService;
	 * 
	 * @Mock WhatsAppUserDAO waUserDAO;
	 * 
	 * @Mock private ConfigurationDAO configDAO;
	 * 
	 * @Mock private BrokerClient brokerClient;
	 * 
	 * @BeforeMethod public void setup() { MockitoAnnotations.initMocks(this); }
	 * 
	 * @Test public void resolveTestNotNull() {
	 * 
	 * final WhatsAppRequest request = new WhatsAppRequest();
	 * 
	 * final List<WhatsAppResultsRequest> results = new ArrayList<>();
	 * 
	 * final WhatsAppMessageRequest message = new WhatsAppMessageRequest(); final
	 * WhatsAppResultsRequest result = new WhatsAppResultsRequest();
	 * 
	 * result.setFrom("30"); message.setText("56");
	 * 
	 * result.setMessage(message); results.add(result);
	 * 
	 * request.setResults(results); result.setMessage(message);
	 * 
	 * Mockito.when(configDAO.getProperty("whatsapp.broker.info")).thenReturn(
	 * "{\"baseUrl\":\"localost\",\"apiKey\":\"keykey\",\"project\":\"EverCar\",\"channel\":\"GoogleHome\",\"os\":\"Google\",\"locale\":\"pt-BR\"}"
	 * );
	 * 
	 * whatsAppController.resolve(request);
	 * 
	 * Assert.assertNotNull(request);
	 * 
	 * }
	 * 
	 * @Test public void resolveIfTest() {
	 * 
	 * final WhatsAppRequest request = new WhatsAppRequest(); final
	 * WhatsAppResultsRequest result = new WhatsAppResultsRequest();
	 * result.setFrom("teste"); final List<WhatsAppResultsRequest> results = new
	 * ArrayList<>(Arrays.asList(result)); request.setResults(results);
	 * 
	 * final WhatsAppMessageRequest message = new WhatsAppMessageRequest(); final
	 * Map<String, Object> map2 = new HashMap<>();
	 * 
	 * map2.put(SCENARIOKEY_LABEL, "teste"); map2.put(SESSIONCODE_LABEL, "teste2");
	 * 
	 * result.setFrom("30"); message.setText("evaaaa");
	 * 
	 * result.setMessage(message);
	 * 
	 * Mockito.when(configDAO.getProperty("whatsapp.broker.info")).thenReturn(
	 * "{\"baseUrl\":\"localost\",\"apiKey\":\"keykey\",\"project\":\"EverCar\",\"channel\":\"GoogleHome\",\"os\":\"Google\",\"locale\":\"pt-BR\"}"
	 * );
	 * Mockito.when(waCache.getUserKeys(results.get(0).getFrom())).thenReturn(map2);
	 * 
	 * whatsAppController.resolve(request);
	 * 
	 * }
	 */
}
