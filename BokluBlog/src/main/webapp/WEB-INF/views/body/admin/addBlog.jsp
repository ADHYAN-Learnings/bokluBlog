<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
   <div class="container-fluid margin-top-6">
    <div class="card">
      <div class="card-header bg-info">Add Blog</div>
       
      <div class="card-body">
      
       <c:set var="blogId" value="${blogData.blogId}"/>
       
       <c:choose>
         <c:when test="${blogId ne null }">
          <c:set var="load" value="update"/>
         </c:when>
         <c:otherwise>
          <c:set var="load" value="save"/>
         </c:otherwise>
       </c:choose>
      
      <c:url var="adminSaveBlogDetails" value="/admin/saveBlogDetails" />
      <form:form id="blogform" action="" method="POST" modelAttribute="blogData" target="">
       
       <div class="row">
         <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
          <div class="form-group">
           <form:label class="control-label" path="headerCategory">Enter the headerCategory</form:label>
           
           <form:select path="headerCategory" 
                        class="form-control ajaxlistload" 
                        data-listName="headerCategory" 
                        data-targetObject="div" 
                        data-targetElements="headerSubject,previousLink,nextLink"
                        data-sender="headerSubjectByHeaderCategory" 
                        id = "headerCategory">
              <c:forEach items="${headerCategories}" var="headerCategory">
              <c:choose>
                <c:when test="${headerCategory.key eq blogData.headerCategory.id}">
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
         
           <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
          <div class="form-group">
           <form:label class="control-label" path="previousLink">Enter the Previous Link</form:label>
           <form:select path="previousLink" class="form-control"  data-listName="previousLink" >
           <c:if test="${not empty headerSubjectData}">
            <c:forEach items="${headerSubjectData}" var="headerSubjectData">
              <c:choose>
                <c:when test="${headerSubjectData.key eq blogData.previousLink.subSectionId}">
                  <form:option value="${headerSubjectData.key }" selected="selected" ><c:out value="${headerSubjectData.value }"/></form:option>  
                </c:when>
                <c:otherwise>
                  <form:option value="${headerSubjectData.key }"><c:out value="${headerSubjectData.value }"/></form:option>
                </c:otherwise> 
              </c:choose>
              </c:forEach>
            </c:if>
           </form:select>
           <form:errors path="previousLink" cssClass="error"></form:errors> 
          </div>
         </div>
         
         <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
          <div class="form-group">
           <form:label class="control-label" path="headerSubject">Enter the Subject</form:label>
           <form:select path="headerSubject" class="form-control"  data-listName="headerSubject" >
            <c:if test="${not empty headerSubjectData }">
             <c:forEach items="${headerSubjectData}" var="headerSubjectData">
              <c:choose>
                <c:when test="${headerSubjectData.key eq blogData.headerSubject.subSectionId}">
                  <form:option value="${headerSubjectData.key }" selected="selected" ><c:out value="${headerSubjectData.value }"/></form:option>  
                </c:when>
                <c:otherwise>
                  <form:option value="${headerSubjectData.key }"><c:out value="${headerSubjectData.value }"/></form:option>
                </c:otherwise> 
              </c:choose>
              </c:forEach>
              </c:if>
           </form:select>
           <form:errors path="headerSubject" cssClass="error"></form:errors> 
          </div>
         </div>
         
       
         <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
          <div class="form-group">
           <form:label class="control-label" path="nextLink">Enter the Next Link</form:label>
           <form:select path="nextLink" class="form-control"  data-listName="nextLink" >
                  <c:if test="${not empty headerSubjectData }">
             <c:forEach items="${headerSubjectData}" var="headerSubjectData">
              <c:choose>
                <c:when test="${headerSubjectData.key eq blogData.nextLink.subSectionId}">
                  <form:option value="${headerSubjectData.key }" selected="selected" ><c:out value="${headerSubjectData.value }"/></form:option>  
                </c:when>
                <c:otherwise>
                  <form:option value="${headerSubjectData.key }"><c:out value="${headerSubjectData.value }"/></form:option>
                </c:otherwise> 
              </c:choose>
              </c:forEach>
              </c:if>
           </form:select>
           <form:errors path="nextLink" cssClass="error"></form:errors> 
          </div>
         </div>
         
       </div>
       <div class="row">
       
       <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
        <div class="form-group">
         <form:label class="control-label" path="blogData">Write Your Blog.</form:label>
         <form:textarea path="blogData" class="form-control" data-textarea="blogData" rows="40" cols="30"/>
         <form:errors path="blogData" cssClass="error"/>
        </div>
       </div>
       
       
       </div>
       <div class="row">
       <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2">
        <button type="submit" class="btn btn-primary btn-block"  onclick="save()"><c:out value="${load}"/></button>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2">
        <button type="submit" class="btn btn-primary btn-block" name="test" value="test" onclick="check()">Test</button>
        </div>
       </div>
       <c:if test="${blogId ne null }">
         <form:hidden path="blogId"/>
       </c:if>
      </form:form>
      
      </div>
    </div>
    <script type="text/javascript">
     
     function check(){
    	$("#blogform").attr("action","/admin/blogTest");
    	$("#blogform").attr("target","_blank");
    	
     }
     function save(){
     	$("#blogform").attr("action","/admin/saveBlogDetails");
     	$("#blogform").attr("target","");
     	
      }
     $("#blog").addClass("active").siblings().removeClass("active");
    </script> 
   </div>
 </body>

</html>