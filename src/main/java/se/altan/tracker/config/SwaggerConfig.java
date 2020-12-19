package se.altan.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**
 * Swagger documentation for all rest services
 *@author Parasuram
 */
public class SwaggerConfig {


    // Creating bean
    @Bean
    public Docket api() {
        // creating constructor of Docket class that accepts parameter DocumentationType
        return new Docket(DocumentationType.SWAGGER_2);

    }
}
