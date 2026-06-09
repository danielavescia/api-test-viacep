package br.com.viacep.automation.builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecification getDefaultRequestSpec(){

        return new RequestSpecBuilder()
                .setBasePath("/{cep}/json/")
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}