package com.ebiz.bp_mysql.domain;

import java.io.Serializable;
import java.util.List;

import com.ebiz.ssi.domain.BaseDomain;

public class PdInfoCustomFieldContent extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;

	private Integer pd_id;

	private Integer custom_field_id;

	private Integer type;

	private String custom_field_name;

	private Integer order_value;

	private Integer is_required;

	private Integer is_show;

	private String custom_field_content;

	private List<BaseAttributeSon> baseAttributeSonList;

	public PdInfoCustomFieldContent() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}

	public Integer getCustom_field_id() {
		return custom_field_id;
	}

	public void setCustom_field_id(Integer custom_field_id) {
		this.custom_field_id = custom_field_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCustom_field_name() {
		return custom_field_name;
	}

	public void setCustom_field_name(String custom_field_name) {
		this.custom_field_name = custom_field_name;
	}

	public Integer getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Integer order_value) {
		this.order_value = order_value;
	}

	public Integer getIs_required() {
		return is_required;
	}

	public void setIs_required(Integer is_required) {
		this.is_required = is_required;
	}

	public Integer getIs_show() {
		return is_show;
	}

	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}

	public String getCustom_field_content() {
		return custom_field_content;
	}

	public void setCustom_field_content(String custom_field_content) {
		this.custom_field_content = custom_field_content;
	}

	public List<BaseAttributeSon> getBaseAttributeSonList() {
		return baseAttributeSonList;
	}

	public void setBaseAttributeSonList(List<BaseAttributeSon> baseAttributeSonList) {
		this.baseAttributeSonList = baseAttributeSonList;
	}

}