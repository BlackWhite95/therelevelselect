package com.shen.threelevellinkage.entity;

public class DistrictEntity {

	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toJsonString(){
		StringBuilder sb=new StringBuilder();
		sb.append("{\"code\":\"").append(this.code).append("\",");
		sb.append("\"name\":\"").append(this.name.trim()).append("\"");
		sb.append("}");
		return sb.toString();
	}
}
