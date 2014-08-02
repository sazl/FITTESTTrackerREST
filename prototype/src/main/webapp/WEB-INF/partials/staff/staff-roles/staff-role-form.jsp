<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form
  class="form-horizontal"
  role="form"
  id="staff-role-form"
  modelAttribute="${staffRole}">
  <t:formGroup label="Staff">
    <form:select id="staff-role-staff" class="form-control" path="">
      <form:option value="" disabled="true" selected="true">
        -- Select a staff member --
      </form:option>
    </form:select>
  </t:formGroup>
  <t:formGroup label="Location">
    <form:input id="staff-role-location"
                path=""
                type="text" class="form-control" />
  </t:formGroup>
  <t:formGroup label="Start Date">
    <form:input id="staff-role-startDate"
                path=""
                type="text" class="form-control datepicker" />
  </t:formGroup>
  <t:formGroup label="End Date">
    <form:input id="staff-role-endDate"
                path=""
                type="text" class="form-control datepicker" />
  </t:formGroup>
  <t:formGroup label="Comments">
    <form:input id="staff-role-comments"
                type="text"
                class="form-control"
                path="" />
  </t:formGroup>
  
  <t:formGroup label="Activity Role">
    <form:select id="staff-role-activityRoles" class="form-control" path="">
      <form:option value="" disabled="true" selected="true">
        -- Select an activity role --
      </form:option>
    </form:select>
  </t:formGroup>

  <t:formGroup label="Confirmed Type">
    <form:select id="staff-role-confirmedTypes" class="form-control" path="">
      <form:option value="" disabled="true" selected="true">
        -- Select a confirmed type --
      </form:option>
    </form:select>
  </t:formGroup>

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
</form:form>
