<%@ tag language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="pageTitle" required="true" %>
<%@attribute name="jsinit" fragment="true"%>
<%@attribute name="jsready" fragment="true"%>

<t:genericPage>
  <jsp:attribute name="meta">
    <jsp:include page="/WEB-INF/partials/meta.jsp" />
    <title>FITTESTTracker - ${pageTitle}</title>
  </jsp:attribute>

  <jsp:attribute name="jsload">
    <jsp:include page="/WEB-INF/partials/jsload.jsp" />
  </jsp:attribute>

  <jsp:attribute name="_jsinit">
    <jsp:invoke fragment="jsinit"/>
    <script type="text/javascript">
     $(document).ready(function() {
       <jsp:invoke fragment="jsready"/>
     });
    </script>
  </jsp:attribute>
  
  <jsp:body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="page-content">
      <div class="container-fluid">
        <div class="row">
          <jsp:include page="/WEB-INF/partials/sidebar.jsp" />
          <div class="col-sm-10 col-sm-offset-2">
            <div class="page-main-content">
              <jsp:doBody />
            </div>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
  
</t:genericPage>
