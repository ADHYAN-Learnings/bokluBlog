<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
   <body class="bg-light">
      <div class="container-fluid margin-top-6">
        <div class="whiteBackground col-xs-8 col-sm-8 col-md-8 col-lg-8 offset-xs-2 offset-sm-2 offset-md-2 offset-lg-2">
          <c:out value="${blog.blogData }" escapeXml="false"></c:out>
         <br/><br/><br/>
         
         <c:if test="${not empty blog.previousLink.subject && blog.previousLink.status eq 'Active' }">
          <div class="float-left">
          <h3><a title="${blog.previousLink.subject }" href="/boklu/${blog.headerCategory.category}/${blog.previousLink.subject}"><i class="fa fa-backward" aria-hidden="true"></i></a></h3>
          </div>
         </c:if>
         
         <c:if test="${not empty blog.nextLink.subject && blog.nextLink.status eq 'Active' }">
          <div class="float-right">
           <h3><a title="${blog.nextLink.subject}" href="/boklu/${blog.headerCategory.category}/${blog.nextLink.subject }"><i class="fa fa-forward" aria-hidden="true"></i></a></h3></div>
         </c:if>
         
          
        </div>
      </div>
   </body>
 </html>
 
