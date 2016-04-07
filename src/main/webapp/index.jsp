<html>
<head>
<script src="scripts/jquery-2.1.3.js"></script>
<script>
$(document).ready(function(){
	<!--alert("Document ready");-->
	$.get("rest/user", function(data){
		var rowTemplate = $("#templates table").html();
		console.log(rowTemplate);
		for(index in data){
			var row = rowTemplate.replace("id", data[index].id)
						.replace("name", data[index].name)
						.replace("age", data[index].age);
			$("#users").append(row);			
		}
	});
	
})


</script>
</head>

<body>
<div id="templates" style="display: none;">
	<table>
		<tr><td>id</td><td>name</td><td>age</td></tr>
	</table>
</div>
<table id="users">
<tr><td>ID</td><td>Name</td><td>Age</td></tr>
</table>
</body>
</html>
