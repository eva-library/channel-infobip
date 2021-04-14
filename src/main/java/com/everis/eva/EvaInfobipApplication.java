/*
* eVA
* Version: 3.1.0
* copyright (c) 2018 everis Spain S.A
* Date: 01 December 2018
* Author: everis bots@everis.com - Guilherme Ferreira Gomes, Guilherme Durazzo
* All rights reserved
*/

package com.everis.eva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@EnableCaching
@EnableAsync
public class EvaInfobipApplication {

	public static void main(String[] args) {
		System.setProperty("org.slf4j.simpleLogger.logFile", "System.out");
		SpringApplication.run(EvaInfobipApplication.class, args);
	}

}
