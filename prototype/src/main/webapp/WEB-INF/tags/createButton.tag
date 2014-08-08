<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="u" uri="/WEB-INF/tags/util/util.tld" %>

<%@ attribute name="entity" required="true" %>

<form action="<c:url value="/${entity}/new" />">
  <button id="${entity}-create-button"
          class="btn btn-success create-button">
    <span class="glyphicon glyphicon-plus"></span>&nbsp;
    ${u:capitalize('hello')}
  </button>
</form>
