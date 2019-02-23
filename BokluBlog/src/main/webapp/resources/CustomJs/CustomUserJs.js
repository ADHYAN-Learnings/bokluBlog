$(document).ready(function(){
	
	
	
	/* .toggle-password class is used to find the place for password visible.  */
	$(".toggle-password").click(function(){
		var currentObject = $(this);
		 var booleanConditionOfVisiblePassword = $(currentObject).children().hasClass("fa-eye");
		  if(booleanConditionOfVisiblePassword ==true){
			  $(currentObject).children().removeClass("fa-eye").addClass("fa-eye-slash");
			  $(currentObject).siblings().removeAttr("type").attr("type","text");
		  } else {
			  $(currentObject).children().removeClass("fa-eye-slash").addClass("fa-eye");
			  $(currentObject).siblings().removeAttr("type").attr("type","password");
		  }
		
	});
	
});