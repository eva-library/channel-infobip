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

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class OMNITo implements Serializable {
	private static final long serialVersionUID = 2971265639567908164L;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("emailAddress")
	private String emailAddress;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
