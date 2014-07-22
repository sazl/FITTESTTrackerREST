<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<table class="default-dataTable display table-bordered">
  <thead>
    <tr>
      <th>Description</th>
      <th>Activity Type</th>
      <th>Confirmed Type</th>
      <th>ETC Service Map</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="activity" items="${allActivities}">
      <tr>
        <td>${activity.description}</td>
        <td>${activity.activityTypeBean.activityType}</td>
        <td>
          <t:colorLabel
            color="${activity.confirmedTypeBean.confirmedColorCode}"
            text="${activity.confirmedTypeBean.confirmedType}" />
        </td>
        <td>
          <c:if test="${activity.etcServiceMap != ''}">
            <t:tooltipLink href="${activity.etcServiceMap}"/>
          </c:if>
        </td>
        <td>
          <t:listGroup items="${activity.countryBeans}" property="fullName" />
        </td>
        <td></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
