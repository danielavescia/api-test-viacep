package br.com.viacep.automation.client;

import static io.restassured.RestAssured.given;
import br.com.viacep.automation.builders.RequestBuilder;
import io.restassured.response.ValidatableResponse;

public class CepClient {

    public ValidatableResponse getCep(String cep){
        return given()
                .spec(RequestBuilder.getDefaultRequestSpec())
                .pathParam("cep", cep)
            .when()
                .get()
            .then();
    }
}
