<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ attribute
   name="activityRoles"
   required="true"
   type="java.util.List" %>

<%@ attribute name="simpleTable" required="false" %>

<table
  class="${simpleTable ?  'table' : 'default-dataTable'} display table-bordered">
  <thead>
    <tr>
      <th>Activity</th>
      <th>Profile Type</th>
      <th>Location</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="ar" items="${activityRoles}">
    <tr>
      <td>${ar.activityDescription}</td>
      <td>${ar.profileTypeDescription}</td>
      <td>${ar.location}</td>
      <td>
        <fmt:formatDate pattern="dd/MM/yyyy" value="${ar.startDate}"/>
      </td>
      <td>
        <fmt:formatDate pattern="dd/MM/yyyy" value="${ar.endDate}"/>
      </td>
      <td>
        <t:actionButtons
          entity="activity/role"
          id="${ar.id}" />
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
