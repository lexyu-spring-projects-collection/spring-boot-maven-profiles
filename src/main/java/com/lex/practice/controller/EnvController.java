package com.lex.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author : Lex Yu
 */
@Slf4j
@RestController
@RequestMapping("/env")
public class EnvController {

	@Autowired
	private Environment env;

	@RequestMapping("/get-current")
	public Mono<ResponseEntity<?>> getCurrentEnv() {
		String[] actProfile = env.getActiveProfiles();

		log.info("Active Profile = {}", actProfile);

		return Mono.just(ResponseEntity.ok(actProfile));
	}

}
