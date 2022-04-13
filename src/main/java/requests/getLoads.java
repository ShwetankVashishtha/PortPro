package requests;

import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;

public class getLoads {

    String requestBody = "{\n" +
            "    \"status\":[\"PENDING\"]\n" +
            "}";

    public int postRequest() {
        Response response = given()
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YzhhM2FhNjk3NjYxMDQ5YzZkYjI1N2YiLCJpYXQiOjE2NDY5NDk3OTV9.1u_ebe9r8pxYuqMznrHnJ7u3oVBJkf55tRSBaUqD1Oc")
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://stagingapi.app.portpro.io/tms/getLoads")
                .then()
                .extract().response();

        List list = response.jsonPath().getList("data.status");
        return list.size();
    }
}
