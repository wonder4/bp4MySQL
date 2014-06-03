<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/commons/pages/taglibs.jsp" %>
 <script type="text/javascript" src="${ctx}/commons/scripts/jquery.cookie.js"></script> 
 <script type="text/javascript">//<![CDATA[
	if (typeof(jQuery) != "undefined") {  
			$("input[type='text'][readonly],textarea[readonly]").css({color:"#999"});
			if ($.isFunction($.cookie)){
				var themeName = $.cookie("projectTheme");
				if (themeName) {
			 	 	var _theme = $("head").find("link[href$='base.css']");
			 	 	var cssPath = _theme.attr("href");
			 	 	var temp = cssPath.substring(0, cssPath.lastIndexOf('/'));
			 	 	var baseCssPath = temp.substring(0, temp.lastIndexOf('/') + 1);
			 	 	var _themeHref = baseCssPath + themeName +"/base.css";
			 	 	_theme.attr("href", _themeHref);
				}
			}
	}
	/**
	window.onload = updateSystemListen;
	function updateSystemListen (){
	    p_join_listen("/updateSysListen");
	}
	function onData(event) {
		p_debug(false, "pushlet-app", "event received event=" + event.getEvent() );
		var action = event.get("action");
		var content = "none action=" + action;
	  	if (action == "sendUpdateSystemTip") {
  		    var msg = '<marquee behavior="scroll" scrolldelay="160" onmouseover="this.stop();" onmouseout="this.start();">' + decodeURIComponent(event.get("msg")) + '</marquee>';
			content = '<div id="updateSysTipDiv" class="tip-base tip-red" style="display:none;left: 450.5px; top: 0; position: absolute;">' + msg + '</div>';
			$("#updateSysTipDiv").remove();
			$("body").append(content);
			$("#updateSysTipDiv").slideDown();
		} else if (action == "closeUpdateSystemTip") {
			$("#updateSysTipDiv").slideUp();
		}
	} */
 //]]></script>
