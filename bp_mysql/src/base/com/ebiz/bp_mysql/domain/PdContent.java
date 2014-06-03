package com.ebiz.bp_mysql.domain;

import java.io.Serializable;

import com.ebiz.ssi.domain.BaseDomain;

public class PdContent extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;

	private Integer pd_id;

	private Integer type;

	private String content;

	public PdContent() {

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}