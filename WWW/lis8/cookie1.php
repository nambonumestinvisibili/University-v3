<?php
  setcookie( "sernik" , "z czekoladą", "/" );
  //expire date: 1 minute
  // setcookie( "sernik" , "z czekoladą", time()+60, "/" );
  setcookie("pizza", "hawajska", time() + 3600, "/uploads");
?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ciasteczka</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
td,th,body { font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10pt; }
</style>
</head>

<body>
<h2>About Cookies</h2>
<div>
Types of Cookies
There are two different types of cookies - session cookies and persistent cookies. <br>
 If a cookie does not contain an expiration date, it is considered a session cookie. <br>
  Session cookies are stored in memory and never written to disk. When the browser closes,<br>
   the cookie is permanently lost from this point on. If the cookie contains an expiration date,<br>
    it is considered a persistent cookie. On the date specified in the expiration, the cookie will be removed from the disk.
<br>
There are several different fields a cookie can contain, separated by semicolons. The definitions are:
<br>
expires
<br>
expires="Wdy, DD-Mon-YYYY HH:MM:SS GMT"
<br>
Determines when the cookie is to be deleted.
<br><br>

path
<br>
path=/           --------> cookie will be available within whole domain
<br>
path=/cookie1.php       -----------> cookie will be available only in cookie1.php dir and its subdirs
<br>

Determines what path to return the cookie on. In this example, the cookie will be sent when going to the root path in a domain.
</div>
<h3>Wartość ciastka</h3>

Ciasteczko: <?php echo $_COOKIE["sernik"]; ?>
<br>
<br>
Inne ciasteczko - piiza: <?php echo $_COOKIE["pizza"]; ?>
</body>
</html>
