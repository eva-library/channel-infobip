package com.everis.eva.infobip.service.cache;

import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.everis.eva.service.cache.WhatsAppCache;

@Controller
public class WhatsAppCacheTest {

	@InjectMocks
	private WhatsAppCache whatsAppCache;

	@Mock
	private Logger logger;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUserKeystest() {

		final Map<String, Object> map = new HashMap<>();
		whatsAppCache.setUserKeys("#phoneNumber", map);

		final Map<String, Object> response = whatsAppCache.getUserKeys("#phoneNumber");

		assertNull(response);

	}

	@Test
	public void removeTest() {

		whatsAppCache.removeUserKeysFromCache(null);

	}

	@Test
	public void clearCacheTest() {

		whatsAppCache.clearContextCache();

	}

}
