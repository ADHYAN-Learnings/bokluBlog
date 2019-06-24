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
         <c:url var="userLoginData" value="/boklu/register" />
         <form:form action="${ userLoginData}" method="post" modelAttribute="userRegistration">
         
         <form:errors path="*" cssClass="error" />
         <div class="form-group">
          <h2>Create account</h2>
         </div>
         <div class="form-group">
            <form:label class="control-label" path="username">Enter your name</form:label>
            <form:input path="username" maxlength="50" class="form-control"/>
            <form:errors path="username" cssClass="error"></form:errors> 
         </div>
         <div class="form-group">
            <form:label class="control-label" path="email">Enter your Email</form:label>
            <form:input path="email" maxlength="50" class="form-control"/>
             <form:errors path="email" cssClass="error"></form:errors> 
         </div>
         <div class="form-group">
           <form:label class="control-label" path="password">Password</form:label>
           <form:input type="password" path="password" maxlength="25" class="form-control"/>
           <span toggle="#password" class="field-icon toggle-password" ><i class="fa fa-eye " aria-hidden="true"></i></span>
           <form:errors path="password" cssClass="error"></form:errors>
         </div>
         <div class="form-group">
           <form:label class="control-label" path="passwordConfirmation">Password Confirmation</form:label>
           <form:input type="password" path="passwordConfirmation" maxlength="25" class="form-control"/>
            <span toggle="#password" class="field-icon toggle-password" ><i class="fa fa-eye " aria-hidden="true"></i></span>
           <form:errors path="passwordConfirmation" cssClass="error"></form:errors>
         </div>
         <div class="form-group">
           <button id="signupSubmit" type="submit" class="btn btn-info btn-block">Create your account</button>
         </div>
         <p class="form-group">By Creating an account you agree to our <a href="#">Terms of use</a> and our<a>Privacy Policy</a>.</p> 
         <hr>
         <p>Already have an account?<a href="/boklu/userLogin">Sign in</a></p>
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>