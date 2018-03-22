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
    <input id = "postbody">
        <br>username<br>
        <input type ='text' id='username'></input>
        <br>password<br>
        <input type ='text' id='password'></input>

        <input type="button" id="login" value="login"/>
    </div>
</div>
</div>
<script>
    $("#login").click(
        function () {
            $.ajax({
                type: "GET",
                dataType: "text",
                url: "rest/product/login/" + $("#username").val() + "/" + $("#password").val(),
                success: function(data){
                    if (data > 0){
                        sessionStorage.setItem("user", data);
                        window.location.replace('http://localhost:3030/webshop.jsp')
                    }
                }
            });
        }
    );
</script>
</body>


</html>