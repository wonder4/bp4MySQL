<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/pages/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>请选择类别</title>
<base target="_self" />
<link href="${ctx}/commons/styles/green/base.css" rel="stylesheet" type="text/css" />
<jsp:include page="../_global_manager_page_head.jsp" flush="true" />
<link href="${ctx}/commons/scripts/jqztree/styles/customer/zTreeStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="pageClass">
  <ul id="treePd" class="tree">
  </ul>
</div>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
<script type="text/javascript" src="${ctx}/commons/scripts/jqztree/ztree.min.js"></script> 
<script type="text/javascript">//<![CDATA[
var zTreeObj;
$(document).ready(function(){
	var setting = {
		isSimpleData: true,
		checkable : true,
		checkStyle: "radio",
		checkRadioType: "all",
		treeNodeKey: "cls_id",
		treeNodeParentKey: "par_id",
		showLine: true,
		//addDiyDom: addDiyDom,
		callback: {change:	zTreeOnChange},
		root:{ isRoot:true,nodes:[]}
	};
	zNodes =${clazzTree};
	zTreeObj = $("#treePd").zTree(setting, zNodes);
	zTreeObj.expandAll(true);
	
	<c:if test="${not empty af.map.hideParentNode}">
	var nodes = zTreeObj.getNodes();
	for(var i = 0; i < nodes.length; i++){
		if(nodes[i].isParent){
			nodes[i].nocheck  = true;
			zTreeObj.updateNode(nodes[i],true);
		}
	}
	</c:if>
});

function zTreeOnChange() {
	var checkedNodes = zTreeObj.getCheckedNodes();
	var cls_name;
	var cls_id;
   	var valuesText = $.map(checkedNodes, function(treeObj){
   		cls_name = treeObj.name;
		return treeObj.name;
    }).join(",");
    var values = $.map(checkedNodes, function(treeObj){
    	cls_id = treeObj.cls_id;
		if (!treeObj.isParent) {
			return treeObj.cls_id;
		}
    }).join(",");
    //$("#state_type_name").val(valuesText);
    //alert(values);
    
    
    parent.$.returnValue = {"cls_name": cls_name, "cls_id" : cls_id};
}
//treeObj.setChkDisabled(nodes[i], true);
function addDiyDom(treeId, zTreeNode) {

	//var aObj = $("#" + zTreeNode.tId + "_a");
	if(zTreeNode.isParent){
		alert(zTreeNode.name);
		zTreeNode.name = "testName";
		zTreeObj.updateNode(zTreeNode, true);
	}

}

//]]></script>
</body>
</html>
