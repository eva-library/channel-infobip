/*
* eVA
* Version: 2.0
* copyright (c) 2018 everis Spain S.A
* * Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo, Caio Soliani
* All rights reserved
*/
package com.everis.eva.infobip.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InfobipServiceTest {

	/*
	 * @InjectMocks private InfobipService infobipService;
	 * 
	 * @Mock private ConfigurationDAO confDAO;
	 * 
	 * @Mock private TechnicalLogDAO techLogDAO;
	 * 
	 * @Mock private RestTemplate restTemplate;
	 * 
	 * @Mock private InfobipService infobipServiceMock;
	 * 
	 * @SuppressWarnings("rawtypes") ResponseEntity responseEntity =
	 * mock(ResponseEntity.class);
	 * 
	 * @BeforeMethod public void setup() { MockitoAnnotations.initMocks(this); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test public void createOMNIScenario() {
	 * 
	 * mock(InfobipInfo.class); responseEntity = new
	 * ResponseEntity<OMNIScenarioResponse>(HttpStatus.CREATED);
	 * 
	 * when(confDAO.getProperty("whatsapp.infobip.info")).thenReturn(
	 * "{\"baseurl\":\"zanzara\"}");
	 * Mockito.when(restTemplate.postForEntity(ArgumentMatchers.anyString(),
	 * ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(responseEntity);
	 * 
	 * infobipService.createOMNIScenario("");
	 * 
	 * Assert.assertNotNull(infobipService); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test public void createOMNIScenarioBadRequest() {
	 * 
	 * mock(InfobipInfo.class); responseEntity = new
	 * ResponseEntity<OMNIScenarioResponse>(HttpStatus.BAD_REQUEST);
	 * 
	 * when(confDAO.getProperty("whatsapp.infobip.info")).thenReturn(
	 * "{\"baseurl\":\"zanzara\"}");
	 * Mockito.when(restTemplate.postForEntity(ArgumentMatchers.anyString(),
	 * ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(responseEntity);
	 * 
	 * infobipService.createOMNIScenario("");
	 * 
	 * Assert.assertEquals(responseEntity.getStatusCodeValue(), 400); }
	 * 
	 * @Test public void sendAdvancedMsgTestException() { final String phoneNumber =
	 * ""; final String text = ""; final String sessionCode = ""; final String
	 * scenarioKey = "";
	 * 
	 * final InfobipInfo info = mock(InfobipInfo.class);
	 * 
	 * when(confDAO.getProperty("whatsapp.infobip.info")).thenReturn(
	 * "{\"omniUrl\":\"zanzara\"}");
	 * 
	 * infobipService.sendAdvancedMsg(phoneNumber, text, scenarioKey, sessionCode);
	 * 
	 * Assert.assertNotNull(info); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test public void sendAdvancedMsgTestBadRequest() { final String phoneNumber
	 * = ""; final String text = ""; final String sessionCode = ""; final String
	 * scenarioKey = "";
	 * 
	 * mock(InfobipInfo.class);
	 * when(confDAO.getProperty("whatsapp.infobip.info")).thenReturn(
	 * "{\"omniUrl\":\"zanzara\"}");
	 * 
	 * Mockito.when(restTemplate.postForEntity(ArgumentMatchers.anyString(),
	 * ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(responseEntity);
	 * 
	 * infobipService.sendAdvancedMsg(phoneNumber, text, scenarioKey, sessionCode);
	 * 
	 * Assert.assertEquals(responseEntity.getStatusCodeValue(), 400); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test public void sendAdvancedMsgTestComplete() { final String phoneNumber =
	 * ""; final String text = ""; final String sessionCode = ""; final String
	 * scenarioKey = "";
	 * 
	 * mock(InfobipInfo.class);
	 * when(confDAO.getProperty("whatsapp.infobip.info")).thenReturn(
	 * "{\"omniUrl\":\"zanzara\"}");
	 * 
	 * responseEntity = new
	 * ResponseEntity<OMNIScenarioResponse>(HttpStatus.CREATED);
	 * 
	 * Mockito.when(restTemplate.postForEntity(ArgumentMatchers.anyString(),
	 * ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(responseEntity);
	 * 
	 * infobipService.sendAdvancedMsg(phoneNumber, text, scenarioKey, sessionCode);
	 * 
	 * Assert.assertEquals(responseEntity.getStatusCodeValue(), 201); }
	 */

}
