<%@ page
   language="java"
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Planning">
  <jsp:body>
    <div class="col-sm-12">
      <div class="row">
        <jsp:include page="/WEB-INF/partials/planning/planning-table.jsp" />
      </div>
    </div>
  </jsp:body>
</t:page>
