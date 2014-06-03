<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/pages/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${applicationScope._global_website_name}导航菜单</title>
<link href="${ctx}/commons/styles/green/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/commons/scripts/jqztree/styles/yellow/zTreeStyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
-->
</style>
</head>
<body class="leftFrameBody">
<div style="padding-top:5px;">
  <div class="subtitleleft" style="padding:0;margin: 0;">
    <h3>系统管理员</h3>
  </div>
</div>
<div style="padding-left:5px;">
  <ul id="tree" class="tree">
  </ul>
  <script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
  <script type="text/javascript" src="${ctx}/commons/scripts/jqztree/ztree.min.js"></script> 
  <script type="text/javascript">//<![CDATA[
	var zTree;
	var setting = {
		isSimpleData: true,
		treeNodeKey: "mod_id",
		treeNodeParentKey: "par_id",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		}
	};

	zNodes =${treeNodes}

	$(document).ready(function(){
		setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
		zTree = $("#tree").zTree(setting, zNodes);
		<c:if test="${userInfo.user_type ne 1}">
		zTree.expandAll(true);
		</c:if>
	});
//]]></script> 
</div>
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
 //]]></script>
</body>
</html>