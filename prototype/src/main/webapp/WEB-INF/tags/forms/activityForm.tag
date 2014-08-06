<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="activity" required="true"
              type="org.wfp.fittest.dto.ActivityDto" %>
<%@ attribute name="confirmedTypes" required="true" type="java.util.List" %>
<%@ attribute name="activityTypes" required="true" type="java.util.List" %>
<%@ attribute name="countries" required="true" type="java.util.List" %>

<form:form
  class="form-horizontal"
  role="form"
  id="activity-form"
  modelAttribute="activity">
  <t:formGroup label="Descritpion">
    <form:input
      class="form-control"
      type="text"
      path="description" />
  </t:formGroup>
  <t:formGroup label="ETC Service Map">
    <form:input
      class="form-control"
      type="text"
      path="etcServiceMap" />
  </t:formGroup>
  <t:formGroup label="Confirmed Type">
    <form:select
      class="form-control"
      items="${confirmedTypes}"
      path="confirmedTypeDto"
      multiple="false" />
  </t:formGroup>
  <t:formGroup label="Activity Type">
    <form:select
      class="form-control"
      items="${activityTypes}"
      path="activityTypeDto"
      multiple="false" />
  </t:formGroup>
  <t:formGroup label="Country">
    <form:select
      class="form-control"
      items="${countries}"
      path="countryDtos"
      multiple="true" />
  </t:formGroup>
  <t:formGroup label="Activity Role">
    <tt:activityRoleTable
      simpleTable="true"
      activityRoles="${activity.activityRoleDtos}" />
  </t:formGroup>
</form:form>
