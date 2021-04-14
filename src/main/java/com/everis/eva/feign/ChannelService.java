package com.everis.eva.feign;

import com.everis.eva.controller.dto.whatssapp.request.OMNIAdvancedRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNIScenarioRequest;
import com.everis.eva.controller.dto.whatssapp.response.OMNIAdvancedResponse;
import com.everis.eva.controller.dto.whatssapp.response.OMNIScenarioResponse;
import com.google.gson.Gson;

import feign.Feign;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class ChannelService {

	private ChannelFeignClient client;
	
	public ChannelService(String url) {
		client = Feign.builder()
				.retryer(new Retryer.Default(3000, 3000, 5))
				.client(new OkHttpClient())
				.encoder(new GsonEncoder(new Gson()))
				.decoder(new GsonDecoder(new Gson()))
				.logger(new Slf4jLogger(ChannelFeignClient.class))
				.target(ChannelFeignClient.class, url);
	}

	public OMNIScenarioResponse callInfobip(String authorization, OMNIScenarioRequest request) {
		return client.callInfobip(authorization, request);
	}
	
	public OMNIAdvancedResponse callInfobip(String authorization, OMNIAdvancedRequest request) {
		return client.callInfobip(authorization, request);
	}

}
