/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import lombok.Getter;

@Getter
public class WhatsAppMessageRequest {

	private String code;

	private String text;

	private String type;
	
	private String url;

	private String caption;
	
	private Double longitude;

	private Double latitude;

	private String address;

	private String name;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
