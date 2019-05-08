 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-topindexOne ">
 <div class="container-fluid">
 <div class="col-sm-1 col-md-1 col-lg-1 col-lg-1 col-xl-1 offset-sm-11 offset-md-11 offset-lg-11 offset-xl-11">
  <div class=" dropdown-menu-right " id="navbarText">
  <button type="button" class="btn btn-primary" data-toggle="dropdown">Home
  </button>
  <div class="dropdown-menu">
    <a class="nav-link" href='<spring:url value="/admin/logout"/>'>Logout</a>
      <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
    <a class="dropdown-item" href='<spring:url value="/admin/passwordChange"/>'>Password Change</a>
  </div>
 </div>
 </div>
 </div>
</nav>

  

