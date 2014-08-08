<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="row" style="padding-bottom: 20px;">
  <div id="timeline">
  </div>
</div>
<form class="form-horizontal"
      role="form"
      id="requirement-form"
      data-parsley-validate>
  <div class="row">
    <div class="col-sm-4">
      <div class="well well-sm">
        <t:formGroup label="Start Date">
          <input id="startDate" type="text" class="form-control datepicker" required />
        </t:formGroup>
        <t:formGroup label="End Date">
          <input id="endDate" type="text" class="form-control datepicker" required />
        </t:formGroup>
        <t:formGroup label="Time Marker">
          <label id="timelineMarker" class="form-control" disabled="true">
          </label>
        </t:formGroup>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="well well-sm">
        <t:formGroup label="Show Confirmed Only">
          <input id="showConfirmedOnly" class="form-control" type="checkbox" />
        </t:formGroup>
      </div>
      <div class="well well-sm">
        <t:formGroup label="Activity">
          <select id="activities" class="form-control"
                  size="12"
                  multiple="true"
                  required></select>
        </t:formGroup>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-sm-4">
      <div class="btn-toolbar">
        <button
          id="clear-requirement"
          type="reset"
          class="btn btn-md btn-danger">
          <span class="glyphicon glyphicon-remove"> Clear</span>
        </button>
        <button
          id="submit-requirement"
          type="button"
          class="btn btn-md btn-success">
          <span class="glyphicon glyphicon-ok"> Submit</span>
        </button>
      </div>                
    </div>
  </div>
</form>
