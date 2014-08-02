<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<table class="default-dataTable display table-bordered">
  <thead>
    <tr>
      <th>Language</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="language" items="${allLanguages}">
      <tr>
        <td>${language.language}</td>
        <td></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
