package in.com.stepdefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITesting {

	final static String ROOT_URI = "http://dummy.restapiexample.com/api/v1";

	private static final String JSONPath = null;

	Response postreponse;
	Response GETresponse;
	String post_response_id;
	Response GETresponse2;

	@Given("I created employee")
	public void i_created_employee() {
		String Js = "{" + " \"id\": \"103\"," + "\"employee_name\": \"Yuri Berry\","
				+ "\"employee_salary\": \"675000\"," + " \"employee_age\": \"40\"," + "  \"profile_image\": \"\""
				+ " }";

		postreponse = given().header("Content-Type", "application/json").body(Js).when().post(ROOT_URI + "/create");
		assertEquals(200, postreponse.getStatusCode());
		System.out.println("post repose..." + postreponse.asString());

	}

	@When("I hit get request1")
	public void i_hit_get_request1() {

		JsonPath postjsonPath = new JsonPath(postreponse.asString());
		post_response_id = postjsonPath.get("data.id");

		GETresponse = given().contentType(ContentType.JSON).when().get(ROOT_URI + "/employee/" + post_response_id);

	}

	@Then("I should get created employee")
	public void i_should_get_created_employee() {
		assertEquals(200, GETresponse.getStatusCode());

		System.out.println("Get repose..." + GETresponse.asString());
	}

	@Given("I update an existing employee")
	public void i_update_an_existing_employee() {

		String js = "{" + " \"id\": \"22\"," + "  \"employee_name\": \"Yuri Berry\","
				+ " \"employee_salary\": \"675000\"," + " \"employee_age\": \"40\"," + " \"profile_image\": \"\""
				+ "  }";
		Response putresponse = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).when()
				.put(ROOT_URI + "/update/" + post_response_id);
		assertEquals(200, putresponse.getStatusCode());
		System.out.println("Put resp..." + putresponse.asString());

	}

	@When("I hit get request2")
	public void i_hit_get_request2() {
		GETresponse2 = given().contentType(ContentType.JSON).when().get(ROOT_URI + "/employee/" + post_response_id);

		assertEquals(200, GETresponse.getStatusCode());

	}

	@Then("I should get updated employee record")
	public void i_should_get_updated_employee_record() {
		assertEquals(200, GETresponse.getStatusCode());

		JsonPath js = new JsonPath(GETresponse2.asString());
		System.out.println(" ID " + js.get("data.id"));
		System.out.println(" employee_name " + js.get("data.employee_name"));
		System.out.println("Age " + js.get("data.Age"));

	}

}
