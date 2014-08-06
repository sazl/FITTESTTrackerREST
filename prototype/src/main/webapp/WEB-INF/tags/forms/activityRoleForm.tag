<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="activityRole" required="true"
              type="org.wfp.fittest.dto.ActivityRoleDto" %>
<%@ attribute name="activities" required="true" type="java.util.List" %>
<%@ attribute name="profileTypes" required="true" type="java.util.List" %>
<%@ attribute name="staffRoles" required="true" type="java.util.List" %>

<form:form
  class="form-horizontal"
  role="form"
  id="activity-role-form"
  modelAttribute="activityRole">
  <t:formGroup label="Activity">
    <form:select
      class="form-control"
      items="${activities}"
      path="activityDto"
      multiple="false" />
  </t:formGroup>
  <t:formGroup label="Profile Type">
    <form:select
      class="form-control"
      items="${profileTypes}"
      path="profileTypeDto"
      multiple="false" />
  </t:formGroup>
  <t:formGroup label="Start Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="startDate" />
  </t:formGroup>
  <t:formGroup label="End Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="endDate" />
  </t:formGroup>
  <t:formGroup label="Staff Roles">
    <form:select
      class="form-control"
      items="${staffRoles}"
      path="staffRoleDtos"
      multiple="true" />
  </t:formGroup>
</form:form>
