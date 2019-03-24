
var ParFw = function() {
	
	var getUrl  = window.location;
	var baseUrl = getUrl.protocol;
	var hostUrl = getUrl.host;
	var basePath = baseUrl+"//"+hostUrl;
	
	var currentObject = $(this);
	
	var tablePlugin = function() {
		$("#table").DataTable();
	}
	
	var selectMenuHiddenProperty = function() {
		$(".ui-selectmenu-button-text").css("display","none");
	}
	
	var selectMenuAdditionalClassHidden = function () {
		selectMenuHiddenProperty();
		
		$("select").change(function(){
			selectMenuHiddenProperty();
		});
		
		
		$(window).resize(function(){
			selectMenuHiddenProperty();
		});

	}
	
	
	  var dependentListOfValue = function (){
		  $(".ajaxlistload").change(function(){
			
			  var superElement = $(document);
			  var closestElement = $(this).data("targetobject");
			  var targetElements = $(this).data("targetelements")
			  var targetElementsArray = targetElements.split(",");
			  
			  if($(this).val()===undefined || $(this).val()==null || $(this).val()==''){
				  $.each(targetElementsArray,function(index){
					  var targetValue = superElement.find(closestElement).find("data-listName='"+targetElementsArray[index]+"'");
					  
					  if(targetValue.is("select")){
						  targetValue.empty();
						  targetValue.append($("<option value=''> </option>"));
					  } else {
						  targetValue.val("");
					  }
					  targetValue.change();
				  });
				  return;
			  }
			  
			  var targetUrl = basePath +"/list-load";
			  var requiredData = "sender="+$(this).data("sender")+"&"+$(this).data("listname")+"="+$(this).val();
			  var inputParameters = $(this).data("inputparameters");
			  
			  if(inputParameters!=null && inputParameters!== undefined){
 				  var inputParameterInArray = inputParameters.split(",");
 				  $.each(inputParameterInArray , function(index){
 					 requiredData=requiredData+"&"+inputParameterInArray[index]+"="+superElement.find(closestElement).find("[data-listname='"+inputParameterInArray[index]+"']").val();
 				  });
 			  }
			  
			  $.each(targetElementsArray,function(index){
				 var targetValue = superElement.find(closestElement).find("[data-listName='"+targetElementsArray[index]+"']");
				 if(targetValue.is("select")){
					 targetValue.empty();
					 targetValue.append($("<option value=''>Loading.. Please Wait</option>"))
				 } else {
					 targetValue.val("Loading.. Please Wait");
				 }
			  });
			  requiredData = requiredData+"&"+($(this).data("externalurl")!=null?$(this).data("externalurl"):"");
			  
			  $.ajax({
				  url:targetUrl+"?"+requiredData,
				  type:"POST",
				  success:function(json){
					  if(json != null && json["error"] ==null || json["error"] === undefined ){
						 $.each(targetElementsArray,function(index){
							var list = json[targetElementsArray[index]];
							var targetValue = superElement.find(closestElement).find("[data-listName='"+targetElementsArray[index]+"']");
							if(list!=null && list != undefined){
								if(!(typeof list === 'string') ) {
									targetValue.empty();
									 if($.isEmptyObject(list)){
										 targetValue.append($("<option value=''></option>"));
									 } else {
										 $.each(list, function(index, value){
                  						   if(value != undefined) {
                  							 targetValue.append($("<option></option>").attr("value", index.replace("#", "")).text(value));
                  						   }
                  					   });
									 }
								} else {
									targetValue.val(list);
								}
							}
							targetValue.change();
						 });
					  } else {
						  alert("Sorry Unable to process the request");
					  }
				  },
				  error:function(xhr){
					  alert("Sorry Unable to process the request");
				  }
			  });
		
		});
	}
	   		
   return  {
	   init : function() {
		   tablePlugin();
		   selectMenuAdditionalClassHidden();
		   dependentListOfValue();
	   }
   }		
}();