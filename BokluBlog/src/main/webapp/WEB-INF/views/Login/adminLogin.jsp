<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
  <head>
    <title>Sign In</title>
    <script type="text/javascript">
      $(document).ready(function(){
    	  ParFw.togglePassword();
      });
    </script> 
  </head>
  <body>
   
      <div class="container">
        <div class="row">
          <div class="panel panel-primary">
            <div class="panel-body">
              <c:url var="adminLoginData" value="/admin" /> 
              <form action="${adminLoginData }" method="POST" role="form">
                <div class="form-group"><h2>Sign In</h2></div>
                <div class="form-group">
                   <strong>UserName</strong>
                  <input id="signinEmail" type="text" name="username" maxlength="50" class="form-control"> 
                </div>
                <div class="form-group">
                   <strong>Password</strong>
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
	               <div style="color: blue"><h5>${successMessage}</h5></div>
                <p class="form-group">By signing you are agreeing to our <a href="#">Terms of use</a> and our <a href="#">Privacy Policy</a>.</p>
              </form>
            </div>
          </div>
        </div>
      </div> 
  </body>
</html>
