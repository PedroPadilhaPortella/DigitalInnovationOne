using System;
using System.Linq;
using dotnet_poo.Classes;
using dotnet_poo.Enums;

namespace dotnet_poo
{
    class Program
    {
        public static SerieRepository repository = new SerieRepository();

        static void Main(string[] args)
        {
            string opcao = ObterOpcaoUsuario();

            while (opcao.ToUpper() != "X")
            {
                switch (opcao)
                {
                    case "1":
                        ListarSeries();
                        break;
                    case "2":
                        AdicionarSerie();
                        break;
                    case "3":
                        AtualizarSerie();
                        break;
                    case "4":
                        RemoverSerie();
                        break;
                    case "5":
                        VisualizarSerie();
                        break;
                    case "C":
                        Console.Clear();
                        break;
                    default:
                        throw new ArgumentOutOfRangeException();
                }
                opcao = ObterOpcaoUsuario();
            }
        System.Console.WriteLine("Obrigado por usar nossos Serviços, Adeus...");
        }



        private static string ObterOpcaoUsuario()
        {
            System.Console.WriteLine("\nDIO Séries:\nInforme a opção desejada: ");
            System.Console.WriteLine("1- Listar Séries");
            System.Console.WriteLine("2- Inserir nova Série");
            System.Console.WriteLine("3- Atualizar Série");
            System.Console.WriteLine("4- Remover Série");
            System.Console.WriteLine("5- Visualizar Série");
            System.Console.WriteLine("C- Limpar Tela");
            System.Console.WriteLine("X- Sair");

            string opcao = Console.ReadLine().ToUpper();
            Console.WriteLine();
            return opcao;
        }


        private static void ListarSeries()
        {
            var series = repository.GetAll().Where(serie => serie.IsRemoved() == false).ToList();
            if (series.Count == 0) {
                System.Console.WriteLine("Nenhuma serie cadastrada.");
                return;
            }
            foreach (var serie in series) {
                System.Console.WriteLine($"#ID {serie.GetId()} - {serie.GetTitulo()}");
            }
        }

        private static void AdicionarSerie()
        {
            System.Console.WriteLine("Inserir nova Série");
            foreach (int i in Enum.GetValues(typeof(Genero))) {
                System.Console.WriteLine($"{i} - {Enum.GetName(typeof(Genero), i)}");
            }
            System.Console.Write("Digite o Genero da serie: ");
            int genero = int.Parse(Console.ReadLine());
            System.Console.Write("Digite o Titulo da serie: ");
            string titulo = Console.ReadLine();
            System.Console.Write("Digite o Ano de Lancamento da serie: ");
            int ano = int.Parse(Console.ReadLine());
            System.Console.Write("Digite a Descricao da serie: ");
            string descricao = Console.ReadLine();

            Serie serie = new Serie(
                id: repository.NextId(),
                genero: (Genero)genero,
                titulo: titulo,
                ano: ano,
                descricao: descricao
            );
            repository.Insert(serie);
        }


        private static void AtualizarSerie()
        {
            System.Console.Write("Digite o Id da Série: ");
            int idSerie = int.Parse(Console.ReadLine());
            foreach (int i in Enum.GetValues(typeof(Genero))) {
                Console.WriteLine($"{i} - {Enum.GetName(typeof(Genero), i)}");
            }
            System.Console.Write("Digite o Genero da serie: ");
            int genero = int.Parse(Console.ReadLine());
            System.Console.Write("Digite o Titulo da serie: ");
            string titulo = Console.ReadLine();
            System.Console.Write("Digite o Ano de Lancamento da serie: ");
            int ano = int.Parse(Console.ReadLine());
            System.Console.Write("Digite a Descricao da serie: ");
            string descricao = Console.ReadLine();

            Serie serie = new Serie(
                id: idSerie,
                genero: (Genero)genero,
                titulo: titulo,
                ano: ano,
                descricao: descricao
            );
            repository.Update(idSerie, serie);
        }


        private static void RemoverSerie()
        {
            System.Console.Write("Digite o Id da série: ");
            int idSerie = int.Parse(Console.ReadLine());
            repository.Remove(idSerie);
        }


        private static void VisualizarSerie()
        {
            System.Console.Write("Digite o Id da série: ");
            int idSerie = int.Parse(Console.ReadLine());
            var serie = repository.GetById(idSerie);
            System.Console.WriteLine(serie);
        }
    }
}