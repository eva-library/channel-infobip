package com.everis.eva.feign;


import com.everis.eva.controller.dto.whatssapp.request.OMNIAdvancedRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNIScenarioRequest;
import com.everis.eva.controller.dto.whatssapp.response.OMNIAdvancedResponse;
import com.everis.eva.controller.dto.whatssapp.response.OMNIScenarioResponse;

public interface InfobipClient {

	ChannelService generatedInstanceClient(String url);

	OMNIScenarioResponse callInfobip(ChannelService client, String authorization, OMNIScenarioRequest request);

	OMNIAdvancedResponse callInfobip(ChannelService client, String authorization, OMNIAdvancedRequest request);

}
