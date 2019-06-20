<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
   <div class="container-fluid margin-top-6">
    
    <c:forEach var="headerFirstSubject" items="${headerFirstSubject }">
        <a href="<spring:url value="/boklu/${headerFirstSubject.headerCategory.category }/${headerFirstSubject.subject}"/>" type="button" 
        class="btn btn-primary btn-lg active"><c:out value="${headerFirstSubject.headerCategory.category }"></c:out></a>
     </c:forEach>
   </div>
 </body>
</html>
