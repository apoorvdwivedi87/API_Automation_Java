package com.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.POJO.User;
import com.api.RequestBuilderUtility.RequestBuilder;
import com.api.RequestBuilderUtility.RequestBuilderFactory;
import com.api.RequestBuilderUtility.RequestOperations;
import com.api.appUtilities.CommonUtilities;
import com.api.applicationSettings.Settings;
import com.api.responseUtilities.ResponseOperations;
import com.api.routes.RequestRoute;
import com.applicationContext.AppContext;
import com.google.gson.Gson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PostOperationStepDef {

	private RequestOperations requestOperation;
	private ResponseOperations responseOperation;
	//private String baseURI;
	private AppContext appContext;
	private RequestBuilderFactory reqBuildFactory;

	public PostOperationStepDef(RequestOperations requestOperations, ResponseOperations reponseOperations,
			AppContext appContext) {
		requestOperation = requestOperations;
		responseOperation = reponseOperations;
		this.appContext = appContext;
	}

	@Given("user has a base URI")
	public void user_has_a_base_uri() {
		reqBuildFactory = new RequestBuilderFactory();
		//baseURI = "https://reqres.in/api";
	}

	@When("user hits the API for a {string} request with user end point")
	public void user_hits_the_api_for_a_request_with_user_end_point(String methodType) {

		HashMap<String, String> userDetails = new HashMap<>();
		userDetails.put("name", "lmorpheus");
		userDetails.put("job", "leader");
		RequestSpecification setPostBody = reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().setPostBody(userDetails);

		requestOperation.getResponse(setPostBody, RequestRoute.setUser(), methodType);
	}

	@When("user hits the API for a {string} request with user end point with POJO class")
	public void user_hits_the_api_for_a_request_with_user_end_point_with_pojo_class(String methodType) {
		User user = new User();
		user.setJob("leader");
		user.setName("lmorpheus");
		RequestSpecification setPostBody = reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().setPostBody(user);
		requestOperation.getResponse(setPostBody, RequestRoute.setUser(), methodType);
	}

	@When("user hits the {string} end point {string}")
	public void user_hits_the_end_point(String methodType, String string2) throws IOException {
		
		HashMap<String, String> userDetails = new HashMap<>();
		userDetails.put("name", "anything");
		userDetails.put("job", "plumber");
		RequestSpecification setPostBody = reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
												.setRequestSpecification().setPostBody(userDetails);
		requestOperation.getResponse(setPostBody, RequestRoute.setUser(), methodType);
	}

	@When("user hits the API for a {string} request with user end point by replacing POST body")
	public void user_hits_the_api_for_a_request_with_user_end_point_by_replacing_post_body(String methodType)
			throws IOException {

		String jsonDataInFile = "src/test/resources/UserPayLoad.json";
		HashMap<String, String> userDetails = new HashMap<>();
		userDetails.put("morpheus", "lmno");
		userDetails.put("leader", "driver");
		String jsonBody = Settings.utility.replaceJsonValues(jsonDataInFile, userDetails);
		RequestSpecification setPostBody = reqBuildFactory.setContent(ContentType.JSON).setBaseURI(Settings.baseURL)
				.setRequestSpecification().setPostBody(jsonBody);
		requestOperation.getResponse(setPostBody, RequestRoute.setUser(), methodType);
	}

	@Then("user should get a status code = {int}")
	public void user_should_get_a_status_code(Integer statusCode) {
		int actualStatusCode = responseOperation.getStatusCode(this.appContext.response);
		this.appContext.response.prettyPrint();
		assertTrue(actualStatusCode == statusCode);
	}
}
