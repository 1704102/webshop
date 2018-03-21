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
	<div id = "topbar"><div id= "topbar2"></div></div>
		<div id = "mainBody">
			<div id = "postbody">
				<div id="product_id" hidden></div>
				<div id="price"></div>
				<div id="description"></div>
				<div id="picture"></div>
				<input  type='button' value="Voeg toe" onclick="addProductToShoppingcart()" id="buy"/>

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