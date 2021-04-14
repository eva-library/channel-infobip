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
public class OMNIWhatsAppMsg implements Serializable {
	private static final long serialVersionUID = -8387734913895375041L;

	@SerializedName("text")
	private String text;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("audioUrl")
	private String audioUrl;

	@SerializedName("videoUrl")
	private String videoUrl;

	@SerializedName("fileUrl")
	private String fileUrl;

	@SerializedName("longitude")
	private Double longitude;

	@SerializedName("latitude")
	private Double latitude;

	@SerializedName("locationName")
	private String locationName;

	@SerializedName("address")
	private String address;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
