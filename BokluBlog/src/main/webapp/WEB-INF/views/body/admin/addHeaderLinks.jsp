<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
    <div class="container-fluid margin-top-6">
     <div class="card">
       <div class="card-header bg-info">Add Header Link</div>
       <div class="card-body">
       
        <c:url var="adminHeaderLinkData" value="/admin/saveHeaderLink" />
         <form:form action="${adminHeaderLinkData }" method="POST"  modelAttribute="headerData">
         <form:errors path="*" cssClass="error" />
           <div class="row">
           
           <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
            <div class="form-group">
             <form:label class="control-label" path="category">Enter the Category</form:label>
             <form:input path="category" maxlength="50" class="form-control"/>
             <form:errors path="category" cssClass="error"></form:errors> 
            </div>
           </div>
          
           <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
            <div class="form-group">
             <form:label class="control-label" path="path">Enter the Path</form:label>
             <form:input path="path" maxlength="50" class="form-control"/>
             <form:errors path="path" cssClass="error"></form:errors> 
          </div> 
           
          </div>
           </div>
           <div class="row">
           
           <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
            <div class="form-group">
            <form:label class="control-label" path="status">Select the status</form:label>
            <form:select path="status" class="form-control"> 
              <form:options items="${statusSelect}"/>
            </form:select>
            <form:errors path="status" cssClass="error"></form:errors> 
            </div>
           </div>
           
            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
             <div class="form-group">
             <form:label class="control-label" path="sequence">Select the Sequence</form:label>
              <form:select path="sequence" class="form-control">
               <form:options items="${sequenceSelect}"/>
              </form:select>
                <form:errors path="sequence" cssClass="error"></form:errors> 
             </div>
           </div>
           
           </div>
           <div class="row">
           
            <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2 offset-sm-10 offset-md-10 offset-lg-10 offset-xs-10" >
             <div class="form-group">
             <button class="btn btn-primary btn-block" type="submit">Load</button>
            </div>
            </div>
           </div>
         
        
         </form:form>
       </div>
     </div>
   </div> 
   </body>
</html>