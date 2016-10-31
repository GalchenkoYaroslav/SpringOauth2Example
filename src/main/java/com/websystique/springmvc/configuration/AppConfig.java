package com.websystique.springmvc.configuration;

import com.websystique.springmvc.service.DetailService;
import com.websystique.springmvc.service.impl.DetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yaroslav on 31.10.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    public DetailService detailService() {
        return new DetailServiceImpl();
    }
}
