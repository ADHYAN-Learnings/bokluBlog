<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <body>
    <div class="container-fluid margin-top-6">
     <div class="card bg-info">
       <div class="card-header">
        <div class="row no-gutters">
         <div class="col-sm-11 col-md-11 col-lg-11 col-xs-11"><span>Add BLOG</span></div>
         <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1">
           <span><a href="<spring:url value='/admin/addBlog'/>"> <i class="fa fa-plus" aria-hidden="true"></i></a></span>
         </div>
       </div>
       </div>
     </div>
     <div class="card-body">
        <table id="table"  class="display" style="width:100%">
         <thead>
         <tr>
          <th>Action </th>
          <th>HeaderCategory</th>
          <th>Previous Subject</th>
          <th>Header Subject</th>
          <th>Next Subject</th>
         </tr>
         </thead>
         
         <tbody>
         <c:forEach var="blogData" items="${blogData}">
           <tr>
             <td><span><a href="/admin/editblog/${blogData.blogId }">
              <i class="fa fa-pencil-alt" aria-hidden="true"></i></a></span></td>
             <td><c:out value="${ blogData.headerCategory.category }"></c:out></td>
             <td><c:out default="None"  value="${not empty blogData.previousLink.subject ?  blogData.previousLink.subject : 'None'}"/></td>
             <td><c:out default="None"  value="${not empty blogData.headerSubject.subject ?  blogData.headerSubject.subject : 'None'}"/></td> 	
             <td><c:out default="None"  value="${not empty blogData.nextLink.subject ? blogData.nextLink.subject : 'None'}"/></td>
           </tr>
           </c:forEach>
         </tbody>
       </table> 
     </div>
    </div>