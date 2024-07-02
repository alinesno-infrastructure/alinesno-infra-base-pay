package com.alinesno.infra.base.pay.channel.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
public class StartupRunner implements CommandLineRunner {

	@Override
	public void run(String... args) {
		log.info("startup runner");
	}

}
