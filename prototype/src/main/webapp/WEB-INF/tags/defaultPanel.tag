<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="type" required="false" %>
<%@attribute name="title" required="true" %>
<c:set var="typeDefault" value="${panelType ? panelType : 'panel-default'}"/>

<%@attribute name="panelBody" fragment="true" %>

<div class="panel ${typeDefault}">
  <div class="panel-heading">
    <h3 class="panel-title">
      <c:out value="${title}" />
    </h3>
  </div>
  <div class="panel-body">
    <jsp:invoke fragment="panelBody" />
  </div>
</div>
