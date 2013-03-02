<%@page pageEncoding="GBK"%>
<%@ include file = "../tiles/include.jsp"%>
<bean:define id="title">
<bean:message bundle="security" key="security.title"/>
</bean:define>
<bean:define id="accountTitle">
<bean:message bundle="security" key="security.account"/>
</bean:define>
<bean:define id="roleTitle">
<bean:message bundle="security" key="security.role"/>
</bean:define>
<bean:define id="resourceTitle">
<bean:message bundle="security" key="security.resource"/>
</bean:define>
<center>
 <gui:window title = "<%=title%>" prototype = "boWindow" color = "100%">
  <gui:tabbedPanel prototype = "boTabbedPanel" followUp = "listAccount.do" color = "#f0f0f0" selectedTab = "tab2"
      width = "52">
   <gui:tab prototype = "boTab" name = "tab1" title = "<%=accountTitle%>" followUp = "accountSecurityManager.do?method=searchAccount">
	account manager
   </gui:tab>

   <gui:tab prototype = "boTab" name = "tab2" title = "<%=roleTitle%>" followUp="roleManager.do?method=loadRole">
	<html:form action = "removeRole.do?method=removeRole">
	<html:errors/>
	<table class="sort-table" cellSpacing="1" cellPadding="1" width="100%" border="0">
	<thead>
        <tr>
			<td colspan="5"><bean:message  bundle="security" key = "role.list"/></td>
        </tr>
	</thead>
	        <tr>
	        <logic:iterate name="roles" id="role" indexId="index">

            <c:if test="${index%5==0}"></tr><tr><td><input type="checkbox" name="id" value="<bean:write  name="role" property="id" />">
			<a href="roleManager.do?method=loadRole4Edit&id=<bean:write  name="role" property="id" />"><bean:write  name="role" property="name" /></a></td></c:if>
            <c:if test="${index%5!=0}">
			<td><input type="checkbox" name="id" value="<bean:write  name="role" property="id" />">
			<a href="roleManager.do?method=loadRole4Edit&id=<bean:write  name="role" property="id" />"><bean:write  name="role" property="name" /></a></td>
			</c:if>
        </logic:iterate>
        </tr>
      <tr>
       <td colspan="5" align = "right">
        <html:submit styleClass="button" onclick="bCancel=true;return validSelectedIdForDelete();">
         <bean:message key = "button.delete"/></html:submit>
        <html:reset styleClass="button">
         <bean:message key = "button.reset"/></html:reset>
       </td>
      </tr>
    </html:form>
	</table>

	<html:form action = "addRole?method=addRole" onsubmit = "return validateRoleForm(this);">
	<table class="sort-table" cellSpacing="1" cellPadding="1" width="100%" border="0">
	<thead>
        <tr>
			<td colspan="2"><bean:message  bundle="security" key="role.create"/></td>
        </tr>
	</thead>
	<tr>
		<td><bean:message  bundle="security" key="role.name"/></td>
		<td><html:text property = "role.name" size = "20" maxlength="64"/></td>
	</tr>
	<tr>
		<td><bean:message  bundle="security" key="role.type"/></td>
		<td><html:select property = "role.type" >
                <html:option value="">请选择</html:option>
                <html:option value="0">超级管理员</html:option>
                <html:option value="1">校区管理员</html:option>
                <html:option value="2">院系管理员</html:option>
                <html:option value="3">辅导员</html:option>
                <html:option value="4">任课老师</html:option>
                <html:option value="5">一般角色</html:option>
		   </html:select>
		</td>
	</tr>
    <tr>
        <td><bean:message  bundle="security" key="role.attribute"/></td>
        <td><html:text property = "role.remark" size = "20" maxlength="255"/></td>
    </tr>
	<thead>
	<tr>
		<td colspan="2"><bean:message bundle="security" key="right.title"/></td>
	</tr>
	</thead>
	        <logic:iterate name="resources" id="resource" indexId="i">
        <tr>
			<td><input type="checkbox" name="resource" value="<bean:write  name="resource" property="id" />">
				<bean:write  name="resource" property="code" /></td>
			<td><bean:write  name="resource" property="name" /></td>
        </tr>		
        </logic:iterate>
      <tr>
       <td colspan="2" align = "right">
        <html:submit styleClass="button">
         <bean:message key = "button.save"/></html:submit>
        <html:reset styleClass="button">
         <bean:message key = "button.reset"/></html:reset>
       </td>
      </tr>
    </html:form>
	</table>
   </gui:tab>

             <gui:tab prototype = "boTab" name = "tab3" title = "<%=resourceTitle%>" followUp="resourceManager.do?method=loadResource">
              resource
            </gui:tab>

  </gui:tabbedPanel>
 </gui:window>
</center>
<script language="JavaScript">
  function validSelectedIdForDelete(){
  
   var msg = "确认删除角色?";
    ans = confirm(msg);
    if (ans) {
     var flag = 0;
     var a = document.all("id");
     for  (var  i=0;  i<a.length;  i++){  
         if(a[i].checked==true){
            flag=flag+1;
         }
     }  
     if(flag==0){
         alert("请选择角色!");
         return false;
     }
     return true; 
    } else {
        return false;
    }
 }
 </script>
<html:javascript formName="roleForm"
        dynamicJavascript="true"
         staticJavascript="false"/>
         <script type="text/javascript" src="<html:rewrite forward='staticjavascript'/>"></script>         