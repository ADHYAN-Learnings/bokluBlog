<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  
  <body>
    <div class="container-fluid">
      
        <div class="row mb-5">
          <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 offset-xs-2 offset-sm-2 offset-md-2 offset-lg-2">
            <h2>Comments</h2>
            <div class="card bg-light text-dark">
             <div class="card-body">
              <div class="row">
              <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
               <img src="<spring:url value='/images/user-image.png'/>" alt="Image Preview not Available" class="img-fluid img-square">
              </div>
              <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                 <c:url var="saveComment" value="/boklu/saveComment"></c:url>
                 <form:form id="saveCommentForm" action="" method="POST"  modelAttribute="postComment"> 
             
                  <div class="form-group">
                    <form:label class="control-label" path="comment">Comment:</form:label>
                 	<form:textarea path="comment" rows="5" cols="30"  class="form-control"  />
                 	<form:errors  path="comment" cssClass="error" />
                  </div>
                  
                  <div class="form-group">
                    <form:label class="control-label" path="email">Email:</form:label>
                    <form:input path="email" class="form-control"  />
                    <form:errors  path="email" cssClass="error" />
                  </div>
                  
                  <div class="form-group">
                    <form:label class="control-label" path="name">Name:</form:label>
                    <form:input path="name" class="form-control" />
                    <form:errors  path="name" cssClass="error" />
                  </div>
                  
                  <div class="row">
                   <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 offset-xs-10 offset-sm-10 offset-md-10 offset-lg-10">
                    <button class="btn btn-block" type="button" id="saveCommentButton">Post</button>
                    </div>
                  </div>
                  
                  <form:hidden path="headerSubSection" value="${blog.headerSubject.subSectionId }"/>
                </form:form>
              </div>
              </div>
             </div>
             <div id="commentSection" class="card-footer">
               <c:forEach var="displayComments" items="${displayComments }">
                 <div class="row mb-2">
                 <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                   <img src="<spring:url value='/images/user-image.png'/>" alt="Image Preview not Available" class="img-fluid img-square" style="width:70%">
                 </div>
                 <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 ">
                  <p><span><c:out value="${displayComments.name}"></c:out></span></p>
                  <p><span><c:out value="${displayComments.comment}"></c:out></span></p>
                  </div>
               </div>
            
               </c:forEach>
             </div>
            </div>    
          </div>
        </div>
      <script type="text/javascript">
        $(document).ready(function(){
        	$("#saveCommentButton").click(function(event){
        		event.preventDefault();
        		var comment = $("#comment").val().length;
        		var email = $("#email").val().length;
        		var name = $("#name").val().length;
        	
        		if(comment==0){
        			alert("Comment should not be empty");
        			return false;
        		}
        		
        		if(email==0){
        			alert("Email should not be empty");
        			return false
        		}
        		
        		if(name==0){
        			alert("Name should not be empty");
        			return false;
        		}
        		
        		var getUrl  = window.location;
        		var baseUrl = getUrl.protocol;
        		var hostUrl = getUrl.host;
        		var basePath = baseUrl+"//"+hostUrl;
        		
        		$.ajax({
        			url:basePath+"/boklu/saveComment",
        			data:$("#saveCommentForm").serialize(),
        			type:"POST",
        			success:function(data){
        				$("#commentSection").empty();
        				$.each(data,function(index,commentBean){
        					
        					$("#commentSection").append("<div class='row mb-2'>"+
        							                      "<div class='col-xs-2 col-sm-2 col-md-2 col-lg-2'>"+
        							                      "<img src='<spring:url value='/images/user-image.png'/>' alt='Image Preview not Available' class='img-fluid img-square' style='width:70%'>"+
        							                      "</div>"+
        							                      "<div class='col-xs-10 col-sm-10 col-md-10 col-lg-10'>"+
        							                      "<p><span>"+commentBean.name+"</span></p>"+
        							                      "<p><span>"+commentBean.comments+"</span></p>"+
        							                      "</div>"+
        							                      "</div>"+
        					                           "</div>");
        				});
        				$("#comment").val("");
        				$("#email").val("");
        				$("#name").val("");
        			},
        			error:function(){
        				alert("Data did not executed successfully")
        			}
        		});
        		
    
        	});
        });
      </script>
    </div>
  </body>
</html>
