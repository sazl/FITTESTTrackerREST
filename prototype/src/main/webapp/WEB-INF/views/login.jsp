<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC
"-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <jsp:include page="/WEB-INF/partials/meta.jsp" />
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/fittesttracker/css/login.css" />" />
    <title>FITTESTTracker - Login</title>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <h1 class="text-center login-title">Sign in to continue to FITTEST Tracker</h1>
          <div class="account-wall">
            <img class="profile-img"
                 src="<c:url value="/fittesttracker/images/profile_alt.png" />"
                 alt="">
            <form
              method="POST"
              action="<c:url value="/authenticate" />"
              class="form-signin">
              <input type="text" class="form-control" placeholder="Email" required autofocus>
              <input type="password" class="form-control" placeholder="Password" required>
              <button class="btn btn-lg btn-primary btn-block" type="submit">
                Sign in</button>
              <label class="checkbox pull-left">
                <input type="checkbox" value="remember-me">
                Remember me
              </label>
              <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
            </form>
          </div>
          <a href="#" class="text-center new-account">Create an account </a>
        </div>
      </div>
    </div>
  </body>
</html>
