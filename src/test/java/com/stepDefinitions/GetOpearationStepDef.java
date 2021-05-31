package com.stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.testng.Assert;

import com.api.RequestBuilderUtility.RequestBuilder;
import com.api.RequestBuilderUtility.RequestBuilderFactory;
import com.api.RequestBuilderUtility.RequestOperations;
import com.api.applicationSettings.Settings;
import com.api.responseUtilities.ResponseOperations;
import com.api.routes.RequestRoute;
import com.applicationContext.AppContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GetOpearationStepDef {

	private RequestOperations requestOperation;
	private ResponseOperations responseOperation;
	private AppContext appContext;

	public GetOpearationStepDef(RequestOperations requestOpeartaions, ResponseOperations responseOperations,
			AppContext _appContext) {

		requestOperation = requestOpeartaions;
		responseOperation = responseOperations;
		this.appContext = _appContext;
	}

	@Given("user has an baseURI")
	public void user_has_an_base_uri() {
		this.appContext.reqBuildFactory = new RequestBuilderFactory();
	}

	@Then("user should get a {int} status code")
	public void user_should_get_a_status_code(int expectedStatusCode) {
		
		//int actualStatusCode = this.appContext.responseOperations.getStatusCode(this.appContext.response);
		int actualStatusCode = responseOperation.getStatusCode(this.appContext.response);
		
		
		responseOperation.printBody(responseOperation.getResponseBody(this.appContext.response));
		Assert.assertTrue(expectedStatusCode == actualStatusCode);
	}

	@Then("user should get {string} as page count")
	public void user_should_get_as_page_count(String expectedValue) {
		String actualValue = responseOperation.getJsonObjectValue(this.appContext.response, "page");
		Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
	}

	@Then("user should get {int} records per page")
	public void user_should_get_records_per_page(Integer expectedDataCount) {
		int actualDataCount = responseOperation.getJsonArraySize(this.appContext.response, "data");
		Assert.assertTrue(expectedDataCount == actualDataCount);
	}

	@Then("user should a recordarray with lastname {string}")
	public void user_should_a_recordarray_with_lastname(String lastName) {
		String lastNameJsonPath = "data.last_name";
		List<String> getfilteredLastName = responseOperation.getfilteredLastName(this.appContext.response,
				lastName, lastNameJsonPath);
		assertTrue(lastName.equalsIgnoreCase(getfilteredLastName.get(0)));
	}

	@When("user hits the API for a {string} request with all users end point for {string} page")
	public void user_hits_the_api_for_a_request_with_all_users_end_point_for_page(String methodType, String pageNumb) {

		RequestSpecification request = this.appContext.reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().getRequest();
		requestOperation.getResponse(request, RequestRoute.getAllUsersOnPage(pageNumb), methodType);
	}
}
