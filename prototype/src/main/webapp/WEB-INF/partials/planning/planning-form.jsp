<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<form class="form-horizontal" role="form" id="planning-form">
  <t:formGroup label="Confirmed Type">
    <select id="confirmedTypes" class="form-control">
      <option value="" disabled selected>-- Select a confirmed type --</option>
    </select>
  </t:formGroup>

  <t:formGroup label="Activity">
    <select id="activities" class="form-control">
      <option value="" disabled selected>-- Select an activity --</option>
    </select>
  </t:formGroup>
  <t:formGroup label="Country">
    <div class="form-control">
      <ul id="countries" class="list-inline">
        
      </ul>
    </div>
  </t:formGroup>
  <t:formGroup label="Activity Type">
    <label id="activityType" class="form-control">
    </label>
  </t:formGroup>
</form>
