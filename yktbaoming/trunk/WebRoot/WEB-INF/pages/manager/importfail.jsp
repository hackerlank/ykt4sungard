<%@page pageEncoding="GBK"%>
<%@ include file="../tiles/include.jsp"%>

<html:html>
<html:errors/>
<html:form action="stuuploadAction.do?method=load4upload" enctype="multipart/form-data">
	<center>
	<font size="3.5" color="#990000">考生数据导入失败！<br>请检查导入文件格式是否正确。</font>
	<p>
	<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td height="30" align="left" valign="middle" class="tdborder02">
    <%
    String resultstring="";;
    if(request.getAttribute("importresult")!=null){
        resultstring=(String)request.getAttribute("importresult");
        resultstring=resultstring.replaceAll("\\n","<br>");
    }
    %>
	<font size="2.8"><%=resultstring%></font>	
	</td>
	</tr>
    </table>
	<p>
<input type="submit" class="button_nor" value="返 回">
</center>
	
</html:form>
</html:html>
