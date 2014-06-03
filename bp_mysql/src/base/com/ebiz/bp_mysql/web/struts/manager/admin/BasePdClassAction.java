package com.ebiz.bp_mysql.web.struts.manager.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ebiz.bp_mysql.domain.BaseAttribute;
import com.ebiz.bp_mysql.domain.BaseAttributeSon;
import com.ebiz.bp_mysql.domain.BaseClass;
import com.ebiz.bp_mysql.domain.BaseClassLinkAttribute;
import com.ebiz.bp_mysql.domain.PdInfoCustomAttrContent;
import com.ebiz.bp_mysql.domain.UserInfo;
import com.ebiz.bp_mysql.web.Keys;
import com.ebiz.bp_mysql.web.util.StringHelper;
import com.ebiz.ssi.web.struts.bean.Pager;

public class BasePdClassAction extends BaseAdminAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return this.list(mapping, form, request, response);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		setNaviStringToRequestScope(request);

		DynaBean dynaBean = (DynaBean) form;
		String pd_class_type = (String) dynaBean.get("pd_class_type");

		if (StringUtils.isBlank(pd_class_type)) {// 跟目录par_id为-1
			pd_class_type = "-1";
		}
		String clazzTree = StringHelper.getTreeNodesFromBasePdClassList(getFacade(), 1, pd_class_type, false);
		request.setAttribute("clazzTree", clazzTree);

		return mapping.findForward("list");

	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		saveToken(request);
		setNaviStringToRequestScope(request);
		DynaBean dynaBean = (DynaBean) form;
		String pd_class_type = (String) dynaBean.get("pd_class_type");
		dynaBean.set("pd_class_type", pd_class_type);

		return mapping.findForward("input");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (isCancelled(request)) {
			return list(mapping, form, request, response);
		}
		if (!isTokenValid(request)) {
			saveError(request, "errors.token");
			return list(mapping, form, request, response);
		}
		resetToken(request);

		HttpSession session = request.getSession(false);
		UserInfo ui = (UserInfo) session.getAttribute(Keys.SESSION_USERINFO_KEY);

		DynaBean dynaBean = (DynaBean) form;
		String mod_id = (String) dynaBean.get("mod_id");
		String cls_id = (String) dynaBean.get("cls_id");
		String pd_class_type = (String) dynaBean.get("pd_class_type");

		Date date = new Date();
		BaseClass entity = new BaseClass();

		super.copyProperties(entity, form);

		if (null != entity.getPar_id()) {// 根据par_id获取root_id
			BaseClass baseClass = new BaseClass();
			baseClass.setCls_id(entity.getPar_id());
			baseClass = super.getFacade().getBaseClassService().getBaseClass(baseClass);
			if (null != baseClass) {
				entity.setRoot_id(baseClass.getRoot_id());
			}
		}

		if (StringUtils.isNotBlank(cls_id)) {
			entity.setUpdate_date(date);
			entity.setUpdate_user_id(ui.getId());
			super.getFacade().getBaseClassService().modifyBaseClass(entity);
			saveMessage(request, "entity.updated");
		} else {
			entity.setAdd_date(new Date());
			entity.setAdd_user_id(ui.getId());
			entity.setAdd_user_name(ui.getUser_name());
			entity.setIs_del(0);// 0：未删除
			entity.setCls_scope(1);// 1:产品
			super.getFacade().getBaseClassService().createBaseClass(entity);
			saveMessage(request, "entity.inserted");
		}
		// the line below is added for pagination
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(mapping.findForward("success").getPath());
		pathBuffer.append("&mod_id=" + mod_id);
		pathBuffer.append("&pd_class_type=" + pd_class_type);
		pathBuffer.append("&");
		pathBuffer.append(super.encodeSerializedQueryString(entity.getQueryString()));
		ActionForward forward = new ActionForward(pathBuffer.toString(), true);
		// end
		return forward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaBean dynaBean = (DynaBean) form;
		String cls_id = (String) dynaBean.get("cls_id");
		String pksString = (String) dynaBean.get("pksString");
		String mod_id = (String) dynaBean.get("mod_id");
		String pd_class_type = (String) dynaBean.get("pd_class_type");

		HttpSession session = request.getSession(false);
		UserInfo ui = (UserInfo) session.getAttribute(Keys.SESSION_USERINFO_KEY);

		BaseClass entity = new BaseClass();
		Date date = new Date();

		String[] pks = null;
		if (StringUtils.isNotBlank(pksString)) {
			pks = StringUtils.split(pksString, ",");
		}

		if (StringUtils.isNotBlank(cls_id) && GenericValidator.isLong(cls_id)) {
			entity.setCls_id(Integer.valueOf(cls_id));
			entity.setIs_del(1);
			entity.setDel_date(date);
			entity.setDel_user_id(ui.getId());
			super.getFacade().getBaseClassService().modifyBaseClass(entity);
			saveMessage(request, "entity.deleted");
		} else if (ArrayUtils.isNotEmpty(pks)) {
			entity.setIs_del(1);
			entity.setDel_date(date);
			entity.setDel_user_id(ui.getId());
			entity.getMap().put("pks", pks);
			super.getFacade().getBaseClassService().modifyBaseClass(entity);

			saveMessage(request, "entity.deleted");
		}
		// the line below is added for pagination
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(mapping.findForward("success").getPath());
		pathBuffer.append("&mod_id=" + mod_id);
		pathBuffer.append("&pd_class_type=" + pd_class_type);
		pathBuffer.append("&");
		pathBuffer.append(super.encodeSerializedQueryString(super.serialize(request, "id", "method")));
		ActionForward forward = new ActionForward(pathBuffer.toString(), true);
		// end
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		saveToken(request);
		setNaviStringToRequestScope(request);

		DynaBean dynaBean = (DynaBean) form;
		String cls_id = (String) dynaBean.get("cls_id");

		if (GenericValidator.isLong(cls_id)) {
			BaseClass entity = new BaseClass();
			entity.setCls_id(Integer.valueOf(cls_id));
			entity = getFacade().getBaseClassService().getBaseClass(entity);

			if (null == entity) {
				saveMessage(request, "entity.missing");
				return mapping.findForward("list");
			}

			entity.setQueryString(super.serialize(request, "id", "method"));
			super.copyProperties(form, entity);

			setParNameAndRootNameToForm(dynaBean, entity);

			return mapping.findForward("input");
		} else {
			saveError(request, "errors.long", cls_id);
			return mapping.findForward("list");
		}
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		setNaviStringToRequestScope(request);
		DynaBean dynaBean = (DynaBean) form;
		String cls_id = (String) dynaBean.get("cls_id");
		if (GenericValidator.isLong(cls_id)) {
			BaseClass entity = new BaseClass();
			entity.setCls_id(Integer.valueOf(cls_id));
			entity = getFacade().getBaseClassService().getBaseClass(entity);
			if (entity != null) {
				if (entity.getDel_user_id() != null) {
					UserInfo ui = new UserInfo();
					ui.setId(entity.getDel_user_id());
					ui = super.getFacade().getUserInfoService().getUserInfo(ui);
					if (ui != null) {
						entity.getMap().put("del_name", ui.getUser_name());
					}
				}
			}
			super.copyProperties(form, entity);

			setParNameAndRootNameToForm(dynaBean, entity);

			return mapping.findForward("view");
		} else {
			saveError(request, "errors.long", cls_id);
			return mapping.findForward("list");
		}
	}

	private void setParNameAndRootNameToForm(DynaBean dynaBean, BaseClass entity) {
		Integer par_id = entity.getPar_id();
		Integer root_id = entity.getRoot_id();
		BaseClass baseClass = new BaseClass();
		baseClass.setCls_id(par_id);
		baseClass = getFacade().getBaseClassService().getBaseClass(baseClass);
		if (null != baseClass) {
			dynaBean.set("par_name", baseClass.getCls_name());
		}
		baseClass = new BaseClass();
		baseClass.setIs_del(0);
		baseClass.setCls_id(root_id);
		baseClass = getFacade().getBaseClassService().getBaseClass(baseClass);
		if (null != baseClass) {
			dynaBean.set("root_name", baseClass.getCls_name());
		}
	}

	public ActionForward linkAttribute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		setNaviStringToRequestScope(request, " -&gt; 属性授权");

		DynaBean dynaBean = (DynaBean) form;
		String cls_id = (String) dynaBean.get("cls_id");
		String is_lock = (String) dynaBean.get("is_lock");
		String attr_name_like = (String) dynaBean.get("attr_name_like");
		String attr_show_name_like = (String) dynaBean.get("attr_show_name_like");
		Pager pager = (Pager) dynaBean.get("pager");

		if (!GenericValidator.isLong(cls_id)) {
			saveError(request, "errors.long", cls_id);
			return mapping.findForward("list");
		}

		// 产品类别
		BaseClass baseClass = new BaseClass();
		baseClass.setCls_id(Integer.valueOf(cls_id));
		baseClass = super.getFacade().getBaseClassService().getBaseClass(baseClass);
		request.setAttribute("basePdClass", baseClass);

		// PdInfo pdInfo = new PdInfo();
		// pdInfo.setCls_id(Long.valueOf(cls_id));
		// pdInfo.setIs_del(0);// 0:未删除
		// Long pdInfoCount =
		// super.getFacade().getPdInfoService().getPdInfoCount(pdInfo);
		// BmServicesInfo bmServicesInfo = new BmServicesInfo();
		// bmServicesInfo.setCls_id(Long.valueOf(cls_id));
		// bmServicesInfo.setIs_del(0);// 0:未删除
		// Long bmServicesInfoCount =
		// super.getFacade().getBmServicesInfoService().getBmServicesInfoCount(bmServicesInfo);
		// if (pdInfoCount > 0 || bmServicesInfoCount > 0) {
		// request.setAttribute("can_delete", true);
		// }

		// 已授权的属性
		BaseAttribute basePdAttributeLink = new BaseAttribute();
		basePdAttributeLink.getMap().put("id_in", true);
		basePdAttributeLink.getMap().put("cls_id", cls_id);
		List<BaseAttribute> basePdAttributeLinkList = super.getFacade().getBaseAttributeService().getBaseAttributeList(
				basePdAttributeLink);
		request.setAttribute("basePdAttributeLinkList", basePdAttributeLinkList);

		// 未授权的属性
		BaseAttribute basePdAttribute = new BaseAttribute();
		basePdAttribute.getMap().put("id_not_in", true);
		basePdAttribute.getMap().put("cls_id", cls_id);

		if (StringUtils.isNotBlank(is_lock)) {
			basePdAttribute.setIs_lock(Integer.valueOf(is_lock));
		}
		basePdAttribute.setIs_del(0);// 0:未删除

		if (StringUtils.isNotBlank(attr_name_like)) {
			basePdAttribute.getMap().put("attr_name_like", attr_name_like);
		}
		if (StringUtils.isNotBlank(attr_show_name_like)) {
			basePdAttribute.getMap().put("attr_show_name_like", attr_show_name_like);
		}
		Long recordCount = getFacade().getBaseAttributeService().getBaseAttributeCount(basePdAttribute).longValue();
		pager.init(recordCount, pager.getPageSize(), pager.getRequestPage());
		basePdAttribute.getRow().setFirst(pager.getFirstRow());
		basePdAttribute.getRow().setCount(pager.getRowCount());
		List<BaseAttribute> basePdAttributeList = super.getFacade().getBaseAttributeService()
				.getBaseAttributePaginatedList(basePdAttribute);
		request.setAttribute("basePdAttributeList", basePdAttributeList);

		// 子属性
		BaseAttributeSon basePdAttributeSon = new BaseAttributeSon();
		List<BaseAttributeSon> basePdAttributeSonList = super.getFacade().getBaseAttributeSonService()
				.getBaseAttributeSonList(basePdAttributeSon);
		request.setAttribute("basePdAttributeSonList", basePdAttributeSonList);

		return new ActionForward("/../manager/admin/BasePdClass/linkAttribute.jsp");
	}

	public ActionForward listLinkedAttribute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		DynaBean dynaBean = (DynaBean) form;
		String cls_id = (String) dynaBean.get("cls_id");

		if (!GenericValidator.isLong(cls_id)) {
			saveError(request, "errors.long", cls_id);
			return mapping.findForward("list");
		}

		// 产品类别
		BaseClass baseClass = new BaseClass();
		baseClass.setCls_id(Integer.valueOf(cls_id));
		baseClass = super.getFacade().getBaseClassService().getBaseClass(baseClass);
		request.setAttribute("basePdClass", baseClass);

		// 已授权的属性
		BaseAttribute basePdAttributeLink = new BaseAttribute();
		basePdAttributeLink.getMap().put("id_in", true);
		basePdAttributeLink.getMap().put("cls_id", cls_id);
		List<BaseAttribute> basePdAttributeLinkList = super.getFacade().getBaseAttributeService().getBaseAttributeList(
				basePdAttributeLink);
		request.setAttribute("basePdAttributeLinkList", basePdAttributeLinkList);

		// 子属性
		BaseAttributeSon basePdAttributeSon = new BaseAttributeSon();
		List<BaseAttributeSon> basePdAttributeSonList = super.getFacade().getBaseAttributeSonService()
				.getBaseAttributeSonList(basePdAttributeSon);
		request.setAttribute("basePdAttributeSonList", basePdAttributeSonList);

		return new ActionForward("/../manager/admin/BasePdClass/listLinkedAttribute.jsp");
	}

	public ActionForward changeLinkAttribute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaBean dynaBean = (DynaBean) form;
		// String mod_id = (String) dynaBean.get("mod_id");
		// String pd_class_type = (String) dynaBean.get("pd_class_type");
		String change = (String) dynaBean.get("change");
		String[] pks = (String[]) dynaBean.get("pks");

		BaseClassLinkAttribute entity = new BaseClassLinkAttribute();
		super.copyProperties(entity, form);

		if (StringUtils.isNotBlank(change)) {
			if (change.equals("insert")) {

				entity.getMap().put("cks", pks);
				super.getFacade().getBaseClassLinkAttributeService().createBaseClassLinkAttribute(entity);
				saveMessage(request, "entity.inserted");
			} else if (change.equals("delete")) {

				// start
				// 判定该产品类别的属性是否已绑定数据，如果已绑定(count > 0)，则不能被删除，否则(count < 0)能被删除
				String cls_id = (String) dynaBean.get("cls_id");
				String attr_id = (String) dynaBean.get("attr_id");
				Integer count = 0;
				PdInfoCustomAttrContent pdInfoCustomAttrContent = new PdInfoCustomAttrContent();
				pdInfoCustomAttrContent.setPar_attr_id(Integer.valueOf(attr_id));
				pdInfoCustomAttrContent.setCls_id(Integer.valueOf(cls_id));
				count = super.getFacade().getPdInfoCustomAttrContentService().getPdInfoCustomAttrContentCount(
						pdInfoCustomAttrContent);
				if (count > 0) {
					String msg = super.getMessage(request, "delete.failed.linkAttribute");
					super.renderJavaScript(response, "alert('" + msg + "');history.back();");
					return null;
				}
				// end

				super.getFacade().getBaseClassLinkAttributeService().removeBaseClassLinkAttribute(entity);
				saveMessage(request, "entity.deleted");
			}
		} else {
			saveError(request, "errors.parm", change);
			return mapping.findForward("list");
		}

		return linkAttribute(mapping, form, request, response);
	}
}