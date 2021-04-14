package com.everis.eva.service;

import org.springframework.stereotype.Service;

import com.everis.eva.controller.dto.whatssapp.request.OMNIAdvancedRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNIScenarioRequest;
import com.everis.eva.controller.dto.whatssapp.response.OMNIAdvancedResponse;
import com.everis.eva.controller.dto.whatssapp.response.OMNIScenarioResponse;
import com.everis.eva.feign.ChannelService;
import com.everis.eva.feign.InfobipClient;

@Service
public class InfobipClientService implements InfobipClient {

	@Override
	public ChannelService generatedInstanceClient(String url) {
		return new ChannelService(url);
	}

	@Override
	public OMNIScenarioResponse callInfobip(ChannelService client, String authorization, OMNIScenarioRequest request) {
		return client.callInfobip(authorization, request);
	}

	@Override
	public OMNIAdvancedResponse callInfobip(ChannelService client, String authorization, OMNIAdvancedRequest request) {
		return client.callInfobip(authorization, request);
	}

}
