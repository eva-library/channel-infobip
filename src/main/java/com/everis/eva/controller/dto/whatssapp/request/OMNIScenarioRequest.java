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
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OMNIScenarioRequest implements Serializable {
	private static final long serialVersionUID = 2731265254095155140L;

	@JsonProperty("name")
	private String name;

	@JsonProperty("flow")
	private List<OMNIFlow> flow;

	@JsonProperty("default")
	private boolean valueDefault;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
