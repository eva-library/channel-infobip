/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller.dto.whatssapp.response;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.everis.eva.controller.dto.whatssapp.request.OMNIFlow;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OMNIScenarioResponse implements Serializable {
	private static final long serialVersionUID = -7452526734451371972L;

	@SerializedName("name")
	private String name;

	@SerializedName("key")
	private String key;

	@SerializedName("flow")
	private List<OMNIFlow> flow;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
