package com.actoll.formation.conf;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 */
@Configuration
@ImportResource("classpath:/cxf-servlet.xml")
public class WsConfigurer {

    public static final String WEB_SERVICES_URL = "/services/*";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    public ServletRegistrationBean configWS( ) {
        log.info("Registering web services on {}", WEB_SERVICES_URL) ;
        ServletRegistrationBean registration = new ServletRegistrationBean( new CXFServlet(), WEB_SERVICES_URL);
        return registration;
    }


}
