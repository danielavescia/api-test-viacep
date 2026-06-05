package br.com.viacep.automation.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import br.com.viacep.automation.assertions.CepAssert;
import br.com.viacep.automation.builders.RequestBuilder;
import br.com.viacep.automation.builders.ResponseBuilder;
import br.com.viacep.automation.pojo.Cep;
import br.com.viacep.automation.pojo.CepScenario;
import br.com.viacep.automation.provider.CepDataProvider;

public class CepTest {

    @Test(description = "CT01- Validar CEP Válido", dataProvider = "validCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnCepSuccesfuly(CepScenario scenario){
        Cep actual = 
            given()
                .spec(RequestBuilder.getDefaultRequestSpec())
                .pathParam("cep", scenario.getInput())
            .when()
                .get()
            .then()
                .spec(ResponseBuilder.getSucessResponseSpec())
                .extract().as(Cep.class);
        
        CepAssert.assertEquals(actual, scenario.getExpected());
    }

    @Test(description = "CT02- Validar CEP inválido com formato incorreto", dataProvider = "cepsDontExist",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnErrorForCepNotFound(CepScenario scenario){
            given()
                .spec(RequestBuilder.getDefaultRequestSpec())
                .pathParam("cep", scenario.getInput())
            .when()
                .get()
            .then()
                .spec(ResponseBuilder.getSucessResponseSpec())
                .body("erro", equalTo("true"));
    }

   @Test(description = "CT03- Validar CEP inexistente", dataProvider = "invalidCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnErrorForInvalidCepFormat(CepScenario scenario){
            given()
                .spec(RequestBuilder.getDefaultRequestSpec())
                .pathParam("cep", scenario.getInput())
            .when()
                .get()
            .then()
                .spec(ResponseBuilder.getBadRequestResponseSpec());
    }

    @Test(description = "CT04- Validar schema da resposta para CEP válido", dataProvider = "validCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldValidateSuccessResponseSchema(CepScenario scenario){
            given()
                .spec(RequestBuilder.getDefaultRequestSpec())
                .pathParam("cep", scenario.getInput())
            .when()
                .get()
            .then()
                .spec(ResponseBuilder.getSucessResponseSpec())
                .body(matchesJsonSchemaInClasspath("schemas/sucess-response-schema.json"));
    }
}