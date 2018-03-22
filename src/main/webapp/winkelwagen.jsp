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
            var shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"));
            if (shoppingcart != undefined){
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
                    $("#tabstyle").append(
                        "<tr>" +
                        "<td>" + shoppingcart[i].name + "</td>" +
                        "<td>" + shoppingcart[i].price + "</td>" +
                        "<td>" + shoppingcart[i].aantal + "</td>" +
                        "<td> $" + total + "</td>" +
                        "<td><button type = 'button'><img id='" + shoppingcart[i].name + "'src= 'https://image.freepik.com/free-icon/trash-bin-symbol_318-10194.jpg'class = 'imgsize2' onclick='productdelete(this.id)' alt= 'delete'></button></td>" +
                        "</tr>"

                    )
                }
            }
        }
	</script>
	<div id = "sidebar">
	Hyperlinks komen hier
	</div>
	<div id = "topbar"><div id= "topbar2">winkelwagen</div></div>
		<div id = "mainBody">
			<div id = "postbody">
				<table id = "tabstyle">

				</table>
				Totaalprijs : Prijs
				<p>
				Straatnaam<br>
				<input type ='text' id='Adress'></input><br>
				Huisnummer<br>
				<input type ='text' id='huisnummer'></input><br>
				Stad<br>
				<input type ='text' id='stad'></input>
				</p>
				<button type = "button">submit</button>
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
		    var shoppingcart = JSON.parse(sessionStorage.getItem("shoppingcart"));
		    var userData = {""}
            var product = {"name" : $("#name").val(), "price" : $("#price").val(),"image" : $("#image").val(), "catagory" : $("#catagory").val(), "description" : $("#description").val()};
            $.ajax({
                type: "POST",
                url: "rest/product/add/" + JSON.stringify(product),
            });
        }

	</script>
</body>
</html>