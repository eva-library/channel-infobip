/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.request;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.everis.eva.domain.enums.InfobipChannelType;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OMNIFlow implements Serializable {
	private static final long serialVersionUID = 661569933592669518L;

	@SerializedName("from")
	private String from;

	@SerializedName("channel")
	private InfobipChannelType channel;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
