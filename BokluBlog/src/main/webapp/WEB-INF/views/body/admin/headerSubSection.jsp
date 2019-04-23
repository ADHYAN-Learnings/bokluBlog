<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <html>
 <body>
    <div class="container-fluid margin-top-6">
     <div class="card">
       <div class="card-header bg-info">Add Header Sub Section</div>
       <div class="card-body">
       
        <c:set var="headerSubSectionId" value="${headerSubSectionData.subSectionId}"/>
       
       <c:choose>
         <c:when test="${headerSubSectionId ne null }">
          <c:set var="load" value="update"/>
         </c:when>
         <c:otherwise>
          <c:set var="load" value="save"/>
         </c:otherwise>
       </c:choose>
 
       
        <c:url var="adminHeaderSubSectionData" value="/admin/saveHeaderSubSection" />
           <form:form action="${adminHeaderSubSectionData }" method="POST"  modelAttribute="headerSubSectionData">
          
           <div class="row">
           
           <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
            <div class="form-group">
             <form:label class="control-label" path="headerCategory">Enter the headerCategory</form:label>
             <form:select path="headerCategory" class="form-control">
              <c:forEach items="${headerCategories}" var="headerCategory">
               <c:choose>
                 <c:when test="${headerCategory.key eq headerSubSectionData.headerCategory.id }">
                  <form:option value="${headerCategory.key }" selected="selected" ><c:out value="${headerCategory.value }"/></form:option>
                 </c:when>
                 <c:otherwise>
                  <form:option value="${headerCategory.key }"><c:out value="${headerCategory.value }"/></form:option>
                </c:otherwise>
               </c:choose>
                
              </c:forEach>
             </form:select>
             <form:errors path="headerCategory" cssClass="error"></form:errors> 
            </div>
           </div> 
          
           <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
            <div class="form-group">
             <form:label class="control-label" path="subject">Enter the subject</form:label>
             <form:input path="subject" maxlength="50" class="form-control"/>
             <form:errors path="subject" cssClass="error"></form:errors> 
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
              <button class="btn btn-primary btn-block" type="submit"><c:out value="${load}"/></button>
             </div>
            </div>
           </div> 
            <c:if test="${headerSubSectionId ne null}">
               <form:hidden path="subSectionId"/>
             </c:if>
         </form:form> 
       </div>
     </div>
   </div> 
   </body>
</html>  -