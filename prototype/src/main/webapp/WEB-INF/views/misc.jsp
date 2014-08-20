<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>

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
        <tt:countryTable
          readOnly="${readOnly}"
          countries="${allCountries}" />
      </div>
      <div class="tab-pane" id="languages">
        <tt:languageTable
          readOnly="${readOnly}"
          languages="${allLanguages}" />
      </div>
      <div class="tab-pane" id="confirmed-types">
        <tt:confirmedTypeTable
          readOnly="${readOnly}"
          confirmedTypes="${allConfirmedTypes}" />
      </div>
    </div>
  </jsp:body>
</t:page>
