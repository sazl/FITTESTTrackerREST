<%@ page
   language="java"
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ taglib
   prefix="c"
   uri="http://java.sun.com/jsp/jstl/core" %>
<div
  id="sidebar"
  class="col-sm-2 collapse sidebar"
  role="navigation">
  <ul class="nav nav-sidebar">
    <li>
      <a href="<c:url value="/dashboard" />">
        <span class="glyphicon glyphicon-home"> Dashboard</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/planning" />">
        <span class="glyphicon glyphicon-time"> Planning</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/deployment" />">
        <span class="glyphicon glyphicon-info-sign"> Deployment</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/requirement" />">
        <span class="glyphicon glyphicon-search"> Requirement</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/activity" />">
        <span class="glyphicon glyphicon-star"> Activity</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/staff" />">
        <span class="glyphicon glyphicon-user"> Staff</span>
      </a>
    </li>
    <li>
      <a href="<c:url value="/misc" />">
        <span class="glyphicon glyphicon-stats"> Misc</span>
      </a>
    </li>
  </ul>
</div>
