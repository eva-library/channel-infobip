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

public class WhatsAppPriceRequest {

	private float pricePerMessage;

	private String currency;

	public float getPricePerMessage() {
		return pricePerMessage;
	}

	public void setPricePerMessage(float pricePerMessage) {
		this.pricePerMessage = pricePerMessage;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
