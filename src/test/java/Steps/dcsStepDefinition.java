package Steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.FileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import resourcers.CONS.DCSCONSTANTSOK;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class dcsStepDefinition {

    private Response response;
    private JSONObject json;

    @Before
    public void dcsSetup(){
        baseURI = DCSCONSTANTSOK.URL_DCS_BASE;
        Response resp = RestAssured.request(Method.GET, "https://api.dcs-hml.internal.dock.tech/health");
        ValidatableResponse teste = resp.then();
        teste.statusCode(200);
    }

    @Given("Todas as informações de Payload OK")
    public void todas_as_informações_de_payload_ok() throws Exception {

        JSONParser parser = new JSONParser();
        json = (JSONObject) parser.parse( new FileReader("C:\\projetos\\poctTestCucumber\\src\\test\\java\\resourcers\\PlaceHolder.java"));
    }
    @When("Com a chave <placeholders> vazia")
    public void com_a_chave_placeholders_vazia(String key, String newValue )  {
        //alterar o campo conforme parâmetro
        json.put(key,newValue);

                 Response resp = given()
                .header(DCSCONSTANTSOK.HEADER_CONTENT_TYPE, DCSCONSTANTSOK.CONTENT_TYPE_JSON)
                .body(json)
                .post(DCSCONSTANTSOK.URL_DCS_BASE + "/v1/events");
    }
    @Then("Processar e estabelecer a comunicação com o falcon passando as informações.")
    public void processar_e_estabelecer_a_comunicação_com_o_falcon_passando_as_informações() {

        response.then().statusCode(202)
                .body("$",hasKey("event_id"));
    }

}
