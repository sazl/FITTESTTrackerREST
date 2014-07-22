<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<form class="form-horizontal" role="form">
  <div class="well well-sm">
    <t:formGroup label="Confirmed Type">
      <input type="text" class="form-control" />
    </t:formGroup>
  </div>

  <div class="well well-sm">
    <t:formGroup label="Activity">
      <input type="text" class="form-control" />
    </t:formGroup>
    <t:formGroup label="Country">
        <div class="form-control">
          <ul class="list-inline">
            <li>
            </li>
          </ul>
        </div>
    </t:formGroup>
    <t:formGroup label="Activity Type">
      <label class="form-control">
      </label>
    </t:formGroup>
  </div>
</form>
