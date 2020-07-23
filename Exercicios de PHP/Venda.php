<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vendas</title>
</head>
<body>
    
<pre>
<?php

class Venda
{
    private $data;
    private $produto;
    private $quantidade;
    private $valorTotal;

    public function __construct($data, $produto, $quantidade, $valorTotal){
        $this->data = $data;
        $this->produto = $produto;
        $this->quantidade = $quantidade;
        $this->valorTotal = $valorTotal;
    }

    public function exibirVenda(){
        echo "Data da Venda: {$this->getData()}<br>Produto: {$this->getProduto()}<br>Quantidade: {$this->getQuantidade()}<br>Valor Total: {$this->getValorTotal()}";
    }

//getters e setters
    public function getData(){
        return $this->data;
    }
    public function setData($data){
        $this->data = $data;
    }

    public function getProduto(){
        return $this->produto;
    }
    public function setProduto($produto){
        $this->produto = $produto;
    }

    public function getQuantidade(){
        return $this->quantidade;
    }
    public function setQuantidade($quantidade){
        $this->quantidade = $quantidade;
    }

    public function getValorTotal(){
        return $this->valorTotal;
    }
    public function setValorTotal($valorTotal){
        $this->valorTotal = $valorTotal;
    }
}

$venda = new Venda('12/07/2020', 'Curso de PHP da Hcoder', 5, 60.00);
$venda->exibirVenda();

?>
</pre>
</body>
</html>