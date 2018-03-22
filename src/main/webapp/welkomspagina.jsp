<!DOCTYPE html>
<html>
<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
	<script rel="script" src="script/jquery-3.2.1.min.js"></script>
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
    function openProduct(id) {
        sessionStorage.setItem("product", id);
        window.location.replace('http://localhost:3030/product.jsp')
    }
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
<div id = "topbar"><div id= "topbar2">Productnaam</div></div>
<div id = "mainBody">
	<div id = "postbody">
		welkom op de webshop pagina

		<H1>Onze aanbiedingen</h1>
		<table id = "tabstyle">
			<script> $.get("rest/product/aanbieding", function (data) {
                $("#tabstyle").append("" +
                    "<tr>" +
                    "<th id= 'wr40'>" + 'naam' + "</th>" +
                    "<th id= 'wr40'>" + 'prijs' + "</th>" +
                    "<th id= 'wr20'>" + 'plaatje' + "</th>" +
                    "</tr>");
                for(dat in data){
                    product = data[dat];
                    $("#tabstyle").append("" +
                        "<tr name = + + >" +
                        "<td onclick=openProduct("+ product.id +"); class='clickable' id='" + product.id + "'>" + product.name + "</td>" +
                        "<td>" + product.price + "</td>" +
                        "<td> <img src='images/" + product.picture + "' alt='Img not loaded' id='imgsize'/></td>" +
                        "</tr>")
                }})</script>
		</table>

	</div>
</div>
</div>
</body>

</html>