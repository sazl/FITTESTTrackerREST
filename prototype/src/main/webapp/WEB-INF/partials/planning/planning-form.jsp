<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<form class="form-horizontal" role="form">
  <div class="well well-sm">
    <t:formGroup label="Confirmed Type">
      <select id="confirmedTypes" class="form-control"></select>
    </t:formGroup>
  </div>

  <div class="well well-sm">
    <t:formGroup label="Activity">
      <select id="activities" class="form-control"></select>
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
  </div>
</form>
