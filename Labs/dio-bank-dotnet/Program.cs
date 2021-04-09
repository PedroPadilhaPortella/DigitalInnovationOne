using System;
using System.Collections.Generic;
using dio_bank_dotnet.Entities;
using dio_bank_dotnet.Entities.Enums;

namespace dio_bank_dotnet
{
    class Program
    {
        static List<Conta> contas = new List<Conta>();
        static void Main(string[] args)
        {
            string opcao = ObterOpcaoUsuario();

            while (opcao.ToUpper() != "X") {
                switch (opcao)
                {
                    case "1":
                        ListarContas();
                        break;
                    case "2":
                        CriarConta();
                        break;
                    case "3":
                        Transferir();
                        break;
                    case "4":
                        Sacar();
                        break;
                    case "5":
                        Depositar();
                        break;
                    case "C":
                        Console.Clear();
                        break;
                    default:
                        throw new ArgumentOutOfRangeException();
                }
                opcao = ObterOpcaoUsuario();
            }

            Console.WriteLine("Obrigado por utilizar nossos serviços!");
            Console.WriteLine();
        }


        private static void ListarContas()
        {
            Console.WriteLine("Lista de Contas");
            if (contas.Count == 0) {
                Console.WriteLine("Nenhuma Conta cadastrada.");
                return;
            }
            for (int i = 0; i < contas.Count; i++)
                Console.WriteLine($"#{i} {contas[i]}");   
        }


        private static void CriarConta()
        {
            Console.WriteLine("Inserir nova Conta");
            Console.Write("Digite 1 para Conta Fisica e 2 para Conta Juridica: ");
            TipoConta tipoConta = (TipoConta)int.Parse(Console.ReadLine());
            Console.Write("Digite o nome do Cliente: ");
            string nome = Console.ReadLine();
            Console.Write("Digite o saldo inicial do Cliente: ");
            double saldo = double.Parse(Console.ReadLine());
            Console.Write("Digite o crédito: ");
            double credito = double.Parse(Console.ReadLine());

            Conta conta = new Conta(nome, saldo, credito, tipoConta);
            contas.Add(conta);
        }


        private static void Transferir()
        {
            System.Console.Write("Digite o número da Conta Origem da Tranferencia: ");
            int source = int.Parse(Console.ReadLine());

            System.Console.Write("Digite o número da Conta Destino da Tranferencia: ");
            int target = int.Parse(Console.ReadLine());

            System.Console.Write("Digite o valor a ser transferido: ");
            double valor = double.Parse(Console.ReadLine());

            contas[source].Transferir(valor, contas[target]);
        }


        private static void Sacar()
        {
            System.Console.Write("Digite o número da Conta: ");
            int id = int.Parse(Console.ReadLine());
            System.Console.Write("Digite o valor a ser sacado: ");
            double valor = double.Parse(Console.ReadLine());

            contas[id].Sacar(valor);
        }


        private static void Depositar()
        {
            System.Console.Write("Digite o número da Conta: ");
            int id = int.Parse(Console.ReadLine());
            System.Console.Write("Digite o valor a ser depositado: ");
            double valor = double.Parse(Console.ReadLine());

            contas[id].Depositar(valor);
        }


        private static string ObterOpcaoUsuario()
        {
            Console.WriteLine("\nDIO Bank\nInforme a opção desejada:");
            Console.WriteLine("1- Listar Contas");
            Console.WriteLine("2- Criar nova Conta");
            Console.WriteLine("3- Transferir");
            Console.WriteLine("4- Sacar");
            Console.WriteLine("5- Depositar");
            Console.WriteLine("C- Limpar Tela");
            Console.WriteLine("X- Sair");

            string opcao = Console.ReadLine().ToUpper();
            Console.WriteLine();
            return opcao;
        }
    }
}
