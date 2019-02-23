<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
  <head>
    <title>Sign In</title>
  </head>
  <body>
   
      <div class="container">
        <div class="row">
          <div class="panel panel-primary">
            <div class="panel-body">
             <c:if test="${activateAccountLinkMessage ne null }">
                   <div class="alert-info"><c:out value="${activateAccountLinkMessage }"></c:out></div>
                </c:if>
              <c:url var="userLoginData" value="/boklu" />
              <form action="${userLoginData }" method="POST" role="form">
                <div class="form-group"><h2>Sign In</h2></div>
                <div class="form-group">
                   <strong>Email or Mobile phone number</strong>
                  <input id="signinEmail" type="email" name="username" maxlength="50" class="form-control"> 
                </div>
                <div class="form-group">
                   <strong>Password</strong>
                   <span class="right"><a href="<spring:url value='/boklu/forgotPassword'/>">Forgot your password?</a></span>
                    <input id="signinPassword" type="password" name="password" maxlength="25" class="form-control">
                    <span toggle="#password" class="field-icon toggle-password" ><i class="fa fa-eye " aria-hidden="true"></i></span> 
                </div>
                <div class="form-group" style="padding-top:12px;">
                  <button id="signinSubmit" type="submit" class="btn btn-success btn-block">Sign In</button>
                </div>
                 <c:if test="${param.error ne null}">
	                <div style="color: red"><h5>Invalid credentials.</h5></div>
                 </c:if>
                 <c:if test="${param.logout ne null}">
	               <div style="color: blue"><h5>You have successfully logged out.</h5></div>
                 </c:if>
                <div class="form-group divider">
                  <hr class="left"><small>New to site?</small><hr class="right">
                </div>
                <p class="form-group"><a href="/boklu/signup" class="btn btn-success btn-block">Create an account</a></p>
                <p class="form-group">By signing you are agreeing to our <a href="#">Terms of use</a> and our <a href="#">Privacy Policy</a>.</p>
                <p><c:if test="${verifiedSuccess ne null }">
                  <div class="alert alert-success"><c:out value="${verifiedSuccess}"></c:out></div>
                </c:if>
                <c:if test="${registrationExpiredMessage ne null }">  
                  <div class="alert alert-info"><c:out value="${registrationExpiredMessage }"></c:out></div>
                </c:if>
                <c:if test="${accountInvalidMessage  ne null }">
                  <div class="alert alert-danger"><c:out value="${accountInvalidMessage }"></c:out></div>
                </c:if>
                <c:if test="${passwordResetEmailMessage  ne null }">
                  <div class="alert alert-info"><c:out value="${passwordResetEmailMessage }"></c:out></div>
                </c:if>
                </p>
              </form>
            </div>
          </div>
        </div>
      </div> 
  </body>
</html>