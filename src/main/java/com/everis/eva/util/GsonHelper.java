package com.everis.eva.util;

import java.lang.reflect.Type;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonHelper {
	private static final Gson POJO_BASE64_PASSWORD_GSON = new GsonBuilder()
			.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter()).create();

	private static final Gson POJO_PASSWORD_GSON = new GsonBuilder()
			.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToStringTypeAdapter()).create();

	private static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

		private final Encoder encoder = Base64.getEncoder();

		private final Decoder decoder = Base64.getDecoder();

		@Override
		public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			return decoder.decode(json.getAsString());
		}

		@Override
		public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(encoder.encodeToString(src));
		}
	}

	private static class ByteArrayToStringTypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

		@Override
		public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			final String jsonAsString = json.getAsString();
			return jsonAsString != null ? jsonAsString.getBytes() : null;
		}

		@Override
		public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
			final String valueAsBytesString = src != null ? new String(src) : null;
			return new JsonPrimitive(valueAsBytesString);
		}
	}

	public static Gson getPojoPasswordGson() {
		return POJO_PASSWORD_GSON;
	}

	public static Gson getPojoBase64PasswordGson() {
		return POJO_BASE64_PASSWORD_GSON;
	}
}
