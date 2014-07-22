<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<table class="default-dataTable display table-bordered">
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
    <c:forEach var="ar" items="${allActivityRoles}">
    <tr>
      <td>${ar.description}</td>
      <td>${ar.profileTypeBean.profileType}</td>
      <td>${ar.location}</td>
      <td>
        <fmt:formatDate pattern="dd-MM-yyyy" value="${ar.startDate}"/>
      </td>
      <td>
        <fmt:formatDate pattern="dd-MM-yyyy" value="${ar.endDate}"/>
      </td>
      <td>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
