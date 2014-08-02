<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Misc">
  <jsp:body>
    <ul class="nav nav-tabs" role="tablist">
      <li class="active">
        <a href="#countries" role="tab">Countries</a>
      </li>
      <li>
        <a href="#languages" role="tab">Languages</a>
      </li>
      <li>
        <a href="#confirmed-types" role="tab">Confirmed Types</a>
      </li>
    </ul>

    <div class="tab-content">
      <div class="tab-pane active" id="countries">
        <jsp:include page="/WEB-INF/partials/misc/countries.jsp" />
      </div>
      <div class="tab-pane" id="languages">
        <jsp:include page="/WEB-INF/partials/misc/languages.jsp" />
      </div>
      <div class="tab-pane" id="confirmed-types">
        <jsp:include page="/WEB-INF/partials/misc/confirmed-types.jsp" />
      </div>
    </div>
  </jsp:body>
</t:page>
