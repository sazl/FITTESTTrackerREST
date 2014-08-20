<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="country" required="true"
              type="org.wfp.fittest.dto.CountryDto" %>

<c:url var="countrySave" value="/country/save" />

<form:form
  method="POST"
  action="${countrySave}"
  class="form-horizontal"
  role="form"
  id="staff-type-form"
  modelAttribute="country">
  <form:hidden
    path="id" />
  <t:formGroup label="ISO Code">
    <form:input
      class="form-control"
      type="text"
      path="isoCode" />
  </t:formGroup>
  <t:formGroup label="Name">
    <form:input
      class="form-control"
      type="text"
      path="fullName" />
  </t:formGroup>
    <t:formGroup label="Region">
    <form:input
      class="form-control"
      type="text"
      path="region" />
  </t:formGroup>
  <t:formGroup label="Activities">
    <tt:activityTable
      simpleTable="true"
      activities="${country.activityDtos}"/>
  </t:formGroup>
  
  <t:formGroup label="">
    <div class="btn-group btn-group-md">
      <button type="submit"
              class="btn btn-success">
        <span class="glyphicon glyphicon-ok"></span> Save
      </button>
    </div>
  </t:formGroup>
</form:form>
