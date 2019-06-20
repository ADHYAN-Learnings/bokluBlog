<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <nav class=" navbar-expand-sm  fixed-top headerlength headerColor"> 

<div class="row">
 <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
 
 <nav class="navbar navbar-default">
   <!-- Brand -->
  <a class="navbar-brand whiteText"href="#">BOKLU</a> 
    
  <ul class="navbar-nav">
  <c:forEach var="headerLink" items="${headerLinkWithSequence }">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle whiteText" href="#" id="navbardrop" data-toggle="dropdown">
        <c:out value="${headerLink.category }"></c:out>
      </a>
      <div class="dropdown-menu dropdown-menu-right">
        <c:forEach var="headerLinkDependency" items="${headerSubSectionLinkData}">
         <c:if test="${headerLink.id eq headerLinkDependency.headerCategory.id }">
          <a class="dropdown-item" href="<spring:url value="/boklu/${headerLink.category}/${headerLinkDependency.subject}"/>">
           <c:out value="${headerLinkDependency.subject}"></c:out>
          </a>
         </c:if>
        </c:forEach>
      </div>
    </li>
     </c:forEach>
     
    <!--   This code is commented because for temporary reason we don't need user sign in  
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
        </li> -->
  </ul>
 
</nav> 
 </div>
</div>
</nav>   
