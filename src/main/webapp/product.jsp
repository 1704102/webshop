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
				<div id="price"></div>
				<div id="description"></div>
				<div id="picture"></div>
				<div id="buy"></div>

			</div>
		</div>
	</div>
	</body>
	<script> $.get("rest/product/id/" + sessionStorage.getItem("product"), function (data) {
        $("#topbar2").append(data.name);
        $("#price").append("$" + data.price);
        $("#description").append(data.description);
        $("#picture").append("<img src='" + data.picture + "' id= 'wr40'/>");
    })</script>

</html>