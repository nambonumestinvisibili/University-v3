<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<div>
    <p>
    'SERVER_ADDR'
    The IP address of the server under which the current script is executing.
    </p>
    'REQUEST_METHOD'
Which request method was used to access the page; e.g. 'GET', 'HEAD', 'POST', 'PUT'.
    <p>
    'REQUEST_TIME'
The timestamp of the start of the request.
    </p>
    <p>
    'QUERY_STRING'
The query string, if any, via which the page was accessed.
    </p>
    <p>
    'HTTPS'
Set to a non-empty value if the script was queried through the HTTPS protocol.
    </p>
    </div>
    <?php
    var_dump($_SERVER);

    




    phpinfo();
    ?>

</body>
</html>