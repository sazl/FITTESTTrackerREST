<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="activityRole" required="true"
              type="org.wfp.fittest.dto.ActivityRoleDto" %>
<%@ attribute name="activities" required="true" type="java.util.List" %>
<%@ attribute name="profileTypes" required="true" type="java.util.List" %>
<%@ attribute name="staffRoles" required="true" type="java.util.List" %>

<c:url var="activityRoleSave" value="/activityRole/save" />

<form:form
  method="POST"
  action="${activityRoleSave}"
  class="form-horizontal"
  role="form"
  id="activity-role-form"
  modelAttribute="activityRole">
  <form:hidden
    path="id" />
  <t:formGroup label="Activity">
    <form:select
      class="form-control"
      items="${activities}"
      itemValue="id"
      itemLabel="description"
      path="activityId"
      multiple="false"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Profile Type">
    <form:select
      class="form-control"
      items="${profileTypes}"
      itemValue="id"
      itemLabel="profileType"
      path="profileTypeId"
      multiple="false"
      disabled="${readOnly ? 'true' : 'false'}" />
  </t:formGroup>
  <t:formGroup label="Location">
    <form:input
      class="form-control"
      type="text"
      path="location"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
  <t:formGroup label="Start Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="startDate"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
  <t:formGroup label="End Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="endDate"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
  <t:formGroup label="Staff Roles">
    <tt:staffRoleTable
      simpleTable="true"
      staffRoles="${activityRole.staffRoleDtos}" />
  </t:formGroup>

  <c:if test="${not readOnly}">
    <t:formGroup label="">
      <div class="btn-group btn-group-md">
        <button type="submit"
                class="btn btn-success">
          <span class="glyphicon glyphicon-ok"></span> Save
        </button>
      </div>
    </t:formGroup>
  </c:if>
</form:form>
