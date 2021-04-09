using dio_bank_dotnet.Entities.Enums;

namespace dio_bank_dotnet.Entities
{
    public class Conta
    {
        private string Nome { get; set; }
        private double Saldo { get; set; }
        private double Credito { get; set; }
        private TipoConta TipoConta { get; set; }

        public Conta(string nome, double saldo, double credito, TipoConta tipoConta)
        {
            this.Nome = nome;
            this.Saldo = saldo;
            this.Credito = credito;
            this.TipoConta = tipoConta;
        }

        public bool Sacar(double valor) {
            if (this.Saldo - valor < (this.Credito * - 1)) {
                System.Console.WriteLine("Crédito Insulficiente");
                return false;
            } else {
                this.Saldo -= valor;
                System.Console.WriteLine($"Saque de R$ {valor} efetuado, Saldo atual de R$ {this.Saldo}");
                return true;
            }
        }

        public void Depositar(double valor) {
            this.Saldo += valor;
            System.Console.WriteLine($"Depósito de R$ {valor} efetuado, Saldo atual de R$ {this.Saldo}");
        }

        public void Transferir(double valor, Conta conta) {
            if (this.Sacar(valor)) {
                conta.Depositar(valor);
            }
        }

        public override string ToString()
        {
            return $"Conta {this.TipoConta} | Nome: {this.Nome} | Saldo: R$ {this.Saldo} | Crédito: R$ {this.Credito}\n";
        }
    }
}