package requests;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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

	public static void deleteCreatedLoad(String loadNumber) {

		String load_ID = null;
		String token = getToken();
		Response resp = given().auth().oauth2(token).baseUri("https://stagingapi.app.portpro.io")
				.contentType(ContentType.JSON).when().get("/tms/getLoads");
		assertEquals(resp.statusCode(), 200);
		String load_num = resp.path("data[0].reference_number");
		if (load_num.equals(loadNumber)) {

			load_ID = resp.path("data[0]._id");
			System.out.println("=====>" + load_ID);
			HashMap<String, String> id = new HashMap<String, String>();
			id.put("_id", load_ID);
			Response deleteLoad = given().auth().oauth2(token).body(id).baseUri("https://stagingapi.app.portpro.io")
					.when().post("/tms/removeLoad");
			System.out.println(deleteLoad);
			assertEquals(deleteLoad.statusCode(), 200);
		} else {
			System.out.println("Load is not deleted.");
		}
	}

	public static String getTotalAmount(String loadNumber) {

		String token = getToken();
		Response resp = given().auth().oauth2(token).queryParam("reference_number", loadNumber)
				.baseUri("https://stagingapi.app.portpro.io").contentType(ContentType.JSON).when()
				.get("/tms/getLoadDetail");
		System.out.println(resp.asPrettyString());
		assertEquals(resp.statusCode(), 200);
		float totalAmount = resp.path("data.totalAmount");
		String total_Amount = String.valueOf(totalAmount);
		return total_Amount;
	}

	public static void deleteDriver(String email) {
		System.out.println("********" +email);
		String driverId = null;
		String token = getToken();
		Response resp = given().auth().oauth2(token).baseUri("https://stagingapi.app.portpro.io")
				.contentType(ContentType.JSON).when().get("/carrier/getAllDriver");
		assertEquals(resp.statusCode(), 200);
		
		int driverCount = resp.path("data.count");
		System.out.println("=====>"+driverCount);
		for(int i = 0; i<driverCount;i++) {
			
			if(resp.path("data.data["+i+"].email").equals(email.toLowerCase())) {
				driverId = resp.path("data.data["+i+"]._id");
				System.out.println("====>" +driverId);
				HashMap<String, String> id = new HashMap<>();
				id.put("_id", driverId);
				id.put("isDeleted", "true");
				Response deleteDriver = given().auth().oauth2(token).body(id).baseUri("https://stagingapi.app.portpro.io").log().all()
						.when().delete("/carrier/deleteDriverProfile");
				assertEquals(deleteDriver.statusCode(), 200);
				System.out.println("Driver deleted successfully");
				break;
			}
		}
	}
	
	public static void deleteCustomer(String companyName) {
		
		String token = getToken();
		String custID = null;
		
		RequestSpecification reqSpec = null;
		RequestSpecBuilder build = new RequestSpecBuilder().setUrlEncodingEnabled(false);
		AuthenticationScheme auth = RestAssured.oauth2(token);
		build.setAuth(auth);
		build.setBaseUri("https://stagingapi.app.portpro.io");
		build.setBasePath("carrier/getTMSCustomers");
		build.addQueryParam("customerType", "%5B%22caller%22%2C%22ALL%22%5D");
		build.log(LogDetail.ALL);
		/*
		 * Response resp = given().auth().oauth2(token).queryParam("customerType",
		 * "%5B%22caller%22%2C%22ALL%22%5D").baseUri("https://stagingapi.app.portpro.io"
		 * ).log().all() .when().get("carrier/getTMSCustomers");
		 */
		
		reqSpec = build.build();
		Response resp = given().spec(reqSpec).when().get();
		assertEquals(resp.statusCode(), 200);
		int count = resp.jsonPath().getList("data").size();
		System.out.println("The Count of company is :" +count);
		System.out.println("-------" +companyName);
		String str = resp.path("data["+(count-1)+"].company_name");
		System.out.println("-=-=-=-=-=-=" +str);
		if(resp.path("data["+(count-1)+"].company_name").toString().toLowerCase().trim().equals(companyName.toLowerCase().trim())) {
			custID = resp.path("data["+(count-1)+"]._id");
			HashMap<String, String> id = new HashMap<String, String>();
			id.put("_id", custID);
			id.put("isDeleted", "true");
			System.out.println("=====>" +custID);
			Response deleteLoad = given().auth().oauth2(token).body(id).baseUri("https://stagingapi.app.portpro.io").log().all()
					.when().post("/carrier/removeTMSCustomer");
			System.out.println(deleteLoad);
			assertEquals(deleteLoad.statusCode(), 200);
		}
		else {
			
		}
		for(int i = 0; i<count; i++) {
			String s = resp.path("data["+i+"].company_name");
			System.out.println(s);
			System.out.println("*********" +companyName);
			if(resp.path("data["+i+"].company_name").toString().toLowerCase().trim().equals(companyName.toLowerCase().trim())) {
				
				custID = resp.path("data["+i+"]._id");
				HashMap<String, String> id = new HashMap<String, String>();
				id.put("_id", custID);
				id.put("isDeleted", "true");
				Response deleteLoad = given().auth().oauth2(token).body(id).urlEncodingEnabled(false).baseUri("https://stagingapi.app.portpro.io")
						.when().post("/carrier/removeTMSCustomer");
				System.out.println(deleteLoad);
				assertEquals(deleteLoad.statusCode(), 200);
			}
			else {
				System.out.println("No customer Id found with mathing company name");
			}
		}
		
	}

	public static void main(String[] args) {
		Faker f = new Faker();
		System.out.println(f.address().streetAddress());
	}
}
