<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ attribute name="staffRoles" required="true" type="java.util.List" %>

<%@ attribute name="simpleTable" required="false" %>

<table
  class="${simpleTable ?  'table' : 'default-dataTable'} display table-bordered">
  <thead>
    <tr>
      <th>Activity</th>
      <th>Profile Type</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Confirmed Type</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="staffRole" items="${staffRoles}">
      <tr>
        <td>${staffRole.activityRoleDescription}</td>
        <td>${staffRole.activityRoleProfileTypeDescription}</td>
        <td>${staffRole.staffFirstName}</td>
        <td>${staffRole.staffLastName}</td>
        <td>
          <fmt:formatDate pattern="dd/MM/yyyy" value="${staffRole.startDate}"/>
        </td>
        <td>
          <fmt:formatDate pattern="dd/MM/yyyy" value="${staffRole.endDate}"/>
        </td>
        <td class="text-center">
          <t:colorLabel
            color="${staffRole.confirmedTypeColorCode}"
            text="${staffRole.confirmedTypeDescription}"/>
        </td>
        <td>
          <t:actionButtons
            entity="staffList/role"
            id="${staffRole.id}" />
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
