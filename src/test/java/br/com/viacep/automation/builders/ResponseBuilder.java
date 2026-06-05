package br.com.viacep.automation.builders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {
    
    public static ResponseSpecification getSucessResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.BODY)
            .build();
    }

    public static ResponseSpecification getBadRequestResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.BODY)
            .expectContentType(ContentType.HTML)
            .build();
    }
}