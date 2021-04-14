package com.everis.eva.controller.dto.whatssapp.request;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class OMNILocation implements Serializable {

	private static final long serialVersionUID = 4696690905941687812L;

	@SerializedName("longitude")
	private Double longitude;

	@SerializedName("latitude")
	private Double latitude;

	@SerializedName("locationName")
	private String locationName;

	@SerializedName("address")
	private String address;

}
