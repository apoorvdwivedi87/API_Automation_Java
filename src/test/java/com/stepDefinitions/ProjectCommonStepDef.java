package com.stepDefinitions;

import com.api.RequestBuilderUtility.RequestBuilder;
import com.api.RequestBuilderUtility.RequestOperations;
import com.api.endpoints.EndPoint;
import com.api.responseUtilities.ResponseOperations;
import com.applicationContext.AppContext;

import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class ProjectCommonStepDef {

	//private String baseURI;
	private RequestOperations requestOperation;
	//private ResponseOperations responseOperation;
	//private AppContext responseContext;

	public ProjectCommonStepDef(RequestOperations requestOpeartaions) {

		this.requestOperation = requestOpeartaions;
		
	}

	
	
	@When("user hits the API for an GET request")
	public void user_hits_the_api_for_a_get_request() {
		RequestBuilder requestBuilder = new RequestBuilder();
		RequestSpecification requestSpecification = requestBuilder.getRequestSpecification(EndPoint.getBaseUrl());
		requestOperation.getResponse(requestSpecification, "/users?page=2", "GET");

	}
	
	
}
