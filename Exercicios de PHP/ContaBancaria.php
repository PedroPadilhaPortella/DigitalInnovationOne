<?php
declare(strict_types = 1); //checagem de tipos

class ContaBancaria
{
    /**
     * @ var string
    */
    private $produto;
    /**
     * @ var string
    */
    private $data;
    /**
     * @ var string
    */
    private $valorTotal;
    /**
     * @ var float
    */
    private $quantidade;

    public function __construct(
        string $produto,
        string $nomeCliente,
        string $numeroConta,
        string $numeroAgencia,
        float $saldo)
        {
        $this->produto = $produto;
        $this->nomeCliente = $nomeCliente;
        $this->numeroConta = $numeroConta;
        $this->numeroAgencia = $numeroAgencia;
        $this->saldo = $saldo;
    }

    public function depositar($deposito): string{
        $this->saldo += $deposito;
        return "deposito de $deposito reais";
    }

    public function sacar($saque): string{
        $this->saldo -= $saque;
        return "saque de $saque reais";
    }

    public function render(): string{
        $this->saldo *= 1.03;
        return "rendimento anual para {$this->saldo}";
    }

//getters e setters
    public function getProduto(){
        return $this->produto;
    }
    public function setProduto($produto){
        $this->produto = $produto;
    }

    public function getNomeCliente(){
        return $this->nomeCliente;
    }
    public function setNomeCliente($nomeCliente){
        $this->nomeCliente = $nomeCliente;
    }

    public function getNumeroConta(){
        return $this->numeroConta;
    }
    public function setNumeroConta($numeroConta){
        $this->numeroConta = $numeroConta;
    }

    public function getNumeroAgencia(){
        return $this->numeroAgencia;
    }
    public function setNumeroAgencia($numeroAgencia){
        $this->numeroAgencia = $numeroAgencia;
    }

    public function getSaldo(){
        return $this->saldo;
    }
    public function setSaldo($saldo){
        $this->saldo = $saldo;
    }

}

$conta = new ContaBancaria('Nubank', 'Pedro H Portella', '0087531', '00001', 600);
$conta->render();
$conta->sacar(40);
print_r($conta);

?>