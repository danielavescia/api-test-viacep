package br.com.viacep.automation.assertions;

import org.testng.asserts.SoftAssert;
import br.com.viacep.automation.model.Cep;

public class CepAssert {

    public static void assertEquals(Cep actual, Cep expected){
        
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual.getCep(), expected.getCep());
        softAssert.assertEquals(actual.getLogradouro(), expected.getLogradouro());
        softAssert.assertEquals(actual.getBairro(), expected.getBairro());
        softAssert.assertEquals(actual.getLocalidade(), expected.getLocalidade());
        softAssert.assertEquals(actual.getUf(), expected.getUf());
        softAssert.assertEquals(actual.getEstado(), expected.getEstado());
        softAssert.assertEquals(actual.getRegiao(), expected.getRegiao());
        softAssert.assertEquals(actual.getDdd(), expected.getDdd());
        
        softAssert.assertAll();
    }
}
