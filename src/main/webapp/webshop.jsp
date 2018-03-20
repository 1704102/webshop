<!DOCTYPE html>
<html>
	<head>
	<title>Values</title>
	<link rel="stylesheet" href="css/style.css">
	<script rel="script" src="script/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<div id = "sidebar">
	Hyperlinks komen hier
	</div>
	<div id = "topbar"><div id= "topbar2">Titel</div></div>
		<div id = "mainBody">
			<div id = "postbody">
					<select>
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="mercedes">Mercedes</option>
						<option value="audi">Audi</option>
					</select> <p>
					 <button type="button">Ok</button> 
				<table id = "tabstyle">
					        <script> $.get("rest/product", function (data) {
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
                "<td> <img src='" + product.picture + "' alt='Img not loaded' id='imgsize'/></td>" +
                "</tr>")
        }})</script>
				</table>
			</div>
		</div>
	</div>
	</body>
<script>
	function openProduct(id) {
	    sessionStorage.setItem("product", id);
        window.location.replace('http://localhost:3030/product.jsp')
    }
</script>

</html>