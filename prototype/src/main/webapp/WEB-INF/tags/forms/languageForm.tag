<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute
   name="language"
   required="true"
   type="org.wfp.fittest.dto.LanguageDto" %>

<c:url var="languageSave" value="/language/save" />

<form:form
  method="POST"
  action="${languageSave}"
  class="form-horizontal"
  role="form"
  id="staff-type-form"
  modelAttribute="language">
  <form:hidden
    path="id" />
  <t:formGroup label="Language">
    <form:input
      class="form-control"
      type="text"
      path="language" />
  </t:formGroup>
  <t:formGroup label="Staff By Language">
    <tt:staffTable
      simpleTable="true"
      staffList="${language.staffByLanguageDtos}"/>
  </t:formGroup>
  
  <t:formGroup label="">
    <div class="btn-group btn-group-md">
      <button type="submit"
              class="btn btn-success">
        <span class="glyphicon glyphicon-ok"></span> Save
      </button>
    </div>
  </t:formGroup>
</form:form>
