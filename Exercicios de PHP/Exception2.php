<?php

function divisao(int $valor1, int $valor2){
    if($valor1 == 0 || $valor2 == 0){
        throw new Exception('Nenhum dos valores podem ser iguais a zero!');
    }
    $div = $valor1 / $valor2;
    return $div;
}

$a = $_GET['a'];
$b = $_GET['b'];

try {
    $resultado = divisao($a, $b);
} catch (Exception $e) {
    echo $e->getMessage();
    die();
}
echo "Divisão entre $a e $b é igual a $resultado";
?>