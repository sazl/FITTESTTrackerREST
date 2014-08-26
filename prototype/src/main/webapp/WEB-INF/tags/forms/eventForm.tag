<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/tables" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="event" required="true"
              type="org.wfp.fittest.dto.EventDto" %>

<c:url var="eventSave" value="/event/save" />

<form:form
  method="POST"
  action="${eventSave}"
  class="form-horizontal"
  role="form"
  id="event-form"
  modelAttribute="event">
  <form:hidden
    path="id" />
  <t:formGroup label="Event">
    <form:input
      class="form-control"
      type="text"
      path="event"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
  <t:formGroup label="Start Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="startDate"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
  <t:formGroup label="End Date">
    <form:input
      class="datepicker form-control"
      type="text"
      path="endDate"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>
    <t:formGroup label="Color Code">
    <form:input
      class="form-control color"
      type="text"
      path="colorCode"
      disabled="${readOnly ? 'true' : 'false'}"
    />
  </t:formGroup>

  <c:if test="${not readOnly}">
    <t:formGroup label="">
      <div class="btn-group btn-group-md">
        <button type="submit"
                class="btn btn-success">
          <span class="glyphicon glyphicon-ok"></span> Save
        </button>
      </div>
    </t:formGroup>
  </c:if>
</form:form>
