<?php

$data = new DateTime();
$intervalo = new DateInterval('P5DT10H50M'); //intervalo de 5 minutos
$data->sub($intervalo); //adiciona esse intervalo
print_r($data);