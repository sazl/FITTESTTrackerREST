<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@attribute name="entity" required="true"%>

<t:page pageTitle="${entity}">
  <div class="container">
    <div class="col-sm-10 well well-lg">
      <div class="row">
        <jsp:doBody />
      </div>
      <div class="row">
        <div class="btn-group btn-group-md">
          <form action="<c:url value="/${entity}/${id}/view" />">
            <button type="submit"
                    class="btn btn-success">
              <span class="glyphicon glyphicon-ok"></span> Save
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</t:page>
