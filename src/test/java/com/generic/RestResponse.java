package com.generic;

import com.POJO.Data;
import com.POJO.Root;
import com.POJO.RootArrayList;

import io.restassured.response.Response;

public class RestResponse<T> {

	private T data;

	private Response response;

	public RestResponse(Class<T> t, Response response) {
		this.response = response;
		try {
			this.data = t.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("There should be a default constructor in the Response POJO");
		}
	}

	public String getContent() {
		return response.getBody().asString();
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public Response getResponse() {
		return response;
	}

	public T getBody() {

		data = (T) response.getBody().as(data.getClass());

		return data;
	}
	
	public static RestResponse<Root> getUsers(Response response ) {
     
        return new RestResponse(Root.class, response);
    }
	
	public static RestResponse<RootArrayList> getAllUsers(Response response ) {
	     
        return new RestResponse(RootArrayList.class, response);
    }

}
