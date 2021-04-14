package com.everis.eva.domain.enums;

public enum InfobipChannelType {

	WHATSAPP("WHATSAPP");

	private String value;

	private InfobipChannelType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static InfobipChannelType toEnum(String value) {

		if(value == null){
			return null;
		}

		for (final InfobipChannelType cell : InfobipChannelType.values()){
			if(value.equals(cell.getValue())){
				return cell;
			}
		}

		throw new IllegalArgumentException("Invalid infobip channel type: " + value);
	}

	
}
