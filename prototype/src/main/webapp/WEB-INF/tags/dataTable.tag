<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="type" required="false" %>
<%@attribute name="type" required="false" %>

<%@attribute name="tableRow" fragment="true" %>
<%@attribute name="tableHeader" fragment="true" %>
<%@attribute name="tableActionButtons" fragment="true" %>
<%@ attribute name="simpleTable" required="false" %>

<table
  class="${dataTable ?  'table' : 'default-dataTable'} display table-bordered">
  <thead>
    <jsp:invoke fragment="tableBody" />    
  </thead>
  <tbody>
  </tbody>
</table>
