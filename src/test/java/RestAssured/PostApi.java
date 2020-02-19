package RestAssured;

import static io.restassured.RestAssured.given;
import com.google.gson.Gson;
import in.com.hcl.dto.Constants;
import in.com.hcl.dto.Location;
import in.com.hcl.dto.Login;
import in.com.hcl.dto.Order;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostApi {

	Response response;
	int createdOrderId;
	String createdOrderDesc;
	String token;
	Header header;
	Order respOrder;

	public PostApi() {
		RestAssured.baseURI = "http://localhost:8080";

	}

	public RequestSpecification setHeader(String token) {

		return given().contentType("application/json").header("Authorization", "Bearer " + token);

	}


	public void getToken() {

		Login login = new Login();
		login.setPassword("1234");
		login.setUsername("test");

		RestAssured.basePath=Constants.LOGIN;
		response = given().contentType("application/json").body(login).when().post();
		System.out.println("Token is "+response.jsonPath().getString("token"));
	}


	public void createOrder() {

		token = response.jsonPath().getString("token");

		Order order = new Order();
		Location pickup = new Location();
		pickup.setLatitude(new Double("123.12"));
		pickup.setLongitude(new Double("123.12"));

		order.setPickup(pickup);
		order.setDelivery(pickup);
		order.setDescription("despcription");
		order.setFood(true);
		order.setVip(true);

		RestAssured.basePath=Constants.CREATE_OREDER;
		response = setHeader(token).body(order).when().post();

		Gson gson = new Gson();
		respOrder = gson.fromJson(response.asString(), Order.class);

		createdOrderId = respOrder.getId();
		createdOrderDesc = respOrder.getDescription();
		System.out.println("Response :"+response.toString());
	}
	public void getOrderById() {

		int orderID = respOrder.getId();

		RestAssured.basePath=Constants.CREATE_OREDER+"/"+orderID;
		response = setHeader(token).get();
		try {
			Assert.assertEquals(String.valueOf(createdOrderId), String.valueOf(response.jsonPath().getInt("id")));
			Assert.assertEquals(createdOrderDesc, response.jsonPath().getString("description"));
			System.out.println("------- Order created is matching ------");
		} catch (Exception e) {
			System.out.println("created order id not matching");
		}

	}

}
