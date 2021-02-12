import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        
        String[] nomes = {"Joao", "Paulo", "Marcelo", "Binho", "Paulo"};
        Integer[] numeros = {1, 2, 3, 4, 5};

        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirDobroLista(numeros);


        List<String> profissoes = new ArrayList<>();
        profissoes.add("medico");
        profissoes.add("desenvolvedor");
        profissoes.add("enfermeiro");
        profissoes.add("professor");
        profissoes.add("gerente");

        profissoes.stream().filter(p -> p.contains("fe")).forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String... nomes)
    {
        String nomeBusca = "Paulo";

        // String nomesParaImprimirFor = "";
        // for (int i = 0; i < nomes.length; i++) {
        //     if(nomes[i].equals(nomeBusca)) {
        //         nomesParaImprimirFor += nomes[i];
        //     }
        // }
        // System.out.println(nomesParaImprimirFor);

        String nomesParaImprimirStream = Stream.of(nomes)
            .filter(nome -> nome.equals(nomeBusca)).collect(Collectors.joining());

        System.out.println(nomesParaImprimirStream);
    }


    public static void imprimirTodosNomes(String... nomes)
    {
        // for (String nome : nomes) {
        //     System.out.println(nome);
        // }

        Stream.of(nomes).forEach(System.out::println);
    }
    
    public static void imprimirDobroLista(Integer... numeros)
    {
        // for (Integer numero : numeros) {
        //     System.out.println(numero * 2);
        // }

        Stream.of(numeros).map(n -> n * 2).forEach(System.out::println);
    }
}
