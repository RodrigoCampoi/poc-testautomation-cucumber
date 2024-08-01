package Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetailBankTransactionsStepsDefinition {

    @Given("Passando todas as informações de uma transação pix OK")
    public void passando_todas_as_informações_de_uma_transação_ok() {
        System.out.println("Realizar os Pré Requisitos para a chamada do endpoint");
    }
    @When("Com a chave x")
    public void com_a_chave_x() {
        System.out.println("Chamada com o parâmetro Secret-Key");
    }

    @Then("Comunicação com o falcon com sucesso e mais")
    public void comunicação_com_o_falcon_com_sucesso_e_mais() {
        System.out.println("Validação do Json");
    }
}
