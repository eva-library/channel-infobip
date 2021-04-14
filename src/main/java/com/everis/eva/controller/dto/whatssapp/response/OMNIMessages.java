/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.response;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.everis.eva.controller.dto.whatssapp.request.OMNITo;
import com.google.gson.annotations.SerializedName;

public class OMNIMessages {

	@SerializedName("to")
	private OMNITo to;

	@SerializedName("status")
	private OMNIStatus status;

	@SerializedName("messageId")
	private String messageId;

	public OMNITo getTo() {
		return to;
	}

	public void setTo(OMNITo to) {
		this.to = to;
	}

	public OMNIStatus getStatus() {
		return status;
	}

	public void setStatus(OMNIStatus status) {
		this.status = status;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
