package com.ebiz.bp_mysql.domain;

import java.io.Serializable;

import com.ebiz.ssi.domain.BaseDomain;

public class BaseAttributeSon extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;

	private Integer attr_id;

	private Integer brand_id;

	private String attr_show_name;

	private String attr_name;

	private Integer order_value;

	public BaseAttributeSon() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAttr_id() {
		return attr_id;
	}

	public void setAttr_id(Integer attr_id) {
		this.attr_id = attr_id;
	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getAttr_show_name() {
		return attr_show_name;
	}

	public void setAttr_show_name(String attr_show_name) {
		this.attr_show_name = attr_show_name;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public Integer getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Integer order_value) {
		this.order_value = order_value;
	}

}