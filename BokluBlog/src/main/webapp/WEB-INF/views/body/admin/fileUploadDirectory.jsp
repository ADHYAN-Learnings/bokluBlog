<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
 <body>
   <div class="container-fluid margin-top-6">
     <div class="card">
      <div class="card-header bg-info">File Upload Directory</div>
      <div class="card-body">
       <form action="/admin/createDirectory" method="POST" class="form-horizontal">
         <div class="row">
         
           <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
             <div class="form-group">
              <label for="imageFolder">List of Folder:</label>
               <select name="imageFolder" class="form-control">
                <c:forEach items="${imageFolderList}" var="imageFolderList">
                 <option value="${imageFolderList.key}">${imageFolderList.value}</option>
                </c:forEach>
               </select>
             </div>
           </div>
           
            <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
             <div class="form-group">
               <label for="newDirectory">Add New Directory:</label>
               <input class="form-control" type="text" name="newDirectory">
             </div>
            </div>
            
            <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
             <div class="form-group">
             <label for="submit">submit:</label>
              <input type="submit" class="btn btn-primary form-control" value="submit">
             </div>
           </div>
        
         </div>
          <div style="color: blue"><h5>${message}</h5></div>
       </form>
      </div>
     </div>
   </div>
 </body>
</html>