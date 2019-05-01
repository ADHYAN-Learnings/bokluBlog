<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
 <head>
   <link rel="stylesheet" href='<spring:url value="/CustomCss/dashboard.css"/>'>
 </head>
 <body>
   <div class="container-flui margin-top-6">
	<div class="row">
	
	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	<div class="our-team-main">
	<div class="team-front">
	<a href="<spring:url value='/admin/headerLinks'/>">
	  <img src="http://placehold.it/110x110/9c27b0/fff?text=Dilip" class="img-fluid" />
	</a>
	<h3>Header Links</h3>
	</div>
	
	
	</div>
	</div>
	
	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	<div class="our-team-main">
	
	<div class="team-front">
	 <a href="<spring:url value='/admin/headerLinksSubSection'/>">
	 <img src="http://placehold.it/110x110/336699/fff?text=Dilip" class="img-fluid" />
	 </a>
	<h3>Header SubSection</h3>
	</div>
	
	
	</div>
	</div>
	
	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	<div class="our-team-main">
	
	<div class="team-front">
	 <a href="<spring:url value='/admin/blog'/>"><img src="http://placehold.it/110x110/607d8b/fff?text=Dilip" class="img-fluid" /></a>
	<h3>Blog</h3>
	</div>
	
	</div>
	</div>

	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	<div class="our-team-main">
	
	<div class="team-front">
	 <a href="<spring:url value='/admin/fileUpload'/>">
	 <img src="http://placehold.it/110x110/4caf50/fff?text=No Count" class="img-fluid" /></a>
	<h3>File upload</h3>
	</div>
	
	</div>
	</div>
	
	</div>
	</div>
 </body>
</html>
   
	