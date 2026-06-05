package br.com.viacep.automation.provider;

import java.io.File;
import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.viacep.automation.pojo.CepScenario;

public class CepDataProvider {

    private static final ObjectMapper mapper = new ObjectMapper();

    @DataProvider(name = "validCeps")

    public static Object[][] validCeps() throws Exception{
        return loadScenarios("src/test/resources/data/valid-cep-data.json");
    }

     public static Object[][] invalidCeps() throws Exception{
        return loadScenarios("src/test/resources/data/invalid-cep-format-data.json");
    }

    public static Object[][] cepDoesnExist() throws Exception{
       return loadScenarios("src/test/resources/data/cep-doesnt-exist-data");
    }

    private static Object[][] loadScenarios(String filePath) throws Exception {
        CepScenario[] scenarios = mapper.readValue(
                new File(filePath), 
                CepScenario[].class
            );

        Object[][] data = new Object[scenarios.length][1];

        for(int i= 0; i< scenarios.length; i++){
            data[i][0] = scenarios[i];
        }
        return data;
    }
}
