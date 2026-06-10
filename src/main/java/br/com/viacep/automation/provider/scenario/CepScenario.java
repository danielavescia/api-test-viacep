package br.com.viacep.automation.provider.scenario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.viacep.automation.model.Cep;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepScenario {

    private String cenario;
    private String input;
    private Cep expected;
}