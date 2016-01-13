package com.actoll.formation;

import com.actoll.formation.services.ws.LoginWS;
import com.actoll.formation.services.ws.LoginWSImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = {"com.actoll.formation.services"} )
public class UnitTestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorld.class, args);
    }

    @Bean
    public CommonOperations dbOperations() {
        return new CommonOperations();
    }


    @Bean
    public LoginWSImpl myWSBean() {
        return new LoginWSImpl();
    }
}
