package br.com.dock.tech;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class Config {

    private static final String AUTH_URL = "https://auth.example.com/oauth/token";
    private static final String CLIENT_ID = "your_client_id";
    private static final String CLIENT_SECRET = "your_client_secret";
    private static final String GRANT_TYPE = "client_credentials";

    @Before
    public void dcsSetup() {
        baseURI = Constants.URL_DCS_BASE;
        basePath = "/v1";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", getAuthToken())
                .setContentType(ContentType.JSON).
                build();
    }

    public static String getAuthToken() {
        Response response = RestAssured
                .given()
                .formParam("grant_type", GRANT_TYPE)
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .post(AUTH_URL);

        return STR."Bearer \{response.jsonPath().getString("access_token")}";
    }

}
