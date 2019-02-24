<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <body>
    <div class="container-fluid margin-top-6">
     
     <div class="card bg-info">
       <div class="card-header">
        <div class="row no-gutters">
         <div class="col-sm-11 col-md-11 col-lg-11 col-xs-11"><span>Add a Header Link</span></div>
         <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1">
           <span><a href="<spring:url value='/admin/addHeaderLink'/>"> <i class="fa fa-plus" aria-hidden="true"></i></a></span>
         </div>
       </div>
       </div>
     </div>
     <div class="card-body">
       <table id="table" class="display" style="width:100%">
         <thead>
         <tr>
          <th>Action </th>
          <th>Categories</th>
          <th>Path</th>
          <th>Status</th>
          <th>Sequence</th>
         </tr>
         </thead>
         
         <tbody>
         <c:forEach var="headerLinkDetails" items="${headerLinkDetails}">
           <tr>
             <td><span><a href="<spring:url value='/admin/edit/${headerLinkDetails.id }'/>"><i class="fa fa-pencil-alt" aria-hidden="true"></i></a></span></td>
             <td>${headerLinkDetails.category }</td>
             <td>${headerLinkDetails.path }</td>
             <td>${headerLinkDetails.status }</td>
             <td>${headerLinkDetails.sequence }</td>
           </tr>
           </c:forEach>
         </tbody>
       </table>
     </div>
    </div>
  </body>
</html>

