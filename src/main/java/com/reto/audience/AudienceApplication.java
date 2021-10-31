package com.reto.audience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 * @author LORENA NAVAS
 */

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.reto.audience.entity"})
public class AudienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudienceApplication.class, args);
	}

}
