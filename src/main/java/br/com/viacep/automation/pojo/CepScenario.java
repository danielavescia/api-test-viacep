package br.com.viacep.automation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepScenario {

    private String cenario;
    private String input;
    private Cep expected;
}