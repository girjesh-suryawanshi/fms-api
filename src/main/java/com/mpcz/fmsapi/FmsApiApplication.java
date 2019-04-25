package com.mpcz.fmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mpcz.fmsentity"})
@EnableJpaRepositories(basePackages = {"com.mpcz.fmsdao.repository"})
@ComponentScan(basePackages = {"com.mpcz.fmsdao","com.mpcz.fmsapis"})

public class FmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsApiApplication.class, args);
	}

}
