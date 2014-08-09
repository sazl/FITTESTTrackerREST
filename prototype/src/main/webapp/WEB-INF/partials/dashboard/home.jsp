<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<div class="staff-bis col-sm-4">
  <t:defaultPanel title="Break-in-service">
    <jsp:attribute name="panelBody">
      <t:staffDetailList staffList="${staffBIS}" />
    </jsp:attribute>
  </t:defaultPanel>
</div>

<div class="staff-available col-sm-4">
  <t:defaultPanel title="Available">
    <jsp:attribute name="panelBody">
      <t:staffDetailList staffList="${staffAvailable}" />
    </jsp:attribute>
  </t:defaultPanel>
</div>

<div class="staff-notavailable col-sm-4">
  <t:defaultPanel title="Not Available">
    <jsp:attribute name="panelBody">
      <t:staffDetailList staffList="${staffNotAvailable}" />
    </jsp:attribute>
  </t:defaultPanel>
</div>
