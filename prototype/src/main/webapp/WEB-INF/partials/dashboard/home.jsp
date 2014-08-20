<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<div class="row">
  <div class="staff-bis col-sm-4">
    <t:defaultPanel
      type="panel-primary"
      title="Break-in-service">
      <jsp:attribute name="panelBody">
        <t:staffRoleDetailList
          staffRoles="${staffRolesBIS}" />
      </jsp:attribute>
    </t:defaultPanel>
  </div>

  <div class="staff-available col-sm-4">
    <t:defaultPanel
      type="panel-success"
      title="Available">
      <jsp:attribute name="panelBody">
        <t:staffDetailList
          staffList="${staffAvailable}" />
      </jsp:attribute>
    </t:defaultPanel>
  </div>

  <div class="staff-notavailable col-sm-4">
    <t:defaultPanel
      type="panel-danger"
      title="Not Available">
      <jsp:attribute name="panelBody">
        <t:staffRoleDetailList
          showActivity="true"
          staffRoles="${staffRolesNotAvailable}" />
      </jsp:attribute>
    </t:defaultPanel>
  </div>
</div>
