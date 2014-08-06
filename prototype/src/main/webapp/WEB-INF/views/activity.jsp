<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>

<t:page pageTitle="Activity">
  <jsp:body>
    <ul class="nav nav-tabs" role="tablist">
      <li class="active">
        <a href="#activities" role="tab">Activity</a>
      </li>
      <li>
        <a href="#activity-roles" role="tab">Activity Role</a>
      </li>
      <li>
        <a href="#activity-types" role="tab">Activity Type</a>
      </li>
      <li>
        <a href="#events" role="tab">Event</a>
      </li>
    </ul>

    <div class="tab-content">
      <div class="tab-pane active" id="activities">
        <tt:activityTable activities="${allActivities}" />
      </div>
      <div class="tab-pane" id="activity-roles">
        <tt:activityRoleTable activityRoles="${allActivityRoles}" />
      </div>
      <div class="tab-pane" id="activity-types">
        <jsp:include
          page="/WEB-INF/partials/activity/activity-types/activity-types-table.jsp" />
      </div>
      <div class="tab-pane" id="events">

      </div>
    </div>
  </jsp:body>
</t:page>
