package com.mpcz.fmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mpcz.fmsentity.bean", "com.mpcz.fmsapi"})
@EnableJpaRepositories(basePackages = {"com.mpcz.fmsdao.repository", "com.mpcz.fmsapi"})
@ComponentScan(basePackages = {"com.mpcz.fmsdao.dao", "com.mpcz.fmsapi"})
public class FmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsApiApplication.class, args);
    }

}
