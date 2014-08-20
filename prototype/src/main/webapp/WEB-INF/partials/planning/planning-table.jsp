<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<table id="planning-table"
       class="table table-bordered table-responsive table-striped">
  <thead>
    <tr>
      <th style="width: 5%;">
        <button id="planning-table-collapse-button"
                class="btn btn-sm btn-warning">
          <span class="glyphicon glyphicon-chevron-up"> Collapse</span>
        </button>
      </th>
      <th style="width: 25%;">Profile</th>
      <th style="width: 30%;">Location</th>
      <th style="width: 15%;">Start Date</th>
      <th style="width: 15%;">End Date</th>
    </tr>
  </thead>
  <tbody id="planning-table-body">

  </tbody>
</table>
