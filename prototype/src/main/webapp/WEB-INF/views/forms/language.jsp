<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="tf" tagdir="/WEB-INF/tags/forms" %>

<t:formPage entity="language">
  <tf:languageForm
    language="${language}" />
</t:formPage>
