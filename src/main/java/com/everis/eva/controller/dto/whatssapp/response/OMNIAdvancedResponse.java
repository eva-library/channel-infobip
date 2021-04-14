/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.response;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class OMNIAdvancedResponse {

	@SerializedName("messages")
	private List<OMNIMessages> messages;

	public List<OMNIMessages> getMessages() {
		return messages;
	}

	public void setMessages(List<OMNIMessages> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
