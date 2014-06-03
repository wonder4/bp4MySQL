package com.ebiz.bp_mysql.domain;

import java.io.Serializable;

import com.ebiz.ssi.domain.BaseDomain;

public class PdInfoCustomAttrContent extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;

	private Integer pd_id;

	private Integer par_attr_id;

	private Integer attr_id;

	private String attr_name;

	private Integer cls_id;

	private Integer brand_id;

	public PdInfoCustomAttrContent() {

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

	public Integer getPar_attr_id() {
		return par_attr_id;
	}

	public void setPar_attr_id(Integer par_attr_id) {
		this.par_attr_id = par_attr_id;
	}

	public Integer getAttr_id() {
		return attr_id;
	}

	public void setAttr_id(Integer attr_id) {
		this.attr_id = attr_id;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public Integer getCls_id() {
		return cls_id;
	}

	public void setCls_id(Integer cls_id) {
		this.cls_id = cls_id;
	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

}