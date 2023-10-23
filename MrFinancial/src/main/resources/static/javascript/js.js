/**
 * 
 */

function loadCategories(element) {

	var uri = "http://localhost:8080" + element.getAttributeNode("data-uri").value + (element.getAttributeNode("data-uri").value.substring(element.getAttributeNode("data-uri").value.length - 1) == "/" ? element.id.replace(element.value, '') : "/" + element.id.replace(element.value, ''));

	jQuery.ajax({
		url: uri,
		method: "POST",
		dateType: "JSON",
		success: function(data, status, xhr) {
			if (status != "success") {
				return "[]";
			}

			let elements = "<option value=\"null\" selected>----- Selecione -----</option>";

			for (let dt of data) {
				elements += "<option value=\"" + dt.id + "\">" + dt.name + "</option>";
			}

			jQuery("select.loadCategories").html(elements);
		},
		error: function() {
			alert("Erro ao carregar categorias.")
		},
		complete: function() {
		}
	});

}

function loadCategoriess(value) {

	var uri = "http://localhost:8080/category/api/findAllBy" + value;

	jQuery.ajax({
		url: uri,
		method: "POST",
		dateType: "JSON",
		success: function(data, status, xhr) {
			if (status != "success") {
				return "[]";
			}

			let element = "<option value=\"null\" selected>----- Selecione -----</option>";

			for (let dt of data) {
				element += "<option value=\"" + dt.id + "\">" + dt.name + "</option>";
			}

			jQuery("#categoryParent").html(element);
		},
		error: function() {
			alert("Erro ao carregar categorias.")
		},
		complete: function() {
		}
	});


}