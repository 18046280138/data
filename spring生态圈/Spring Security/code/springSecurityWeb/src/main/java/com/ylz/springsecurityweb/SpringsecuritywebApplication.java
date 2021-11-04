package com.ylz.springsecurityweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.ylz.springsecurityweb.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SpringsecuritywebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritywebApplication.class, args);
    }

}
