package com.everis.eva.util;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Component;

@Component
public class ControllerUtil {

	/**
	 * Generate the "Basic Auth" string token with user and password
	 * @param user
	 * @param password
	 * @return
	 */
	public String generateAuthHeader(String user, byte[] password) {
		final byte[] usr = user.getBytes();
		final byte[] pwd = password;

		final byte[] result = new byte[usr.length + pwd.length + 1];

		System.arraycopy(usr, 0, result, 0, usr.length);
		System.arraycopy(":".getBytes(), 0, result, usr.length, 1);
		System.arraycopy(pwd, 0, result, usr.length + 1, pwd.length);

		//clean sensitive information
		Arrays.fill(usr, (byte) 1);
		Arrays.fill(pwd, (byte) 1);

		final Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(result);
	}

}
