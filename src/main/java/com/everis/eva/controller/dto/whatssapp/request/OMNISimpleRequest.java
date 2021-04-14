/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.request;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class OMNISimpleRequest {

	@SerializedName("destinations")
	private OMNIDestinations destinations;

	@SerializedName("text")
	private String text;

	public OMNIDestinations getDestinations() {
		return destinations;
	}

	public void setDestinations(OMNIDestinations destinations) {
		this.destinations = destinations;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
