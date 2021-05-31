package com.api.RequestBuilderUtility;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilderFactory {

	private RequestSpecification reqSpec;
	private RequestSpecification request;
	private ThreadLocal<RequestSpecBuilder> reqSpecBuilderThreadLocal = new ThreadLocal();

	public RequestBuilderFactory() {
		reqSpecBuilderThreadLocal.set(new RequestSpecBuilder());
	}

	public RequestBuilderFactory setBaseURI(String baseUri) {
		reqSpecBuilderThreadLocal.get().setBaseUri(baseUri);
		return this;
	}

	public RequestBuilderFactory setContent(ContentType contentType) {
		reqSpecBuilderThreadLocal.get().setContentType(contentType);
		return this;
	}

	public RequestBuilderFactory setHeader(String headerName, String headerValue) {
		reqSpecBuilderThreadLocal.get().addHeader(headerName, headerValue);
		return this;
	}

	public RequestBuilderFactory setHeader(HashMap<String, String> headers) {
		reqSpecBuilderThreadLocal.get().addHeaders(headers);
		return this;
	}

	public RequestBuilderFactory setRequestSpecification() {
		reqSpec = reqSpecBuilderThreadLocal.get().build().given();
		return this;

	}

	public RequestSpecification getRequest() {
		request = RestAssured.given().spec(reqSpec);
		return request;
	}

	public RequestSpecification setPostBody(Object postBody) {
		request = RestAssured.given().spec(reqSpec).body(postBody);
		return request;
	}

}
