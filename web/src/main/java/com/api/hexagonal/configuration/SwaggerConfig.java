package com.api.hexagonal.configuration;

import com.api.hexagonal.constants.MensajeHttpStatus;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase de configuracion de Swagger
 * @author Ezequiel Cristeche
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.api.hexagonal"))
                .paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo())
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .tags(new Tag("Hexagonal", "HEXAGONAL"))
                .globalResponseMessage(RequestMethod.GET, obtenerMensajesComunes())
                .globalResponseMessage(RequestMethod.POST, obtenerMensajesComunes());
    }

    private List<ResponseMessage> obtenerMensajesComunes() {
        List<ResponseMessage> responseMessage = new ArrayList<>();
        responseMessage.add(new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value())
                .message(MensajeHttpStatus.REQUEST_INCORRECTO).build());
        responseMessage.add(new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value())
                .message(MensajeHttpStatus.NO_AUTORIZADO).build());
        responseMessage.add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(MensajeHttpStatus.ERROR_INTERNO).build());
        responseMessage.add(new ResponseMessageBuilder().code(HttpStatus.CONFLICT.value())
                .message(MensajeHttpStatus.CONFLICT).build());
        return responseMessage;
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("API HEXAGONAL")
                .description("Api con arquitectura hexagonal con enfoque DDD").version("1.0.0").build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("apiKey", authorizationScopes));
    }

}