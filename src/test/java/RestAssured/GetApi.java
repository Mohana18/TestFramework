package RestAssured;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetApi {

	static String ROOT_URI;
	Response res;
	String json;
	JsonPath jsonpath;
	Object res1;

	public void GetBaseURL() {

		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/employees";

	}

	public void GetApiRequest() {
		res = given().when().get();
		System.out.println("response of get :"+res.getBody().asString());
	}

	public void ValidateApiResponse() {

		json = res.asString();
		jsonpath = new JsonPath(json);
		res1 = jsonpath.get("data[0]");
		
		Assert.assertEquals(200, res.getStatusCode());
	    System.out.println("get response : "+res.getBody().asString());
		System.out.println("first data : "+res1);
		

	}

}
