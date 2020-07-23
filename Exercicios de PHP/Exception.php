<?php

function validarUsuario(array $usuario){
    if(empty($usuario['codigo']) || empty($usuario['nome']) || empty($usuario['idade'])){
        throw new Exception('Todos os campos devem ser preenchidos obrigatoriamente!');
    }
    return true;
}

$usuario =[
    'codigo'=> 1,
    'nome'=> 'pedro',
    'idade'=> 57
];

$status = false;
try {
    $status = validarUsuario($usuario);
} catch (Exception $e) {
    echo $e->getMessage();
}finally{
    echo "<br>status da Operação:". (int)$status; //cast
    die();
}


echo "\ntestando...\n";