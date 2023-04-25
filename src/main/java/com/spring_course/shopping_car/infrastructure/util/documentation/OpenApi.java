package com.spring_course.shopping_car.infrastructure.util.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("ShoppingCar").version("1.0")
                        .description("Api para gestionar un carrito de compras")
                        .contact(new Contact().name("sara").email("ejemplo@gmail.com")));
    }

}
