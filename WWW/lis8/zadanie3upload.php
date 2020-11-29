<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="/zadanie3.php">Wróc na główną</a> 
<?php
$target_dir = "uploads/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;

// Check if file already exists
if (file_exists($target_file)) {
  echo "Sorry, file already exists.";
  $uploadOk = 0;
}




// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
  echo "Sorry, your file was not uploaded.";
// if everything is ok, try to upload file
} else {
  if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
    echo "The file ". htmlspecialchars( basename( $_FILES["fileToUpload"]["name"])). " has been uploaded.";
    
    $historyfile = fopen("/home/chacq/Programming/PHP/uploads/history.txt", "a+") or die("Failure");
    $txt = $_FILES["fileToUpload"]["name"] . "\n";
    fwrite($historyfile, $txt);
    fclose($historyfile);


} else {
    echo "Sorry, there was an error uploading your file.";
  }
}


?>
</body>
</html>