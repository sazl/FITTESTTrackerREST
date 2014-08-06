<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<table class="default-dataTable display table-bordered">
  <thead>
    <tr>
      <th>Activity Type</th>
      <th>Color Code</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="activityType" items="${allActivityTypes}">
    <tr>
      <td>${activityType.activityType}</td>
      <td class="text-center">
        <t:colorLabel
          color="${activityType.colorCode}"
          text="${activityType.colorCode}"/>
      </td>
      <td>
        <t:actionButtons
          entity="activity/type"
          id="${activityType.id}" />
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>


