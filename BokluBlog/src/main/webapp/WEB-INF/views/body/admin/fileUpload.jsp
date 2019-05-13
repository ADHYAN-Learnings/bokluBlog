<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
   <div class="container-fluid margin-top-6">
     <div class="card">
     <div class="card bg-info">
       <div class="card-header">
        <div class="row no-gutters">
         <div class="col-sm-11 col-md-11 col-lg-11 col-xs-11"><span>File Upload</span></div>
         <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1">
           <span><a href="<spring:url value='/admin/addFileUploadDirectory'/>"> <i class="fa fa-plus" aria-hidden="true"></i></a></span>
         </div>
       </div>
       </div>
     </div>
      <div class="card-body">
       <form:form method="POST" action="/admin/uploadFile" enctype="multipart/form-data" class="form-horizontal">
       <div class="row">
        <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
         <div class="form-group">
           <input type="file" name="files" multiple>
         </div>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
         <div class="form-group">
          <select name="imageFolder" class="form-control">
          <c:forEach items="${imageFolderList}" var="imageFolderList">
           <option value="${imageFolderList.key}">${imageFolderList.value}</option>
          </c:forEach>
          </select>
         </div>
        </div>
        
         <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
         <div class="form-group">
            <input type="submit" class="btn btn-primary" value="submit">
         </div>
        </div>
       </div>
        <h1>${message }</h1>
       </form:form>
      </div>
     </div>
     <script type="text/javascript">
     $("#fileUpload").addClass("active").siblings().removeClass("active");
     </script>
   </div>
 </body>
</html>