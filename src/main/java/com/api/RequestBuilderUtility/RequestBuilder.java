package com.api.RequestBuilderUtility;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	private RequestSpecBuilder requestSpecBuilder;
	private RequestSpecification reqSpec;
	private RequestSpecification request;

	public RequestSpecification getRequestSpecification(String baseURI, ContentType contentType) {

		RequestSpecBuilder requestSpecBuilder = getRequestSpecBuilder();
		setBaseURI(baseURI);
		setContentType(contentType);
		getReqSpec(requestSpecBuilder);
		request = getRequest(reqSpec);
		return request;
	}

	public RequestSpecification getRequestSpecification(String baseURI) {

		RequestSpecBuilder requestSpecBuilder = getRequestSpecBuilder();
		setBaseURI(baseURI);
		getReqSpec(requestSpecBuilder);
		request = getRequest(reqSpec);
		return request;
	}

	private RequestSpecBuilder getRequestSpecBuilder() {

		requestSpecBuilder = new RequestSpecBuilder();
		return requestSpecBuilder;

	}

	private RequestSpecBuilder setBaseURI(String uri) {
		requestSpecBuilder.setBaseUri(uri);
		return requestSpecBuilder;
	}

	private RequestSpecBuilder setContentType(ContentType contentType) {
		requestSpecBuilder.setContentType(contentType);
		return requestSpecBuilder;
	}

	private RequestSpecification getReqSpec(RequestSpecBuilder requestSpecBuilder) {

		reqSpec = requestSpecBuilder.build().given();
		return reqSpec;

	}

	private RequestSpecification getRequest(RequestSpecification reqSpec) {
		request = RestAssured.given().spec(reqSpec);
		return request;
	}

}
