<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
 <head><title>Password Change</title></head>
 <body>
  <div class="container">
    <div class="row">
     <div class="panel panel-primary">
       <div class="panel-body">
         <c:url var="passwordChangeData" value="/admin/savePassworChange"/>
         <form:form action="${passwordChangeData}" method="post" modelAttribute="passwordChange">
         
          <form:errors path="*" cssClass="error" />
          
          <div class="form-group">
           <h2>Password Change</h2>
          </div>
             
          <div class="form-group">
            <form:label class="control-label" path="newPassword">Enter New Password</form:label>
            <form:password path="newPassword" maxlength="50" class="form-control"/>
            <form:errors path="newPassword" cssClass="error"></form:errors> 
          </div>
          
          <div class="form-group">
            <form:label class="control-label" path="confirmNewPassword">Confirm New Password</form:label>
            <form:password path="confirmNewPassword" maxlength="50" class="form-control"/>
            <form:errors path="confirmNewPassword" cssClass="error"></form:errors> 
          </div>
          
          <div class="form-group">
           <button id="signupSubmit" type="submit" class="btn btn-info btn-block">Change Password</button>
          </div>
         
         </form:form>
       </div>
     </div>
    </div>
  </div>
 </body>
</html>