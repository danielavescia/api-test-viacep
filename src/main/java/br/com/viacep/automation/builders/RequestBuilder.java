package br.com.viacep.automation.builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

private static final String VIACEP_BASE_URL = "https://viacep.com.br/ws";

    public static RequestSpecification getDefaultRequestSpec(){

        return new RequestSpecBuilder()
                .setBaseUri(VIACEP_BASE_URL)
                .setBasePath("/{cep}/json/")
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}