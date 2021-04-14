/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.service.cache;

import java.util.Map;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.everis.eva.utils.constants.CacheConstants;

@Service
public class WhatsAppCache {

	private final static Logger logger = ESAPI.getLogger(WhatsAppCache.class);

	@Cacheable(value = CacheConstants.WHATSAPP_ID, key = "#phoneNumber")
	public Map<String, Object> getUserKeys(String phoneNumber) {
		return null;
	}

	@CachePut(value = CacheConstants.WHATSAPP_ID, key = "#phoneNumber")
	public Map<String, Object> setUserKeys(String phoneNumber, Map<String, Object> keys) {
		return keys;
	}

	@CacheEvict(value = CacheConstants.WHATSAPP_ID, key = "#phoneNumber", allEntries = true)
	public void removeUserKeysFromCache(String phoneNumber) {
		logger.info(Logger.EVENT_SUCCESS, "clearContextCache invoked");
	}

	@CacheEvict(value = CacheConstants.WHATSAPP_ID, allEntries = true)
	public void clearContextCache() {
		logger.info(Logger.EVENT_SUCCESS, "clearContextCache invoked");
	}
	
	@CacheEvict(value = "eva-configuration", allEntries = true)
	public void clearConfig() {
		logger.info(Logger.EVENT_SUCCESS, "clearConfigCache invoked");
	}


}
