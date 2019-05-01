<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
   <div class="container-fluid margin-top-6">
     <div class="card">
      <div class="card-header bg-info">File Upload</div>
      <div class="card-body">
       <form:form method="POST" action="/admin/uploadFile" enctype="multipart/form-data" class="form-horizontal">
       <div class="row">
        <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
         <div class="form-group">
           <input type="file" name="files" multiple>
         </div>
        </div>
         <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
         <div class="form-group">
            <input type="submit" value="submit">
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