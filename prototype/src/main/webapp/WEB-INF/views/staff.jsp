<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/tables"%>

<t:page pageTitle="Activity">
  <jsp:body>

    <ul class="nav nav-tabs" role="tablist">
      <li class="active">
        <a href="#staff-list" role="tab">Staff List</a>
      </li>
      <li>
        <a href="#staff-roles" role="tab">Staff Roles</a>
      </li>
      <li>
        <a href="#staff-types" role="tab">Staff Types</a>
      </li>
      <li>
        <a href="#profile-types" role="tab">Profile Types</a>
      </li>
    </ul>

    <div class="tab-content">
      <div class="tab-pane active" id="staff-list">
        <tt:staffTable staffList="${allStaff}" />
      </div>

      <div class="tab-pane" id="staff-roles">
        <tt:staffRoleTable staffRoles="${allStaffRoles}" />
      </div>
      <div class="tab-pane" id="staff-types">
        
      </div>
      <div class="tab-pane" id="profile-types">

      </div>
    </div>
  </jsp:body>
</t:page>
