<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/pages/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${applicationScope._global_website_name}</title>
<link href="${ctx}/commons/styles/yellow/base.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
/* nav */
.navaiisen{margin:0 auto;width:145px;text-align:left;}
.navaiisen h3{margin-bottom:5px;padding:7px 0 2px 30px;color:#930;font-size:12px;font-weight:bold;letter-spacing:1px;height:14px;background:url(./images/column_bg.gif) no-repeat left top;}
.navaiisen h3.home{margin-bottom:5px;padding:7px 0 2px 30px;color:#930;font-size:12px;font-weight:bold;letter-spacing:1px;height:14px;background:url(./images/column_home.gif) no-repeat left top;}
.navaiisen h3 a{color:#930;}.navaiisen h3 a:hover{color:#f00;}.navaiisen li{margin-bottom:5px;padding:6px 0 5px 20px!important;padding:7px 0 2px 20px;color:#C18333;font-size:12px;height:12px;border:#F5E1CD solid 1px;background:#fff url(./images/column_ddimg.gif) no-repeat 8px 9px;}
.navaiisen li a{color:#C18333;}.navaiisen li a:hover{color:#f00;}
#layout{display:block;height:100%;position:relative;}
#header{display:block;overflow:hidden;height:50px;z-index:30;}
#leftside{position:absolute;top:55px;left:0;z-index:20;text-align:left;}
#container{position:absolute;top:50px;left:160px;width: 1151px;}
#footer{position:absolute;bottom:0;left:0;text-align:center;width:100%;height:21px;padding:0 5px;z-index:-1;}
-->
</style>
</head>
<body>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.cookie.js"></script> 
<div id="layout">
  <div id="header">
    <c:url var="urlindex" value="/index.do" />
    <div class="topFrameLayout">
      <div class="topFrameHeader">
        <div class="topFrameHeaderNav"> <a class="logo" href="${urlindex}" target="_parent">${applicationScope._global_website_name}</a>
          <ul class="nav">
            <li><a href="javascript:void(0);">欢迎您！${fn:escapeXml(userInfo.user_name)}(${fn:escapeXml(userInfo.real_name)})</a></li>
            <li><a href="${urlindex}" target="_parent">首页</a></li>
            <li><a href="../login.do?method=logout" target="_parent">退出</a></li>
          </ul>
          <ul class="themeList" id="themeList">
            <li class="green">
              <div class="selected">绿色</div>
            </li>
            <li class="blue">
              <div>蓝色</div>
            </li>
            <li class="yellow">
              <div>黄色</div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div id="leftside">
    <div class="navaiisen">
      <h3 class="home">系统首页</h3>
      <h3>新闻管理</h3>
      <ul>
        <li><a href="NewsInfo.do?mod_id=1003001000">新闻管理</a></li>
      </ul>
      <h3>用户管理</h3>
      <ul>
        <li><a href="UserInfo.do?mod_id=1007001000">用户管理</a></li>
      </ul>
    </div>
  </div>
  <div id="container"> 
  </div>
</div>
<div id="footer">Copyright &copy; 2013 </div>
<script type="text/javascript">//<![CDATA[
$(document).ready(function(){
	$("a", "#leftside").click(function(){
		var this_href = $(this).attr("href");
		//alert(this_href);
		$("#container").empty().html('<iframe width="100%" id="mainFrame" height="1" frameborder="0" src="' + this_href + '"></iframe>');
        $("#mainFrame").load(function(){
        		var mainheight = $(this).contents().find("body").height()+30;
        		$(this).height(mainheight);
        }); 
		return false;
	});
 	$("li", "#themeList").click(function(){
 	 	var _this = $(this);
 	 	var themeName = _this.attr("class");
 	 	var _parent = _this.parent();
 	 	
 	 	var _theme = $("head").find("link[href$='base.css']");
 	 	var cssPath = _theme.attr("href");
 	 	var temp = cssPath.substring(0, cssPath.lastIndexOf('/'));
 	 	var baseCssPath = temp.substring(0, temp.lastIndexOf('/') + 1);
 	 	var _themeHref = baseCssPath + themeName +"/base.css";
 	 	_theme.attr("href", _themeHref);
 	 	
		_this.parent().find("div").removeClass("selected");
		_this.find("div").addClass("selected");
		
		$("head", window.mainFrame.document).find("link[href$='base.css']").attr("href", _themeHref);
		if ($.isFunction($.cookie)) $.cookie("projectTheme", themeName);
 	 });

	if ($.isFunction($.cookie)){
		var themeName = $.cookie("projectTheme");
		if (themeName) {
	 	 	var _theme = $("head").find("link[href$='base.css']");
	 	 	var cssPath = _theme.attr("href");
	 	 	var temp = cssPath.substring(0, cssPath.lastIndexOf('/'));
	 	 	var baseCssPath = temp.substring(0, temp.lastIndexOf('/') + 1);
	 	 	var _themeHref = baseCssPath + themeName +"/base.css";
	 	 	_theme.attr("href", _themeHref);
	 	 	$("li", "#themeList").each(function(){
	 	 	 	var _this = $(this);
	 	 	 	var cssThemeName = _this.attr("class");
	 			_this.find("div").removeClass("selected");
	 			if (cssThemeName == themeName) {
	 				_this.find("div").addClass("selected");
	 			}
		 	});
		}
	}

});
	
//]]>
</script>
</body>
</html>