<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
  <div class="container-fluid margin-top-6">
   <div class="card bg-info">
       <div class="card-header">
        <div class="row no-gutters">
         <div class="col-sm-11 col-md-11 col-lg-11 col-xs-11"><span>Add a Header SubSection</span></div>
         <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1">
           <span><a href="<spring:url value='/admin/addSubSection'/>"> <i class="fa fa-plus" aria-hidden="true"></i></a></span>
         </div>
       </div>
       </div>
     </div>
     <div class="card-body">
       <table id="table" class="display" style="width:100%">
         <thead>
         <tr>
          <th>Action </th>
          <th>Category</th>
          <th>Subject</th>
          <th>Status</th>
          <th>Sequence</th>
         </tr>
         </thead>
         
         <tbody>
          <c:forEach var="headerSubSectionDetails" items="${headerSubSectionData}">
           <tr>
             <td><span><a href="<spring:url value='/admin/editHeaderSubSectionData/${headerSubSectionDetails.headerCategory.id }'/>">
              <i class="fa fa-pencil-alt" aria-hidden="true"></i></a></span></td>
             <td>${headerSubSectionDetails.headerCategory.category }</td>
             <td>${headerSubSectionDetails.subject }</td>
             <td>${headerSubSectionDetails.status }</td>
             <td>${headerSubSectionDetails.sequence }</td>
           </tr>
           </c:forEach> 
         </tbody>
       </table>
     </div>
  
  </div>
 
 </body>
</html>