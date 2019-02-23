<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
  <head>
    <title>Forgot Password</title>
  </head>
  <body>
    <div class="container mt-5 borderColor">
      <div class="row">
         <div class="panel panel-primary p-2">
          <div class="panel-body">
             <c:url var="userPasswordReset" value="/boklu/passwordReset" />
            <form:form action="${ userPasswordReset}" method="post" modelAttribute="passwordReset">
            
            <div class="form-group"> 
              <h3 class="text-center"><i class="fa fa-lock fa-4x"></i></h3>
              <h2 class="text-center">Forgot Password?</h2>
            </div>
            
            <div class="form-group">
             <form:label class="control-label" path="email">Enter your Email</form:label> 
             <form:input path="email" maxlength="50" class="form-control" />
             <form:errors path="email" cssClass="error"></form:errors> 
           </div>
             
             <div class="form-group" style="padding-top:12px;">
                  <button id="resetPassword" type="submit" class="btn btn-success btn-block">Continue</button>
                </div>
             <div class="form-group divider"></div>
                <p class="form-group">By signing you are agreeing to our <a href="#">Terms of use</a> and our <a href="#">Privacy Policy</a>.</p>
            </form:form> 
             </div>
            </div>
          </div>
        </div> 
  </body>
</html>