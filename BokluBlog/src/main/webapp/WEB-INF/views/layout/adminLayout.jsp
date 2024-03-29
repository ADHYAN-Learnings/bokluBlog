<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
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
      
   
   <!-- </script> -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
   integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   
     
   
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
   integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   
   <!--Font awesome js  -->
   <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" 
   integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
   
   <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" 
   integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
   
   <!-- JQuery plugin -->
         <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
         
         
 <%-- Keep this code for temproary test it properly and if it is working fine in mobile without this plugin delete the code. 
    <script type="text/javascript" src="<spring:url value="/CustomJs/jquery.mobile.custom.min.1.5.0.js"/>"></script>  --%>
   
  <!--  scrollbar Plugin  CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.css">
  
  <!--  scrollbar Plugin  JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.13/jquery.mousewheel.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>
  
  <!-- Datable plugin Js -->
  <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
    
  <!-- Datatable plugin Css -->
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
   
   <!--Custom CSS  -->
    <link rel="stylesheet" href='<spring:url value="/CustomCss/common.css"/>'>
  
    <!-- Custom JS -->
    <script type="text/javascript" src="<spring:url value="/CustomJs/ParFw.js"/>"></script>
    
    <script type="text/javascript">
     $(document).ready(function(){
    	 ParFw.init();
     });
    </script>
   
    <title>Boklu</title>
  </head>
  <body>
      
    <div class="container-fluid">
    
      <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
           <tiles:insertAttribute name="header"/>
         </div>
         
         <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
         
           <div id="sideMenuAndBodySection" class="wrapper">
           
             <div id="sideMenuSection" class="col-sm-3 col-md-3 col-lg-3 col-xs-3 mCustomScrollbar" data-mcs-theme="dark">
               <nav id="sidebar">
                 <tiles:insertAttribute name="sideMenu"/>
               </nav>
             </div>
             
             <div id="bodySection" class="col-sm-9 col-md-9 col-lg-9 col-xs-9"> 
               <div id="content"> 
                 <tiles:insertAttribute name="body"/>
               </div>
             </div>
             
           </div>
         
         </div>
         
         <div class="col-sm-12 col-md-12 col-lg-12 col-lg-12">
             <tiles:insertAttribute name="footer"/>
         </div>
      </div>
    </div>  
  </body>
</html>
</sec:authorize>