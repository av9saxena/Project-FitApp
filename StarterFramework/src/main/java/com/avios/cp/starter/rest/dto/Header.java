package com.avios.cp.starter.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("totalCount")
	private Integer totalCount;

	@JsonProperty("page")
	private Integer page;

	@JsonProperty("count")
	private Integer count;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Header [totalCount=" + totalCount + ", page=" + page + ", count=" + count + "]";
	}
}
