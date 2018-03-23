<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
		<script src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<div id = "sidebar">
		<div class="subitem" id="welkom" onclick="redirect(this.id)">Welkoms pagina</div>
		<div class="subitem"id="*" onclick="redirect(this.id)">Webshop	</div>
		<div class="subitem"id="eten" onclick="redirect(this.id)">Eten</div>
		<div class="subitem" id="electronica" onclick="redirect(this.id)">Electronica</div>
		<div class="subitem" id="stofzuiger" onclick="redirect(this.id)">Stofzuigers</div>
		<div class="subitem" id="schoenen" onclick="redirect(this.id)">Schoenen</div>
		<div class="subitem" id="kleren" onclick="redirect(this.id)">Kleren</div>
		<div class="subitem" id="winkelwagen" onclick="redirect(this.id)">Winkelwagen</div>
		<div class="subitem" id="add_product" onclick="redirect(this.id)">Product toevoegen</div>
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
            if(catagory != "winkelwagen" && catagory != "add_order"){sessionStorage.setItem("catagory", catagory);
                window.location.replace('http://localhost:3030/webshop.jsp')}if (catagory == "add_product") {
                window.location.replace('http://localhost:3030/Addproduct.jsp')
            }if (catagory == "winkelwagen") {window.location.replace('http://localhost:3030/winkelwagen.jsp')}if(catagory == "welkom"){
                window.location.replace('http://localhost:3030/welkomspagina.jsp')
            }
        }
		function submit() {
            var product = {"name" : $("#name").val(), "price" : $("#price").val(),"image" : $("#image").val(), "description" : $("#description").val()};
            $.ajax({
                type: "POST",
                url: "rest/product/add/" + JSON.stringify(product),
                succes: alert("product is toegevoegd")
            });
        }
	</script>
	</body>

</html>