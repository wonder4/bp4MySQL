package com.ebiz.bp_mysql.web.struts.manager.admin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ebiz.bp_mysql.domain.SysModule;
import com.ebiz.bp_mysql.domain.UserInfo;
import com.ebiz.bp_mysql.web.util.StringHelper;

public class FramesAction extends BaseAdminAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return this.index(mapping, form, request, response);
	}

	public ActionForward top(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("topFrame");
	}

	public ActionForward left(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// HttpSession session = request.getSession();
		UserInfo userInfo = super.getUserInfoFromSession(request);

		SysModule entity = new SysModule();
		entity.getMap().put("is_admin", userInfo.getUser_type().intValue() == 1 ? "true" : null);
		entity.getMap().put("user_id", userInfo.getId());
		List<SysModule> sysModuleList = getFacade().getSysModuleService().getSysModuleList(entity);
		String treeNodes = StringHelper.getjQzTreeNodesFromSysModuleList(sysModuleList);
		logger.info("treeNodes:{}", treeNodes);
		request.setAttribute("treeNodes", treeNodes);

		return mapping.findForward("leftFrame");
	}

	private static final char SEPARATOR = '|';

	/**
	 * Remove the duplicate element in List according to the specified keys in List bean and return a new list.</br> If
	 * the parameters are empty or exception occurred, original list will be returned.
	 * 
	 * @param list To be processed list
	 * @param keys The fields in List bean as keys
	 * @return
	 */
	public static <T> List<T> removeDuplication(List<T> list, String... keys) {
		if (list == null || list.isEmpty()) {
			System.err.println("List is empty.");
			return list;
		}

		if (keys == null || keys.length < 1) {
			System.err.println("Missing parameters.");
			return list;
		}

		for (String key : keys) {
			if (StringUtils.isBlank(key)) {
				System.err.println("Key is empty.");
				return list;
			}
		}

		List<T> newList = new ArrayList<T>();
		Set<String> keySet = new HashSet<String>();

		for (T t : list) {
			StringBuffer logicKey = new StringBuffer();
			for (String keyField : keys) {
				try {
					logicKey.append(BeanUtils.getProperty(t, keyField));
					logicKey.append(SEPARATOR);
				} catch (Exception e) {
					e.printStackTrace();
					return list;
				}
			}
			if (!keySet.contains(logicKey.toString())) {
				keySet.add(logicKey.toString());
				newList.add(t);
			} else {
				System.err.println(logicKey + " has duplicated.");
			}
		}

		return newList;
	}

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// return new ActionForward("/admin/Frames/indexNotFrame.jsp");
		return mapping.findForward("indexFrame");
	}

	public ActionForward main(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("mainFrame");
	}

	public ActionForward lr(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("lrFrame");
	}

	public ActionForward bottom(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("bottomFrame");
	}

}
