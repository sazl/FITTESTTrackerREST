<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="row" style="padding-bottom: 20px;">
  <div id="timeline">
  </div>
</div>

<div class="row">
  <form class="form-horizontal"
        role="form"
        id="deployment-form"
        data-parsley-validate>
    <div class="col-sm-4">
      <div class="well well-sm">
        <t:formGroup label="Start Date">
          <input id="startDate" type="text" class="form-control datepicker" />
        </t:formGroup>
        <t:formGroup label="End Date">
          <input id="endDate" type="text" class="form-control datepicker" />
        </t:formGroup>
      </div>

      <div class="well well-sm">
        <t:formGroup label="Show Confirmed Only">
          <input id="showConfirmedOnly" type="checkbox" class="form-control" />
        </t:formGroup>
      </div>
      <div class="well well-sm">
        <t:formGroup label="Activity">
          <select id="activities" class="form-control"
                  size="10"
                  multiple="true"></select>
        </t:formGroup>
      </div>
    </div>
</div>

<div class="row">
  <div class="col-sm-4">
    <div class="btn-toolbar">
      <button
        type="reset"
        class="btn btn-md btn-danger">
        <span class="glyphicon glyphicon-remove"> Cancel</span>
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
</div>
