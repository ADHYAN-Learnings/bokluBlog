var ParFw = function() {
	
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
		
		
   return  {
	   init : function() {
		   tablePlugin();
		   selectMenuAdditionalClassHidden();
	   }
   }		
}();