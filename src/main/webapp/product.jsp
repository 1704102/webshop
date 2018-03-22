<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
	<script src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<SCRIPT>
        function redirect(catagory) {
            sessionStorage.setItem("catagory", catagory);
            window.location.replace('http://localhost:3030/webshop.jsp')
        }
	</SCRIPT>
	<div id = "sidebar">
		<li class="subitem"><a id="*" onclick="redirect(this.id)">Webshop</a>	</li>
		<li class="subitem"><a id="eten" onclick="redirect(this.id)">Eten</a></li>
		<li class="subitem"><a id="electronica" onclick="redirect(this.id)">Electronica</a></li>
		<li class="subitem"><a id="stofzuiger" onclick="redirect(this.id)">Stofzuigers</a></li>
		<li class="subitem"><a id="schoenen" onclick="redirect(this.id)">Schoenen</a></li>
		<li class="subitem"><a id="kleren" onclick="redirect(this.id)">Kleren</a></li>
		<li><a href="winkelwagen.jsp" onclick="redirect(this.id)">Winkelwagen</a></li>
		<li><a href="Addproduct.jsp" onclick="redirect(this.id)">Product toevoegen</a></li>
	</div>
	<div id = "topbar"><div id= "topbar2"></div></div>
		<div id = "mainBody">
			<div id = "postbody">
				<div id="product_id" hidden></div>
				<div id="price"></div>
				<div id="description"></div>
				<div id="picture"></div>
				<input  type='button' value="Voeg toe" onclick="addProductToShoppingcart()" id="buy"/>
				<input  type='button' value="wijzig" onclick="red()" id="wijzig"/>
			</div>
		</div>
	</div>
	</body>
	<script> $.get("rest/product/id/" + sessionStorage.getItem("product"), function (data) {
        $("#product_id").append(data.id);
        $("#topbar2").append(data.name);
        $("#price").append("$" + data.price);
        $("#description").append(data.description);
        $("#picture").append("<img src=' images/" + data.picture + "' id= 'wr40'/>");
    })</script>

<script>
	function red() {
        window.location.replace('http://localhost:3030/alterProduct.jsp')
    }
	function addProductToShoppingcart() {
	    var shoppingcart;
	    if(sessionStorage.getItem("shoppingcart") == undefined){shoppingcart = []}else{shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"))}
	    for (var i in shoppingcart){
			if(shoppingcart[i].id == $("#product_id").text()){
                shoppingcart[i].aantal++;
                sessionStorage.setItem("shoppingcart", JSON.stringify(shoppingcart))
                console.log(JSON.parse(sessionStorage.getItem("shoppingcart")));
                return;
			}
		}
	    var product = {"id" : $("#product_id").text(), "aantal" : 1, "name" :  $("#topbar2").text(), "price" : $("#price").text()};
        shoppingcart.push(product);
        sessionStorage.setItem("shoppingcart", JSON.stringify(shoppingcart))
        console.log(JSON.parse(sessionStorage.getItem("shoppingcart")));
    }
</script>
</html>