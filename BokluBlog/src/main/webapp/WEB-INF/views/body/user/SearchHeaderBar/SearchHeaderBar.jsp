<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <nav class=" navbar-expand-sm  fixed-top headerlength headerColor"> 

<div class="row">
 <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
 
<nav class="navbar navbar-default">
  <div class="container-fluid justify-content-end">
     <sec:authorize var="isUser" access="hasRole('ROLE_USER')" />
   
    <ul class="nav navbar-nav">
     <c:forEach var="headerLink" items="${headerLinkWithSequence }">
       <li class="nav-item">
        <a class="nav-link whiteText" href="#"><c:out value="${headerLink.category }"></c:out></a>
       </li>
     </c:forEach>
      
      <li class="dropdown">
        <a class="dropdown-toggle  whiteText" data-toggle="dropdown" href="#">
         <c:if test="${!isUser}">Sign In</c:if>
         <c:if test="${isUser}"><c:out value="${username }"></c:out> </c:if> 
         <span class="caret"></span></a>
        <ul class="dropdown-menu">
        
         <c:if test="${!isUser}">
          <li><a class="dropdown-item" href="<spring:url value='/boklu/userLogin'/>">
            <button type="button" class="btn btn-primary  btn-block">Sign In</button></a></li>
            
          <li class="px-4"><div class="noLineBreak"><small>New Customer?<a href="<spring:url value='/boklu/signup'/>">Start Here</a></small></div></li> 
           </c:if>
           <c:if test="${isUser}">
            <li style="text-decoration:underline;"><a class="dropdown-item link"  href="<spring:url value='/boklu/logout'/>"><small>Sign Out</small></a></li>
           </c:if>
        </ul>
    </ul>
 
  </div>
</nav>
 </div>
</div>
</nav>  

 
