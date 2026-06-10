package br.com.viacep.automation.tests.cep;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import br.com.viacep.automation.assertions.CepAssert;
import br.com.viacep.automation.builders.ResponseBuilder;
import br.com.viacep.automation.client.CepClient;
import br.com.viacep.automation.model.Cep;
import br.com.viacep.automation.provider.CepDataProvider;
import br.com.viacep.automation.provider.scenario.CepScenario;
import br.com.viacep.automation.tests.base.BaseTest;

public class CepTest extends BaseTest{

    CepClient cepClient = new CepClient();

    @Test(description = "CT01- Validar CEP Válido", dataProvider = "validCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnCepSuccesfuly(CepScenario scenario){
        Cep actual = cepClient.getCep(scenario.getInput())
                        .spec(ResponseBuilder.getSucessResponseSpec())
                        .extract().as(Cep.class);
        
        CepAssert.assertEquals(actual, scenario.getExpected());
    }

    @Test(description = "CT02- Validar CEP inválido com formato incorreto", dataProvider = "cepsDontExist",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnErrorForCepNotFound(CepScenario scenario){
           cepClient.getCep(scenario.getInput())
                .spec(ResponseBuilder.getSucessResponseSpec())
                .body("erro", equalTo("true"));
    }

   @Test(description = "CT03- Validar CEP inexistente", dataProvider = "invalidCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldReturnErrorForInvalidCepFormat(CepScenario scenario){
            cepClient.getCep(scenario.getInput())
                .spec(ResponseBuilder.getBadRequestResponseSpec());
    }

    @Test(description = "CT04- Validar schema da resposta para CEP válido", dataProvider = "validCeps",  dataProviderClass = CepDataProvider.class)
    public void shouldValidateSuccessResponseSchema(CepScenario scenario){
            cepClient.getCep(scenario.getInput())
                .spec(ResponseBuilder.getSucessResponseSpec())
                .body(matchesJsonSchemaInClasspath("schemas/sucess-response-schema.json"));
    }
}