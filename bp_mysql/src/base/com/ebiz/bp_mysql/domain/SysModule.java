package com.ebiz.bp_mysql.domain;

import java.io.Serializable;
import java.util.List;

import com.ebiz.ssi.domain.BaseDomain;

public class SysModule extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer mod_id;

	private Integer par_id;

	private String mod_name;

	private String mod_desc;

	private Integer mod_level;

	private Integer is_leaf;

	private String mod_url;

	private Integer order_value;

	private Integer is_public;

	private Integer is_lock;

	private Integer is_del;

	private Integer level;

	private Integer sys_sign;

	private String ppdm_code;

	private List<BasePopedom> basePopedomList;

	public SysModule() {

	}

	public Integer getMod_id() {
		return mod_id;
	}

	public void setMod_id(Integer mod_id) {
		this.mod_id = mod_id;
	}

	public Integer getPar_id() {
		return par_id;
	}

	public void setPar_id(Integer par_id) {
		this.par_id = par_id;
	}

	public String getMod_name() {
		return mod_name;
	}

	public void setMod_name(String mod_name) {
		this.mod_name = mod_name;
	}

	public String getMod_desc() {
		return mod_desc;
	}

	public void setMod_desc(String mod_desc) {
		this.mod_desc = mod_desc;
	}

	public String getMod_url() {
		return mod_url;
	}

	public void setMod_url(String mod_url) {
		this.mod_url = mod_url;
	}

	public Integer getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Integer order_value) {
		this.order_value = order_value;
	}

	public Integer getIs_public() {
		return is_public;
	}

	public void setIs_public(Integer is_public) {
		this.is_public = is_public;
	}

	public Integer getIs_lock() {
		return is_lock;
	}

	public void setIs_lock(Integer is_lock) {
		this.is_lock = is_lock;
	}

	public Integer getIs_del() {
		return is_del;
	}

	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}

	public Integer getMod_level() {
		return mod_level;
	}

	public void setMod_level(Integer modLevel) {
		mod_level = modLevel;
	}

	public Integer getIs_leaf() {
		return is_leaf;
	}

	public void setIs_leaf(Integer isLeaf) {
		is_leaf = isLeaf;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPpdm_code() {
		return ppdm_code;
	}

	public void setPpdm_code(String ppdmCode) {
		ppdm_code = ppdmCode;
	}

	public List<BasePopedom> getBasePopedomList() {
		return basePopedomList;
	}

	public void setBasePopedomList(List<BasePopedom> basePopedomList) {
		this.basePopedomList = basePopedomList;
	}

	public Integer getSys_sign() {
		return sys_sign;
	}

	public void setSys_sign(Integer sysSign) {
		sys_sign = sysSign;
	}

}