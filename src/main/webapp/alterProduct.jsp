<!DOCTYPE html>
<html>
<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
	<script src="script/jquery-3.2.1.min.js"></script>
</head>
<body>
<script>
    function redirect(catagory) {
        if(catagory != "winkelwagen" && catagory != "add_order"){sessionStorage.setItem("catagory", catagory);
            window.location.replace('http://localhost:3030/webshop.jsp')}if (catagory == "add_product") {
            window.location.replace('http://localhost:3030/Addproduct.jsp')
        }if (catagory == "winkelwagen") {window.location.replace('http://localhost:3030/winkelwagen.jsp')}if(catagory == "welkom"){
            window.location.replace('http://localhost:3030/welkomspagina.jsp')
        }
    }
    function loadPage() {
        $.get("rest/product/id/" + sessionStorage.getItem("product"), function (data) {
            $("#name").val(data.name);
            $("#price").val(data.price);
            $("#description").append(data.description);
            $("#image").val(data.picture);
            $("#catagory").val(data.catagory);
        })
    }
    function deleteProduct() {
        var id = sessionStorage.getItem("product");
        $.ajax({
            type: "POST",
            url: "rest/product/delete/" + id,
			succes: alert("product deleted")
        });
    }

    function alterProduct() {
        var product = {"id" : sessionStorage.getItem("product"), "name" : $("#name").val(), "price" : $("#price").val(),"image" : $("#image").val(), "catagory" : $("#catagory").val(), "description" : $("#description").val()};
        $.ajax({
            type: "POST",
            url: "rest/product/alter/" + JSON.stringify(product),
        });
    }
    loadPage()

</script>
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
<div id = "topbar"><div id= "topbar2">Wijzig/delete product</div></div>
<div id = "mainBody">
	<div id = "postbody">
		<p><h3>Huidige productnaam Naam hier</h3>
		Nieuwe naam van product<br>
		<input type='text' id ='name'></input>

		<br>Nieuwe Prijs van product<br>
		<input type ='number' id='price'></input>
		<br>Nieuwe Catagorie van product link<br>
		<input type='text' id ='catagory'></input>
		<br>Nieuwe Image link<br>
		<input type='text' id ='image'></input>
		<br>Nieuwe Omschrijving van het product<br>
		<textarea rows='3' cols='20' id = description></textarea><br>

		<button type= 'button' id = 'delete' onclick="deleteProduct()">
			Delete the item
		</button>
		<br><br>
		<button type= 'button' id = 'update' onclick="alterProduct()">
			Update the item</button>
		<br>
		</p>
	</div>

</div>
</div>
</body>

</html>