package in.com.hcl.database;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPIDummy 
{

	
	
final static String ROOT_URI = "http://dummy.restapiexample.com/api/v1";

@Test
	public void test123() 
	{
		String Js="{"+
		           " \"id\": \"103\","+
		            "\"employee_name\": \"Yuri Berry\","+
		            "\"employee_salary\": \"675000\","+
		           " \"employee_age\": \"40\","+
		          "  \"profile_image\": \"\""+
		       " }";
			
			Response postreponse=given().header("Content-Type","application/json").body(Js).when().post(ROOT_URI + "/create");
			assertEquals(200, postreponse.getStatusCode());
			System.out.println("post repose..."+postreponse.asString());

			JsonPath postjsonPath = new JsonPath(postreponse.asString());
			String post_response_id=postjsonPath.get("data.id");
			
			Response GETresponse = given().contentType(ContentType.JSON)
					.when().get(ROOT_URI + "/employee/"+post_response_id);
			assertEquals(200, GETresponse.getStatusCode());

			System.out.println("Get repose..."+GETresponse.asString());
			
			
			String js="{"+
		           " \"id\": \"22\","+
		         "  \"employee_name\": \"Yuri Berry\","+
		          " \"employee_salary\": \"675000\","+
		          " \"employee_age\": \"40\","+
		          " \"profile_image\": \"\""+
		      "  }";
			Response putresponse = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).when().put(ROOT_URI+"/update/21");
			assertEquals(200,putresponse.getStatusCode());
			System.out.println("Put resp..."+putresponse.asString());
		

	  
	}

}
