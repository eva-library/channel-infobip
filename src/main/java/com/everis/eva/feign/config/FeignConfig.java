package com.everis.eva.feign.config;

import org.springframework.context.annotation.Bean;

import com.everis.eva.feign.ChannelFeignClient;
import com.google.gson.Gson;

import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignConfig {

	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

	@Bean
	public GsonEncoder encoder() {
		return new GsonEncoder(new Gson());
	}

	@Bean
	public GsonDecoder decoder() {
		return new GsonDecoder(new Gson());
	}

	@Bean
	public Retryer retryer() {
		return new Retryer.Default(500, 1000, 5);
	}

	@Bean
	public Slf4jLogger logger() {
		return new Slf4jLogger(ChannelFeignClient.class);
	}

}
