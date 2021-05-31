package com.POJO;

import java.util.List;

public class RootArrayList {

	public Support support;
	public List<Data> data;
	public String page;
	public String per_page;
	public String total;
	public String total_pages;

	public RootArrayList() {

	}

	public RootArrayList(Support support, List<Data> _dataList, String page, String perpage, String total,
			String total_pages) {
		super();
		this.support = support;
		this.data = _dataList;
		this.page = page;
		this.per_page = perpage;
		this.total = total;
		this.total_pages = total_pages;
	}

	public Support getSupport() {
		return support;
	}

	public List<Data> getDataList() {
		return data;
	}

	public String getPage() {
		return page;
	}

	public String getPer_page() {
		return per_page;
	}

	public String getTotal() {
		return total;
	}

	public String getTotal_pages() {
		return total_pages;
	}

}
