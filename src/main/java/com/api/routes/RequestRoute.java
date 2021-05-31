package com.api.routes;

public class RequestRoute {

	private static final String user = "/users/";
	private static final String users = "/users";
	private static final String allUsersFromPage = "?page=";
	private static final String setUser = "/api/user";

	public static String getUser(String userId) {
		return user + userId;
	}

	public static String getAllUsers() {

		return users;
	}

	public static String getAllUsersOnPage(String pageNumber) {
		return users + allUsersFromPage + pageNumber;
	}

	public static String setUser() {
		return setUser;
	}
}
