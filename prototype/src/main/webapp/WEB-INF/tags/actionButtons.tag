<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="entity" required="true" %>
<%@ attribute name="id" required="true" %>

<div class="btn-toolbar"
     role="toolbar"
     style="text-align: center;">
  <div class="btn-group btn-group-sm">
    <button class="btn btn-danger" onclick="ftUI.deleteEntityDialog('${entity}', '${id}')">
      <span class="glyphicon glyphicon-trash"></span> Delete
    </button>
  </div>
  <div class="btn-group btn-group-sm">
    <form action="<c:url value="/${entity}/${id}/edit" />">
      <button type="submit"
              class="btn btn-sm btn-default">
        <span class="glyphicon glyphicon-edit"></span> Edit
      </button>
    </form>
  </div>
  <div class="btn-group btn-group-sm">
    <form action="<c:url value="/${entity}/${id}/view" />">
      <button type="submit"
              class="btn btn-sm btn-success">
        <span class="glyphicon glyphicon-eye-open"></span> View
      </button>
    </form>
  </div>
</div>

