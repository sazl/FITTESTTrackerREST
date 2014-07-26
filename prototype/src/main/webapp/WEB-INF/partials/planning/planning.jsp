<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-sm-12 col-centered">
  <div class="row">
    <div class="col-sm-4">
      <jsp:include page="/WEB-INF/partials/planning/planning-form.jsp" />
    </div>
    <div class="col-sm-4">
      <div class="well well-sm">
        <jsp:include
          page="/WEB-INF/partials/staff/staff-roles/staff-role-form.jsp" />
      </div>
    </div>
  </div>
  <div class="row">
    <jsp:include page="/WEB-INF/partials/planning/planning-table.jsp" />
  </div>
</div>
