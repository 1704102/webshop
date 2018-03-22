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
    sessionStorage.setItem("catagory", catagory);
    window.location.replace('http://localhost:3030/webshop.jsp')
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
	<li><a id="*" onclick="redirect(this.id)">Webshop</a>	</li>
	<li class="subitem"><a id="eten" onclick="redirect(this.id)">Eten</a></li>
	<li class="subitem"><a id="electronica" onclick="redirect(this.id)">Electronica</a></li>
	<li class="subitem"><a id="stofzuiger" onclick="redirect(this.id)">Stofzuigers</a></li>
	<li class="subitem"><a id="schoenen" onclick="redirect(this.id)">Schoenen</a></li>
	<li class="subitem"><a id="kleren" onclick="redirect(this.id)">Kleren</a></li>
	<li><a href="winkelwagen.jsp" onclick="redirect(this.id)">Winkelwagen</a></li>
	<li><a href="Addproduct.jsp" onclick="redirect(this.id)">Product toevoegen</a></li>
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