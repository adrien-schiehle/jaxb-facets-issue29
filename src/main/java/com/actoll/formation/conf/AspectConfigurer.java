package com.actoll.formation.conf;

import com.actoll.formation.services.aop.LoginServiceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfigurer {

    @Bean
    public LoginServiceAspect loginServiceAspect() {
        return new LoginServiceAspect();
    }
}
