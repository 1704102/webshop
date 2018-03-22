<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
		<script src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<div id = "sidebar">
	Hyperlinks komen hier
	</div>
	<div id = "topbar"><div id= "topbar2">Productnaam</div></div>
		<div id = "mainBody">
			<div id = "postbody">
			<p><h3>Product toevoegen</h3>
			naam van product<br>
			<input type='text' id ='name'></input>
				
			<br>Prijs van product<br>
			<input type ='text' id='price'></input>
			<br>Image link<br>
			<input type='text' id ='image'></input>
			<br>Omschrijving van het product<br>
			<textarea rows='3' cols='20' id = description></textarea><br>
				<br>Catagorie van het product<br>
				<textarea rows='2' cols='20' id = catagory></textarea><br>
			<button type= 'button' id = 'submit' value="submit" onclick="submit()"/>

			
			<br>
			</p>
			</div>
			
		</div>
	</div>
	<script>
		function submit() {
            var product = {"name" : $("#name").val(), "price" : $("#price").val(),"image" : $("#image").val(), "catagory" : $("#catagory").val(), "description" : $("#description").val()};
            $.ajax({
                type: "POST",
                url: "rest/product/add/" + JSON.stringify(product),
            });
        }
	</script>
	</body>

</html>