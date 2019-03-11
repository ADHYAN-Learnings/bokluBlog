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
                 <form:form action="${saveComment}" method="POST"  modelAttribute="postComment"> 
             
                  <div class="form-group">
                    <form:label class="control-label" path="comment">Comment:</form:label>
                 	<form:textarea path="comment" rows="5" cols="30"  class="form-control" />
                 	<form:errors  path="comment" cssClass="error" />
                  </div>
                  
                  <div class="form-group">
                    <form:label class="control-label" path="email">Email:</form:label>
                    <form:input path="email" class="form-control"/>
                    <form:errors  path="email" cssClass="error" />
                  </div>
                  
                  <div class="form-group">
                    <form:label class="control-label" path="name">Name:</form:label>
                    <form:input path="name" class="form-control"/>
                    <form:errors  path="name" cssClass="error" />
                  </div>
                  
                  <div class="row">
                   <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 offset-xs-10 offset-sm-10 offset-md-10 offset-lg-10">
                    <button class="btn btn-block" type="submit">Post</button>
                    </div>
                  </div>
                  
                  <form:hidden path="headerLink"/>
                </form:form>
              </div>
              </div>
             </div>
             <div class="card-footer">
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
      
    </div>
  </body>
</html>
