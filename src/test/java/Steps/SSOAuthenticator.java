package Steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

        @Test
        public class SSOAuthenticator {

            private static final String AUTH_URL = "https://auth.example.com/oauth/token";
            private static final String CLIENT_ID = "your_client_id";
            private static final String CLIENT_SECRET = "your_client_secret";
            private static final String GRANT_TYPE = "client_credentials";

            public static String getAuthToken() {
                Response response = RestAssured
                        .given()
                        .formParam("grant_type", GRANT_TYPE)
                        .formParam("client_id", CLIENT_ID)
                        .formParam("client_secret", CLIENT_SECRET)
                        .post(AUTH_URL);

                return "Bearer " + response.jsonPath().getString("access_token");
            }
        }







