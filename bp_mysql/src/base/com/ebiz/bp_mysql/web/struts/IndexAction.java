package com.ebiz.bp_mysql.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class IndexAction extends BaseAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return this.index(mapping, form, request, response);
	}

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// NewsInfo entity = new NewsInfo();
		// entity.getRow().setCount(new Integer(10));
		// entity.getMap().put("is_pub", "0");
		// entity.getMap().put("no_invalid", "no_invalid_date");
		//
		// entity.setMod_code("8101000"); // 公示公告
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8101000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// entity.setMod_code("8102000"); // 综合新闻
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8102000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// entity.setMod_code("8103000"); // 招商引资
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8103000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// entity.setMod_code("8104000"); // 对外贸易
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8104000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// entity.setMod_code("8105000"); // 商务法规
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8105000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// entity.setMod_code("8106000"); // 商业动态
		// entity.setIs_del(0);
		// request.setAttribute("newsInfo8106000EntityList", getFacade().getNewsInfoService().getNewsInfoList(entity));
		//
		// super.setPbulicInfoListToSession(request);

		return mapping.findForward("success");
	}

}
