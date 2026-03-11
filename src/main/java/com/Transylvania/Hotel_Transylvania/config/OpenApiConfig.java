package com.Transylvania.Hotel_Transylvania.config;


import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI hotelTransylvaniaAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Hotel Transylvania API")
                            .description("REST API for managing hotel orders and users")
                            .version("1.0.0"));
        }
    }

