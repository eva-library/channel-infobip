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

public class WhatsAppResultsRequest {

	private String from;

	private String to;

	private String integrationType;

	private String receivedAt;

	private String messageId;

	private String pairedMessageId;

	private String callbackData;

	private WhatsAppMessageRequest message;

	private WhatsAppPriceRequest price;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getIntegrationType() {
		return integrationType;
	}

	public void setIntegrationType(String integrationType) {
		this.integrationType = integrationType;
	}

	public String getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getPairedMessageId() {
		return pairedMessageId;
	}

	public void setPairedMessageId(String pairedMessageId) {
		this.pairedMessageId = pairedMessageId;
	}

	public String getCallbackData() {
		return callbackData;
	}

	public void setCallbackData(String callbackData) {
		this.callbackData = callbackData;
	}

	public WhatsAppMessageRequest getMessage() {
		return message;
	}

	public void setMessage(WhatsAppMessageRequest message) {
		this.message = message;
	}

	public WhatsAppPriceRequest getPrice() {
		return price;
	}

	public void setPrice(WhatsAppPriceRequest price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
