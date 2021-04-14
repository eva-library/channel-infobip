/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.service;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

@XmlType
public class WhatsAppRequest {

	private int messageCount;

	private int pendingMessageCount;

	private List<WhatsAppResultsRequest> results;

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public int getPendingMessageCount() {
		return pendingMessageCount;
	}

	public void setPendingMessageCount(int pendingMessageCount) {
		this.pendingMessageCount = pendingMessageCount;
	}

	public List<WhatsAppResultsRequest> getResults() {
		return results;
	}

	public void setResults(List<WhatsAppResultsRequest> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
