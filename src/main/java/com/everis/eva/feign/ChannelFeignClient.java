package com.everis.eva.feign;

import com.everis.eva.controller.dto.whatssapp.request.OMNIAdvancedRequest;
import com.everis.eva.controller.dto.whatssapp.request.OMNIScenarioRequest;
import com.everis.eva.controller.dto.whatssapp.response.OMNIAdvancedResponse;
import com.everis.eva.controller.dto.whatssapp.response.OMNIScenarioResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ChannelFeignClient {

	@RequestLine("POST")
	@Headers("Authorization: {authorization}")
	OMNIScenarioResponse callInfobip(@Param("authorization") String authorization, OMNIScenarioRequest request);

	@RequestLine("POST")
	@Headers("Authorization: {authorization}")
	OMNIAdvancedResponse callInfobip(@Param("authorization") String authorization, OMNIAdvancedRequest request);

}
