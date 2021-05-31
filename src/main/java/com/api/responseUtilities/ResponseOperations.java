package com.api.responseUtilities;

import java.util.List;
import java.util.stream.Collectors;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ResponseOperations {


	public List<String> getfilteredLastName(Response response, String expectedValue , String jsonPath) {
		List<String> allLastNames = response.getBody().jsonPath().get("data.last_name");
		List<String> filteredData = allLastNames.stream().filter(x -> x.equals(expectedValue)).collect(Collectors.toList());
		return filteredData;
	}
	
	public ResponseBody getResponseBody(Response response) {
		return response.getBody();
	}

	public void printBody(ResponseBody respBody) {
		System.out.println(respBody.asPrettyString());
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getJsonObjectValue(Response response, String jsonObjectName) {
		String jsonObjectValue = response.getBody().jsonPath().get(jsonObjectName).toString();
		return jsonObjectValue;
	}

	public int getJsonArraySize(Response response , String jsonArrayName) {
		List<String> allRecords = response.getBody().jsonPath().getList(jsonArrayName);
		return allRecords.size();
	}
}
