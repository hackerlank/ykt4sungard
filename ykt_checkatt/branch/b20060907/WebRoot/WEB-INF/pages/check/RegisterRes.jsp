<%@page pageEncoding="GBK"%>
<%@ include file="../tiles/include.jsp"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<title>复旦大学校园一卡通考勤管理系统</title>
<meta http-equiv="Content-Type" content="text/html;">

<%@ include file="/pages/common/meta.jsp"%>
		<%@ include file="/pages/components/calendar/calendar.jsp"%>
		<link href="<c:url value="/pages/styles/admin.css"/>" type="text/css" rel=stylesheet>
		<link href="<c:url value="/pages/styles/extremecomponents.css"/>" type="text/css" rel=stylesheet>
		<script src="<c:url value="/pages/scripts/admin.js"/>" type="text/javascript"></script>
		</head>

<body   bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div id="titleDiv" class="pageTitle">
<strong>
<font class="medium">
<c:out value="${msg}"/>
</font>
</strong>
</div>
<div id="tableDiv">
         <ec:table items="leaveList" var="leave" rowsDisplayed="5" action="leaveRegister.do?method=register">
				<ec:exportXls fileName="leaveList.xls" tooltip="导出 Excel" />
				<ec:row>
					<ec:column property="clerkname" title="人员" width="60" />
					<ec:column property="startdate" title="请假开始日期" width="95" />
					<ec:column property="enddate" title="请假结束日期" width="95" />
				</ec:row>
			</ec:table>
</div>
<div align="center">
<input type="button" value="返回" class="button_nor" onclick="<c:out value='${url}'/>"/>
</div>