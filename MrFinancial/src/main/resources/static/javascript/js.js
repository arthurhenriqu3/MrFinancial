/**
 * 
 */
function loadCategories(value) {
	
	var uri = "http://localhost:8080/category/api/findAllBy"+value;
	
	jQuery.ajax({
		url: uri,
		method: "POST",
		dateType: "JSON",
		success: function(data, status, xhr){
			if(status != "success"){
				return "[]";
			}
			
			let element = "<option value=\"null\" selected>----- Selecione -----</option>";
			
			for(let dt of data){
				element += "<option value=\""+dt.id+"\">"+dt.name+"</option>";
			}
			
			jQuery("#categoryParent").html(element);
		},
		error: function(){
			alert("Erro ao carregar categorias.")
		},
		complete: function(){
		}
	});
}