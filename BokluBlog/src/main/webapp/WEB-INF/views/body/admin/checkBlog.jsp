<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
   <body>
      <div class="container-fluid margin-top-6">
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 offset-xs-2 offset-sm-2 offset-md-2 offset-lg-2 bg-light">
        <c:out value="${blog.blogData }" escapeXml="false"></c:out>
        </div>
      </div>
   </body>
 </html>

