<!DOCTYPE html>
<html>
<body>

<form action="zadanie3upload.php" method="post" enctype="multipart/form-data">
  Select image to upload:
  <input type="file" name="fileToUpload" id="fileToUpload">
  <input type="submit" value="Upload Image" name="submit">
</form>

<h2>History of uploading files</h2>

<?php

    $historyfile = fopen("/home/chacq/Programming/PHP/uploads/history.txt", "r");
    $iterations = 0;
    function tablerow ($text, $iteration){
        if ($text == "") return "";
        return "<tr> <th> " . $text . '</th> <th> <input type="submit" name="button' . $iteration . '" value= "' . $text . '" >  </th> </tr>'; 
    }

    function checkDeleteButtons(){
        for ($i = 0; $i < 4; $i++){
            $button = "button" . $i;
            $it = $_POST[$button];
            // echo $it;
            if (isset($it)){
                deleteFile($it);
                deleteHistoryLine($it);
            }
        }
    }


    ?>
    <form method="post">
    <table>
    <tr>
    <th> Filename </th>
    <th> Delte position? <th>
    </tr>

        <?php

        while (!feof($historyfile)){
            if ($iterations == 3) break;
            echo tablerow(fgets($historyfile), $iterations);
            $iterations++;
        }

        ?>
    </table>
    </form>

    <?php 
    checkDeleteButtons();
        ?>

    <?php
        function deleteFile($filename){
            $filepath = "/home/chacq/Programming/PHP/uploads/" . $filename;
            unlink($filepath);

        }

        function deleteHistoryLine($remove) {
            $file = "/home/chacq/Programming/PHP/uploads/history.txt";
            $lines = file($file, FILE_IGNORE_NEW_LINES);
            foreach($lines as $key => $line) {
                if($line === $remove) unset($lines[$key]);
            }
            $data = implode(PHP_EOL, $lines);
            file_put_contents($file, $data);
        }
    ?>

</body>
</html>