# Testes Automatizados - ViaCEP API

## Objetivo
Este projeto tem como objetivo validar o comportamento da API pública do ViaCEP(https://viacep.com.br) através de testes automatizados utilizando boas práticas, como:

* Padrões de design
* DataProvider com dados externos (JSON)
* Relatórios com TestNG

## Tecnologias Utilizadas
* Java 17+
* TestNG
* RestAssured
* Jackson
* Maven
* Allure

# Estratégia deTestes
Os testes são organizados em 3 camadas de validação:
- **Dados:** múltiplos inputs são utilizados via `@DataProvider`, cobrindo CEP's válidos, inexistentes e com formato inválido
- **Contrato:** validação de schema JSON garantindo que a estrutura da resposta não quebra
- **Regras de Negócio:** asserções nos dados retornados (soft assert para dados válidos e hard assert para dados inválidos)

## Execução dos Testes
* Via Maven:
``` mvn clean test ```

# Visualização do Report
* Via Maven:
``` mvn allure:serve ```

- Acessar o report:
http://localhost:5050

## Cenários
## Cenários de teste

### GET /ws/{cep}/json

**Casos de Sucesso**
| ID | Cenário | Resultado Esperado |
|---|---|---|
| CT01 | CEP válido | 200, dados do endereço corretos |
| CT04 | Validar schema da resposta para CEP válido | 200, response segue contrato success-response-schema.json |

**Casos de Erro**
| ID | Cenário | Resultado Esperado |
|---|---|---|
| CT02 | CEP inexistente | 200, body contém erro: "true" |
| CT03 | CEP com formato inválido | 400 Bad Request, body contém html |

## Documentação do projeto
https://github.com/danielavescia/api-test-viacep/wiki

