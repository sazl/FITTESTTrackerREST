<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="readOnly" required="false" %>
<%@ attribute name="entity" required="true" %>
<%@ attribute name="id" required="true" %>

<div class="btn-toolbar"
     role="toolbar"
     style="text-align: center;">
  
  <c:if test="${not readOnly}">
    <div class="btn-group btn-group-md">
      <button type="button"
              class="btn btn-danger"
              onclick="ftUI.deleteEntityDialog('${entity}', '${id}')"
              data-toggle="tooltip"
              data-placement="top"
              title="Delete">
        <span class="glyphicon glyphicon-trash"></span>
      </button>
    </div>
    <div class="btn-group btn-group-md">
      <form action="<c:url value="/${entity}/${id}/edit" />">
        <button type="submit"
                class="btn btn-default"
                data-toggle="tooltip"
                data-placement="top"
                title="Edit">
          <span class="glyphicon glyphicon-edit"></span>
        </button>
      </form>
    </div>
  </c:if>
  
  <div class="btn-group btn-group-md">
    <form action="<c:url value="/${entity}/${id}/view" />">
      <button type="submit"
              class="btn btn-success"
              data-toggle="tooltip"
              data-placement="top"
              title="View">
        <span class="glyphicon glyphicon-eye-open"></span>
      </button>
    </form>
  </div>
</div>
