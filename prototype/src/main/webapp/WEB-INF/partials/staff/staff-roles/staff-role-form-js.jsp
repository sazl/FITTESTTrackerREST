<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form
  class="form-horizontal"
  role="form"
  id="staff-role-form">
  <input id="staff-role-id" type="hidden" class="form-control" />
  <t:formGroup label="Staff">
    <select id="staff-role-staff" class="form-control"
            ${readOnly ? 'disabled' : ''}
            >
      <option value="" disabled selected>-- Select a staff member --</option>
    </select>
  </t:formGroup>
  <t:formGroup label="Location">
    <input id="staff-role-location" type="text" class="form-control"
           ${readOnly ? 'disabled' : ''}
           />
  </t:formGroup>
  <t:formGroup label="Start Date">
    <input id="staff-role-startDate"
           type="text" class="form-control datepicker"
           ${readOnly ? 'disabled' : ''}
           />
  </t:formGroup>
  <t:formGroup label="End Date">
    <input id="staff-role-endDate"
           type="text" class="form-control datepicker"
           ${readOnly ? 'disabled' : ''}
           />
  </t:formGroup>
  <t:formGroup label="Comments">
    <input
    id="staff-role-comments"
    type="text" class="form-control"
    ${readOnly ? 'disabled' : ''}
    />
  </t:formGroup>
  
  <t:formGroup label="Profile Type">
    <select id="staff-role-activityRoles" class="form-control"
            ${readOnly ? 'disabled' : ''}
            >
      <option value="" disabled selected>-- Select a profile type --</option>
    </select>
  </t:formGroup>

  <t:formGroup label="Confirmed Type">
    <select id="staff-role-confirmedTypes" class="form-control"
            ${readOnly ? 'disabled' : ''}
            >
      <option value="" disabled selected>-- Select a confirmed type --</option>
    </select>
  </t:formGroup>

  <c:if test="${not readOnly}">
    <t:formGroup label="">
      <div class="btn-toolbar">
        <button
          id="staff-role-clear"
          type="reset"
          class="btn btn-md btn-danger">
          <span class="glyphicon glyphicon-remove"> Clear</span>
        </button>
        <button
          id="staff-role-save"
          type="button"
          class="btn btn-md btn-success">
          <span class="glyphicon glyphicon-ok"> Save</span>
        </button>
      </div>
    </t:formGroup>
  </c:if>
</form:form>
