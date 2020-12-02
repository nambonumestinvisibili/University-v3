<?php
$IsPostFormData = (isset($_POST["sent"]) && ($_POST["sent"]=="y"));
$IsGetFormData = (isset($_GET["sent"]) && ($_GET["sent"]=="y"));
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

    <form name="dane" action="zadanie2.php" method="get">
        <label for="#karty">NUmer karty</label>
        <br>
<input type="text" name="#karty" id="#karty" placeholder="XXXX-XXXX-XXXX-XXXX" <?php if (!empty($_GET["#karty"])): ?> value="<?php echo $_GET["#karty"]; ?>" <?php endif; ?>>
        <br>
        <br>

        <label for="dataWaznosci">Data waznosci karty</label>
        <br>
        <input type="text" name="dataWaznosci" id="dataWaznosci" placeholder="MM/YY" <?php if (!empty($_GET["dataWaznosci"])): ?> value="<?php echo $_GET["dataWaznosci"]; ?>" <?php endif; ?>>
        <br>
        <br>

        <label for="cvc">Numer CVC</label>
        <br>
        <input type="text" name="cvc" id="cvc" placeholder="XXX" <?php if (!empty($_GET["cvc"])): ?> value="<?php echo $_GET["cvc"]; ?>" <?php endif; ?>>
        <br>
        <br>

        <label for="imie">Imię</label>
        <br>
        <input type="text" id="imie" name="imie" <?php if (!empty($_GET["imie"])): ?> value="<?php echo $_GET["imie"]; ?>" <?php endif; ?>/>
        <br>
        <br>

        <label for="nazwisko">Nazwisko</label>
        <br>
        <input type="text" id="nazwisko" name="nazwisko" <?php if (!empty($_GET["nazwisko"])): ?> value="<?php echo $_GET["nazwisko"]; ?>" <?php endif; ?>/>
        <br>
        <br>

        <label for="kwota">Kwota przelewu</label>
        <br>
        <input type="number" id="kwota" name="kwota" min="0" max="50000" step="100" <?php if (!empty($_GET["kwota"])): ?> value="<?php echo $_GET["kwota"]; ?>" <?php endif; ?>/>
        <br>
        <br>

        <label for="email">Email:</label>
        <br>
        <input type="text" name="email" id="email" <?php if (!empty($_GET["email"])): ?> value="<?php echo $_GET["email"]; ?>" <?php endif; ?>>
        <br>
        <br>

        <input type="hidden" name="sent" value="y">

        <button type="submit">Wyslij</button>
    
    </form>

    <?php
        
        if ($IsGetFormData):
            $numerkarty = $_GET["#karty"];
            $dataWaznosci = $_GET['dataWaznosci'];
            $cvc = $_GET['cvc'];
            $imie = $_GET['imie'];
            $nazwisko = $_GET['nazwisko'];
            $kwota = $_GET['kwota'];
            $email = $_GET['email'];
            if (!preg_match("/^\d{4}-\d{4}-\d{4}-\d{4}$/", $numerkarty)):
                echo "numer karty jest w niepoprawnym formacie\n";
                echo $numerkarty;
            endif;

            if (!preg_match("/^(0[1-9]|1[0-2])\/([0-9]{2})$/", $dataWaznosci)):
                echo "Data ważnosći nie jest w formacie MM-YY\n";
            endif;
            if (!preg_match("/^\d{3}$/", $cvc)):
                echo "CVC nie jest w odpowiednim formacie\n";
            endif;
            if (!preg_match("/^[A-Z]{1}[a-z]{1,}$/", $imie)):
                echo "IMie nie jest w odpowiednim formac0ie\n";
            endif;
            if (!preg_match("/^[A-Z]{1}[a-z]{1,}$/", $nazwisko)):
                echo "Naziwsko nie jest w odpowiednim formac0ie\n";
            endif;
            if (!preg_match("/^\d{3}$/", $kwota)):
                echo "Kwota nie jest w odpowiednim formac0ie\n";
            endif;
            if (!preg_match("/^[^@]+@[^@]+\.[^@]+$/", $email)):
                echo "EMail nie jest w odpowiednim formac0ie\n";
            endif;
            
        endif;
    ?>
    

</body>
</html>