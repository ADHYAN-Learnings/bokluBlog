<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
 <head>
   <title>Reset Password</title>
 </head>
 <body>
   <div class="container">
    <div class="row">
      <div class="panel panel-primary">
        <div class="panel-body mt-5 ">
         <c:url var="savePasswordReset" value="/boklu/savePasswordReset" />
          <form:form action="${ savePasswordReset }" method="post">
            <div class="form-group"><h2>Password Assistance</h2></div>
            
            <div class="form-group">
              <label class="control-label" for="Password">Password</label>
              <input type="password" id="password" name="password" maxlength="25" class="form-control">
              <span toggle="#password" class="field-icon toggle-password" ><i class="fa fa-eye " aria-hidden="true"></i></span>
            </div>
            <div class="form-group">
              <label class="control-label" for="Password Confirmation">Password Confirmation</label>
              <input type="password" id="passwordConfirmation" name="passwordConfirmation" maxlength="25" class="form-control" >
              <span toggle="#password" class="field-icon toggle-password" ><i class="fa fa-eye " aria-hidden="true"></i></span>
            </div>
            <div class="form-group">
              <button id="passwordChange" type="submit" class="btn btn-info btn-block">Continue</button>
            </div>
            <p><c:if test="${passwordResetError  ne null }">
                  <div class="alert alert-warning"><c:out value="${passwordResetError }"></c:out></div>
             </c:if></p>  
          </form:form>
        </div>
      </div>
    </div>
   </div>
 </body>

</html>