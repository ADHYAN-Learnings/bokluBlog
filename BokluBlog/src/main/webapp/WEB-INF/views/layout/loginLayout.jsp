<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
 <head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- BootsTrap 4.1.3 CSS Version -->      
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
   integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   
   <!-- BootsTrap 4.1.3 JS Version  -->
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
   integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
   integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   
    <!--Font awesome js  -->
   <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" 
   integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
   
   <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" 
   integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
   
    <link rel="stylesheet" href="<spring:url value='/CustomCss/Login.css'/>">
    <link rel="stylesheet" href='<spring:url value="/CustomCss/common.css"/>'>
    
    <!-- Custom JS --> 
    <script type="text/javascript" src="<spring:url value="/CustomJs/ParFw.js"/>"></script>
   
    <title>templatePractice</title>  
 </head>
  <body>
    <div class="container-fluid">
        <tiles:insertAttribute name="body"/>
    </div>
  </body>
</html>