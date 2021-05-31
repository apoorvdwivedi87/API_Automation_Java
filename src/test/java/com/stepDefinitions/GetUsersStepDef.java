package com.stepDefinitions;

import static org.hamcrest.MatcherAssert.*;
import com.POJO.Root;
import com.POJO.RootArrayList;
import com.api.RequestBuilderUtility.RequestBuilder;
import com.api.RequestBuilderUtility.RequestOperations;
import com.api.applicationSettings.Settings;
import com.api.routes.RequestRoute;
import com.applicationContext.AppContext;
import com.generic.RestResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsersStepDef {

	private RequestOperations requestOperation;
	private AppContext appContext;
	private RequestSpecification requestSpecification;
	private Response response;

	public GetUsersStepDef(RequestOperations requestOpeartaions, AppContext _appContext) {

		requestOperation = requestOpeartaions;
		this.appContext = _appContext;
	}

	@When("user hits the API for a {string} request with users end point")
	public void user_hits_the_api_for_a_request_with_users_end_point(String methodType) {
		
		 requestSpecification = this.appContext.reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
		.setRequestSpecification().getRequest();
		
		 response = requestOperation.getResponse(requestSpecification, RequestRoute.getAllUsers(), methodType);
	}

	@Then("user should get all the users information")
	public void user_should_get_all_the_user_information() {
		//RootArrayList rootArrayList = this.appContext.response.getBody().as(RootArrayList.class);
		//System.out.println(rootArrayList.getPer_page());
		//System.out.println(rootArrayList.getDataList().get(0).getFirst_name());
		
		RestResponse<RootArrayList> allUsers = RestResponse.getAllUsers(response);
		System.out.println(allUsers.getBody().data.get(0).first_name);
	}

	@Then("information related to specific user should get displayed")
	public void information_related_to_specific_user_should_get_displayed() {
		
		RestResponse<Root> users = RestResponse.getUsers(response);
		System.out.println(users.getBody().getData().first_name);
		
		
	}

	@Then("schema of the json response should match with the predefined schema")
	public void schema_of_the_json_response_should_match_with_the_predefined_schema() {
		var responseBody = this.appContext.response.getBody().asString();
		assertThat(responseBody, JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleUser_responseSchema.json"));
	}

	@When("user hits the API for a {string} request with user end point for {string} user")
	public void user_hits_the_api_for_a_request_with_user_end_point_for_user(String methodType, String userID) {
		
		requestSpecification = this.appContext.reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().getRequest();
		
		 response = requestOperation.getResponse(requestSpecification, RequestRoute.getUser(userID), methodType);
	}

	@When("user hits the API for a GET request")
	public void user_hits_the_api_for_a_get_request() {
		
		requestSpecification = this.appContext.reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().getRequest();
		
		requestOperation.getResponse(requestSpecification, "/users?page=2", "GET");

	}

}
