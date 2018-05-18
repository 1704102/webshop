<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
		<script src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<script>
        function loadcart() {
            var total1 = 0;
            var shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"));
            if (shoppingcart != []){
                $("#tabstyle").empty();
                $("#tabstyle").append(
                    "<tr> " +
                    "<th id = 'wr60'>productnaam</td> " +
                    "<th id = 'wr10'>productprijs</td> " +
                    "<th id = 'wr10'>aantal</td> " +
                    "<th id = 'wr10'>groepsprijs</td> " +
                    "<th id = 'wr10'>delete</td> " +
                    "</tr>"
				);
                for(var i in shoppingcart){
                    var price =parseFloat(shoppingcart[i].price.substr(1)) ;
                    var aantal = parseInt(shoppingcart[i].aantal);
                    var total = price * aantal;
                    total1 += total;
                    $("#tabstyle").append(
                        "<tr>" +
                        "<td>" + shoppingcart[i].name + "</td>" +
                        "<td>" + shoppingcart[i].price + "</td>" +
                        "<td>" + shoppingcart[i].aantal + "</td>" +
                        "<td> $" + total + "</td>" +
                        "<td><button type = 'button'><img id='" + shoppingcart[i].name + "'src= 'https://image.freepik.com/free-icon/trash-bin-symbol_318-10194.jpg'class = 'imgsize2' onclick='productdelete(this.id)' alt= 'delete'></button></td>" +
                        "</tr>"

                    )
                    $("#total").empty()
					$("#total").append(total1);
                }
            }else {
                $("#tabstyle").empty();
			}
            $("#total").empty();
            $("#total").append(total1);
        }
        function redirect(catagory) {
            if(catagory != "winkelwagen" && catagory != "add_order"){sessionStorage.setItem("catagory", catagory);
                window.location.replace('http://localhost:3030/webshop.jsp')}if (catagory == "add_product") {
                window.location.replace('http://localhost:3030/Addproduct.jsp')
            }if (catagory == "winkelwagen") {window.location.replace('http://localhost:3030/winkelwagen.jsp')}if(catagory == "welkom"){
                window.location.replace('http://localhost:3030/welkomspagina.jsp')
            }
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
	<div id = "topbar"><div id= "topbar2">winkelwagen</div></div>
		<div id = "mainBody">
			<div id = "postbody">
				<table id = "tabstyle">

				</table>
				confirm<input type="checkbox" name="" id="check">
				<button type = "button" onclick="submitOrder()" >submit</button>
			</div>
		</div>
	</div>
	<script>
       loadcart()
	</script>
	<script>
		function productdelete(data) {
		    console.log(data);
            var shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"));
            for(var i in shoppingcart){
                if(shoppingcart[i].name == data){
                    shoppingcart.splice(i,1);
                    break;
				}
			}
			console.log(shoppingcart);
			sessionStorage.setItem("shoppingcart", JSON.stringify(shoppingcart));
			loadcart()
        }

        function submitOrder() {
            if ($('#check').is(":checked")) {
                var shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"));
                var user = sessionStorage.getItem("user")
                $.ajax({
                    type: "POST",
                    url: "rest/product/addOrder/" + user + "/" + JSON.stringify(shoppingcart),
                    succes: alert("order is toegevoegd")
                });
                sessionStorage.setItem("shoppingcart", "[]");
                loadcart();
            }
        }

	</script>
</body>
</html>