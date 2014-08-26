<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="staff" required="true"
              type="org.wfp.fittest.dto.StaffDto" %>
<%@ attribute name="staffTypes" required="true" type="java.util.List" %>
<%@ attribute name="profileTypes" required="true" type="java.util.List" %>
<%@ attribute name="nationalities" required="true" type="java.util.List" %>
<%@ attribute name="languages" required="true" type="java.util.List" %>

<c:url var="staffSave" value="/staffList/save" />

<form:form
  method="POST"
  action="${staffSave}"
  class="form-horizontal"
  role="form"
  id="staff-form"
  modelAttribute="staff">
  <t:formGroup label="Index">
    <form:input
      class="form-control"
      type="text"
      path="id"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="First Name">
    <form:input
      class="form-control"
      type="text"
      path="firstName"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Last Name">
    <form:input
      class="form-control"
      type="text"
      path="lastName"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Date of Birth">
    <form:input
      class="datepicker form-control"
      type="text"
      path="dateOfBirth"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Title">
    <form:input
      class="form-control"
      type="text"
      path="title"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Thuraya Number">
    <form:input
      class="form-control"
      type="text"
      path="thuraya"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Mobile Number">
    <form:input
      class="form-control"
      type="text"
      path="mobile"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Color Code">
    <form:input
      class="form-control"
      type="text"
      path="staffColorCode"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Staff Type">
    <form:select
      class="form-control"
      items="${staffTypes}"
      itemLabel="staffType"
      itemValue="id"
      path="staffTypeId"
      multiple="false"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Profile Type">
    <form:select
      class="form-control"
      items="${profileTypes}"
      itemLabel="profileType"
      itemValue="id"
      path="profileTypeIds"
      multiple="true"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Nationality">
    <form:select
      class="form-control"
      items="${allNationalities}"
      itemLabel="fullName"
      itemValue="id"
      path="nationalityIds"
      multiple="true"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup label="Language">
    <form:select
      class="form-control"
      items="${allLanguages}"
      itemLabel="language"
      itemValue="id"
      path="languageIds"
      multiple="true"
      disabled="${readOnly ? 'true' : 'false'}"/>
  </t:formGroup>
  <t:formGroup
    label="Staff Role">
    <tt:staffRoleTable
      simpleTable="true"
      staffRoles="${staff.staffRoleDtos}" />
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
