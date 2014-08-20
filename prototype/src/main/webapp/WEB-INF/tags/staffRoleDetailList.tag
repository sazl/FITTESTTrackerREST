<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@attribute
   name="staffRoles"
   required="true"
   type="java.util.List" %>

<%@ attribute name="showActivity" required="false" %>

<table class="simple-dataTable display" cellspacing="0">
  <thead>
    <tr>
      <th>
        Staff
      </th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="staffRole" items="${staffRoles}">
      <tr>
        <td>
          <ul class="media-list">
            <li class="media">
              <a class="pull-left" href="#">
                <img class="media-object"
                     width="40"
                     height="40"
                     src="<c:url value="/fittesttracker/images/profile.jpg" />"
                     alt="Profile Image">
              </a>
              <div class="media-body">
                <c:url
                  var="staffLink"
                  value="/staffList/${staffRole.staffDto.id}/view" />
                <a href="${staffLink}" target="_blank">
                  <c:out value="${staffRole.staffDto.name}" />
                </a>
                <br/>
                <ul class="list-inline">
                  <c:forEach var="pt" items="${staffRole.staffDto.profileTypeDescriptions}" >
                    <li style="font-size: 8pt;">
                      <c:choose>
                        <c:when test="${staffRole.activityRoleProfileTypeDescription == pt}">
                          <label class="label label-default">
                            ${pt}
                          </label>
                        </c:when>
                        <c:otherwise>
                          <b>${pt}</b>
                        </c:otherwise>
                      </c:choose>
                    </li>
                  </c:forEach>
                </ul>

                <label class="label label-success">
                  <fmt:formatDate
                    pattern="dd/MM/yyyy"
                    value="${staffRole.startDate}"/>
                </label>
                &nbsp; to &nbsp;
                <label class="label label-warning">
                  <fmt:formatDate
                    pattern="dd/MM/yyyy"
                    value="${staffRole.endDate}"/>
                </label>
                <c:if test="${showActivity}">
                  <label class="label label-primary pull-right">
                    ${staffRole.activityRoleDescription}
                  </label>
                </c:if>
              </div>
            </li>
          </ul>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
