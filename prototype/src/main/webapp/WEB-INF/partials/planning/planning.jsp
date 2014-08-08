<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="col-sm-12">
  <div id="planning-panel"
       class="panel panel-default">
    <div class="panel-heading">
      <button id="collapse-planning-panel"
              class="btn btn-sm btn-danger">
        <span class="glyphicon glyphicon-arrow-up"></span>
      </button> Planning Form
    </div>
    <div id="planning-panel-body"
         class="panel-body">
      <div class="col-sm-6">
        <jsp:include page="/WEB-INF/partials/planning/planning-form.jsp" />
      </div>
      <div class="col-sm-6">
        <div class="well well-sm">
          <jsp:include
            page="/WEB-INF/partials/staff/staff-roles/staff-role-form-js.jsp" />
        </div>
      </div>
    </div>
  </div>

    <div id="planning-table-panel"
         class="panel panel-default">
      <div class="panel-heading">
        <button id="collapse-planning-table-panel"
                class="btn btn-sm btn-danger">
        <span class="glyphicon glyphicon-arrow-up"></span>
      </button> Planning Table
      </div>
      <div class="panel-body"
           id="planning-table-panel-body">
        <jsp:include page="/WEB-INF/partials/planning/planning-table.jsp" />
      </div>

  </div>
</div>
