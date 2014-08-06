<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ attribute name="staffList" required="true" type="java.util.List" %>

<%@ attribute name="simpleTable" required="false" %>

<table
  class="${simpleTable ?  'table' : 'default-dataTable'} display table-bordered">
  <thead>
    <tr>
      <th>Index</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Title</th>
      <th>Staff Type</th>
      <th>Profile Type</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="staff" items="${staffList}">
      <tr>
        <td class="text-center">
          ${staff.id}
        </td>
        <td>
          ${staff.firstName}
        </td>
        <td>
          ${staff.lastName}
        </td>
        <td>
          ${staff.title}
        </td>
        <td>
          ${staff.staffTypeDescription}
        </td>
        <td>
          <t:listGroup items="${staff.profileTypeDescriptions}" />
        </td>
        <td>
          <t:actionButtons
            entity="staffList"
            id="${staff.id}" />          
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
