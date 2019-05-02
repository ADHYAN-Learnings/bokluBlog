<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href='<spring:url value="/CustomCss/sideMenu.css"/>'>
<div class="sidebar-header">
 <h3>Bootstrap sidebar</h3>
</div>

<ul id="menuList" class="list-unstyled components">
  <li class="active"><a href="<spring:url value='/admin/dashboard'/>">Dashboard</a></li>
  <li id="headerLink"><a href="<spring:url value='/admin/headerLinks'/>">HeaderLinks</a></li>
  <li id="headerSubSection"><a href="<spring:url value='/admin/headerLinksSubSection'/>">Header-SubSection</a></li>
  <li id="blog"><a href="<spring:url value='/admin/blog'/>">Blog</a></li>
  <li id="fileUpload"><a href="<spring:url value='/admin/fileUpload'/>">File Upload</a></li>
  <!--  <li><a href="#">ABOUT</a></li>
   <li>
     <a href="#pageSubMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>
     <ul class="collapse list-unstyled" id="pageSubMenu">
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
     </ul>
   </li>
   <li><a href="#">Portfolio</a></li>
   <li><a href="#">Contact</a></li> -->
</ul>