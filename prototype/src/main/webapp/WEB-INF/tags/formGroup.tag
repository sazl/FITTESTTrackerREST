<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="label" required="true" %>
<%@attribute name="formInput" fragment="true"%>

<c:set var="formId"
       value="${fn:replace(fn:toLowerCase(label), ' ', '-')}"/>

<div class="form-group">
  <label for="${formId}" class="col-sm-4 control-label">
    <c:out value="${label}" />
  </label>
  <div id="${formId}" class="col-sm-8">
    <jsp:doBody />
  </div>
</div>
