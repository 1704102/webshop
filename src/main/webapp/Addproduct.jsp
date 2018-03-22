<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
		<script src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<div id = "sidebar">
		<li><a id="*" onclick="redirect(this.id)">Webshop</a>	</li>
		<li class="subitem"><a id="eten" onclick="redirect(this.id)">Eten</a></li>
		<li class="subitem"><a id="electronica" onclick="redirect(this.id)">Electronica</a></li>
		<li class="subitem"><a id="stofzuiger" onclick="redirect(this.id)">Stofzuigers</a></li>
		<li class="subitem"><a id="schoenen" onclick="redirect(this.id)">Schoenen</a></li>
		<li class="subitem"><a id="kleren" onclick="redirect(this.id)">Kleren</a></li>
		<li><a href="winkelwagen.jsp" onclick="redirect(this.id)">Winkelwagen</a></li>
		<li><a href="Addproduct.jsp" onclick="redirect(this.id)">Product toevoegen</a></li>
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
				<input type= 'button' id = 'submit' value="submit" onclick="submit()"/></input>
			</div>

			
			<br>
			</p>
			</div>
			
		</div>
	</div>
	<script>
        function redirect(catagory) {
            sessionStorage.setItem("catagory", catagory);
            window.location.replace('http://localhost:3030/webshop.jsp')
        }
		function submit() {
            var product = {"name" : $("#name").val(), "price" : $("#price").val(),"image" : $("#image").val(), "description" : $("#description").val()};
            $.ajax({
                type: "POST",
                url: "rest/product/add/" + JSON.stringify(product),
            });
        }
	</script>
	</body>

</html>