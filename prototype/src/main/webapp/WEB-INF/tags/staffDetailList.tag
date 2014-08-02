<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="staffList" required="true" type="java.util.List" %>

<ul class="media-list">
  <c:forEach var="staff" items="${staffList}">
    <li class="media">
      <a class="pull-left" href="#">
        <img class="media-object" src="" alt="">
      </a>
    <div class="media-body">
      <h4 class="media-heading">
        <c:out value="${staff.name}" />
      </h4>
    </div>
    </li>
  </c:forEach>
</ul>
