package requests;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getLoads {

	String requestBody = "{\n" + "    \"status\":[\"PENDING\"]\n" + "}";

	public static String getToken() {

		HashMap<String, String> payLoad = new HashMap<>();
		payLoad.put("email", "testport14@gmail.com");
		payLoad.put("password", "123456789");
		payLoad.put("deviceType", "WEB");

		Response res = given().contentType(ContentType.JSON).baseUri("https://stagingapi.app.portpro.io").body(payLoad)
				.when().post("/login");
		assertEquals(res.statusCode(), 200);
		String token = res.path("data.token");
		System.out.println(token);
		return token;
	}

	public static String getTotalAmount(String loadNumber) {

		String token = getToken();
		Response resp = given().auth().oauth2(token).queryParam("reference_number", loadNumber)
				.baseUri("https://stagingapi.app.portpro.io").contentType(ContentType.JSON).when()
				.get("/tms/getLoadDetail");
		System.out.println(resp.asPrettyString());
		assertEquals(resp.statusCode(), 200);
		int totalAmount = resp.path("data.totalAmount");
		String total_Amount = String.valueOf(totalAmount);
		return total_Amount;
	}

	public static void main(String[] args) {
		Faker f = new Faker();
		System.out.println(f.address().streetAddress());
	}
}
