package com.ebiz.bp_mysql.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.service.BaseAttributeService;
import com.ebiz.bp_mysql.service.BaseAttributeSonService;
import com.ebiz.bp_mysql.service.BaseBrandInfoService;
import com.ebiz.bp_mysql.service.BaseClassLinkAttributeService;
import com.ebiz.bp_mysql.service.BaseClassService;
import com.ebiz.bp_mysql.service.BaseDataService;
import com.ebiz.bp_mysql.service.BasePopedomService;
import com.ebiz.bp_mysql.service.BaseProvinceService;
import com.ebiz.bp_mysql.service.DeptInfoService;
import com.ebiz.bp_mysql.service.Facade;
import com.ebiz.bp_mysql.service.HelpContentService;
import com.ebiz.bp_mysql.service.HelpInfoService;
import com.ebiz.bp_mysql.service.HelpModuleService;
import com.ebiz.bp_mysql.service.ModPopedomService;
import com.ebiz.bp_mysql.service.NewsAttachmentService;
import com.ebiz.bp_mysql.service.NewsContentService;
import com.ebiz.bp_mysql.service.NewsInfoService;
import com.ebiz.bp_mysql.service.PdContentService;
import com.ebiz.bp_mysql.service.PdImgsService;
import com.ebiz.bp_mysql.service.PdInfoCustomAttrContentService;
import com.ebiz.bp_mysql.service.PdInfoCustomFieldContentService;
import com.ebiz.bp_mysql.service.PdInfoService;
import com.ebiz.bp_mysql.service.QaInfoService;
import com.ebiz.bp_mysql.service.RoleService;
import com.ebiz.bp_mysql.service.RoleUserService;
import com.ebiz.bp_mysql.service.SysModuleService;
import com.ebiz.bp_mysql.service.SysSettingService;
import com.ebiz.bp_mysql.service.UserInfoService;
import com.ebiz.ssi.service.impl.BaseFacadeImpl;

@Service("facade")
public class FacadeImpl extends BaseFacadeImpl implements Facade {

	@Resource
	BaseAttributeService baseAttributeService;

	@Resource
	BaseAttributeSonService baseAttributeSonService;

	@Resource
	BaseBrandInfoService baseBrandInfoService;

	@Resource
	BaseClassLinkAttributeService baseClassLinkAttributeService;

	@Resource
	BaseClassService baseClassService;

	@Resource
	BaseDataService baseDataService;

	@Resource
	BasePopedomService basePopedomService;

	@Resource
	BaseProvinceService baseProvinceService;

	@Resource
	DeptInfoService deptInfoService;

	@Resource
	HelpContentService helpContentService;

	@Resource
	HelpInfoService helpInfoService;

	@Resource
	HelpModuleService helpModuleService;

	@Resource
	ModPopedomService modPopedomService;

	@Resource
	NewsAttachmentService newsAttachmentService;

	@Resource
	NewsContentService newsContentService;

	@Resource
	NewsInfoService newsInfoService;

	@Resource
	PdContentService pdContentService;

	@Resource
	PdImgsService pdImgsService;

	@Resource
	PdInfoCustomAttrContentService pdInfoCustomAttrContentService;

	@Resource
	PdInfoCustomFieldContentService pdInfoCustomFieldContentService;

	@Resource
	PdInfoService pdInfoService;

	@Resource
	QaInfoService qaInfoService;

	@Resource
	RoleService roleService;

	@Resource
	RoleUserService roleUserService;

	@Resource
	SysModuleService sysModuleService;

	@Resource
	SysSettingService sysSettingService;

	@Resource
	UserInfoService userInfoService;

	public BaseAttributeService getBaseAttributeService() {
		return baseAttributeService;
	}

	public BaseAttributeSonService getBaseAttributeSonService() {
		return baseAttributeSonService;
	}

	public BaseBrandInfoService getBaseBrandInfoService() {
		return baseBrandInfoService;
	}

	public BaseClassLinkAttributeService getBaseClassLinkAttributeService() {
		return baseClassLinkAttributeService;
	}

	public BaseClassService getBaseClassService() {
		return baseClassService;
	}

	public BaseDataService getBaseDataService() {
		return baseDataService;
	}

	public BasePopedomService getBasePopedomService() {
		return basePopedomService;
	}

	public BaseProvinceService getBaseProvinceService() {
		return baseProvinceService;
	}

	public DeptInfoService getDeptInfoService() {
		return deptInfoService;
	}

	public HelpContentService getHelpContentService() {
		return helpContentService;
	}

	public HelpInfoService getHelpInfoService() {
		return helpInfoService;
	}

	public HelpModuleService getHelpModuleService() {
		return helpModuleService;
	}

	public ModPopedomService getModPopedomService() {
		return modPopedomService;
	}

	public NewsAttachmentService getNewsAttachmentService() {
		return newsAttachmentService;
	}

	public NewsContentService getNewsContentService() {
		return newsContentService;
	}

	public NewsInfoService getNewsInfoService() {
		return newsInfoService;
	}

	public PdContentService getPdContentService() {
		return pdContentService;
	}

	public PdImgsService getPdImgsService() {
		return pdImgsService;
	}

	public PdInfoCustomAttrContentService getPdInfoCustomAttrContentService() {
		return pdInfoCustomAttrContentService;
	}

	public PdInfoCustomFieldContentService getPdInfoCustomFieldContentService() {
		return pdInfoCustomFieldContentService;
	}

	public PdInfoService getPdInfoService() {
		return pdInfoService;
	}

	public QaInfoService getQaInfoService() {
		return qaInfoService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public RoleUserService getRoleUserService() {
		return roleUserService;
	}

	public SysModuleService getSysModuleService() {
		return sysModuleService;
	}

	public SysSettingService getSysSettingService() {
		return sysSettingService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

}
