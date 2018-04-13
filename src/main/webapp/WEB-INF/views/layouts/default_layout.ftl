<#setting url_escaping_charset='ISO-8859-1'>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <LINK href="${context_path}/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${context_path}/script/jquery-1.4.2.min.js" type="text/javascript"></script>
    <title>ActiveWeb - <@yield to="title"/></title>
</head>
<body>

<div class="main">
    <div class="content">
    ${page_content}
    </div>
</div>

</body>

</html>