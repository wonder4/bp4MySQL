<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../commons/pages/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache,no-store,must-revalidate" />
<meta http-equiv="Cache-Control" content="pre-check=0,post-check=0" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="MSThemeCompatible" content="no" />
<meta name="MSSmartTagsPreventParsing" content="true" />
<title>${applicationScope._global_website_name}首页</title>
</head>
<body>
<h1>${applicationScope._global_website_name} 首页</h1>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
<script type="text/javascript">//<![CDATA[
//]]>
</script>
<jsp:include page="_analytics.jsp" flush="true" />
</body>
</html>