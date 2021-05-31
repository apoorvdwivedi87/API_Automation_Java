package com.api.RequestBuilderUtility;

import com.applicationContext.AppContext;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestOperations {

	private AppContext responseContext;

	public RequestOperations(AppContext _responseContext) {
		this.responseContext = _responseContext;
	}

	public Response getResponse(RequestSpecification request, String uri, String methodType) {

		switch (methodType) {
		case "GET":
			this.responseContext.response = request.get(uri);
			return request.get(uri);
			
		case "POST":
			this.responseContext.response = request.post(uri);
			break;
		default:
			break;
		}
		return null;
	}

}
