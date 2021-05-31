package com.POJO;

public class Root {
	
	public Data data;
	public Support support;

	public Root() {

	}

	public Root(Data data, Support support) {
		super();
		this.data = data;
		this.support = support;
	}

	public Data getData() {
		return data;
	}

	public Support getSupport() {
		return support;
	}

}
