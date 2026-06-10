package br.com.viacep.automation.builders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {
    
    public static ResponseSpecification getSucessResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();
    }

    public static ResponseSpecification getBadRequestResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(400)
            .expectContentType(ContentType.HTML)
            .build();
    }
}