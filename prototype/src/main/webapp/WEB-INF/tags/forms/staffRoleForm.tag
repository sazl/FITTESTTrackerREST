<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="activityRoles" required="true" type="java.util.List" %>
<%@ attribute name="confirmedTypes" required="true" type="java.util.List" %>
<%@ attribute name="staffList" required="true" type="java.util.List" %>

<form:form
  class="form-horizontal"
  role="form"
  id="staff-role-form"
  modelAttribute="staffRole">
  <t:formGroup label="Activity Role">
    <form:select
      class="form-control"
      items="${activityRoles}"
      path="activityRoleDto"
      multiple="false" />
  </t:formGroup>
  <t:formGroup label="Staff">
    <form:select
      class="form-control"
      items="${staffList}"
      path="staffDto"
      multiple="false" />
  </t:formGroup>  
  <t:formGroup label="Confirmed Type">
    <form:select
      class="form-control"
      items="${confirmedTypes}"
      path="confirmedTypeDto"
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
  <t:formGroup label="Location">
    <form:input
      class="form-control"
      type="text"
      path="location" />
  </t:formGroup>
  <t:formGroup label="Comments">
    <form:input
      class="form-control"
      type="text"
      path="comments" />
  </t:formGroup>
</form:form>
