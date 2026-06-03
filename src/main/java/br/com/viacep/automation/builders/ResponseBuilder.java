package br.com.viacep.automation.builders;

import javax.swing.text.html.HTML;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {

 public static ResponseSpecification getDefaultResponseSpec(){

        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .log(LogDetail.BODY)
            .build();
    }

    public static ResponseSpecification getSucessResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();
    }

    public static ResponseSpecification getBadRequestResponseSpec(){

        return new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .expectContentType(ContentType.HTML)
            .build();
    }
}
