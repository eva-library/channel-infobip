/*
* eVA
* Version: 2.3.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.everis.eva.controller.dto.whatssapp.service.WhatsAppRequest;
import com.everis.eva.service.InfobipBrokerService;
import com.everis.eva.service.cache.WhatsAppCache;
import com.everis.eva.service.dto.ServiceError;
import com.everis.eva.service.dto.ServiceResult;

@RestController
public class InfobipController {

	@Autowired
	private WhatsAppCache whatsAppCache;

	@Autowired
	private InfobipBrokerService infobipBrokerService;

	@PostMapping("/conversations")
	public ResponseEntity<Object> conversation(@RequestHeader(value = "x-request-id", required = false) String xreq,               //open-tracing
											   @RequestHeader(value = "x-b3-traceid", required = false) String xtraceid,           //open-tracing
											   @RequestHeader(value = "x-b3-spanid", required = false) String xspanid,             //open-tracing
											   @RequestHeader(value = "x-b3-parentspanid", required = false) String xparentspanid, //open-tracing
											   @RequestHeader(value = "x-b3-sampled", required = false) String xsampled,           //open-tracing 
											   @RequestHeader(value = "x-b3-flags", required = false) String xflags,               //open-tracing
											   @RequestHeader(value = "x-ot-span-context", required = false) String xotspan,       //open-tracing
											   @RequestBody WhatsAppRequest request) {

		try{
			infobipBrokerService.resolve(request);
			return ResponseEntity.ok(new ServiceResult("SUCCESS"));
		}
		catch (final Exception ex){
			return ResponseEntity.ok(new ServiceError(UUID.randomUUID().toString(), ex));
		}
	}

	@GetMapping("/clear-cache")
	public ResponseEntity<Object> clearCache() {
		whatsAppCache.clearContextCache();
		whatsAppCache.clearConfig();
		return ResponseEntity.ok(new ServiceResult("SUCCESS"));
	}

}

