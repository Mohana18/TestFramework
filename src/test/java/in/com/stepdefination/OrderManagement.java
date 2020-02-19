package in.com.stepdefination;

import RestAssured.GetApi;
import RestAssured.PostApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderManagement {
	GetApi get = new GetApi();
	PostApi post = new PostApi();

	@When("Get token code to create order")
	public void get_token_code_to_create_order() {
		post.getToken();

	}

	@When("Create new order")
	public void create_new_order() {
		post.createOrder();
	}

	@Then("Get Order details by id")
	public void get_Order_details_by_id() {
		post.getOrderById();
	}


}
