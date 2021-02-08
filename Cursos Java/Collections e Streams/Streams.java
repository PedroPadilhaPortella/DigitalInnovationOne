import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        
        List<String> estudantes = new ArrayList<>();
        estudantes.add("Pedro");
        estudantes.add("Levi");
        estudantes.add("Mikasa");
        estudantes.add("Bertholdo");
        estudantes.add("Rainer");
        estudantes.add("Eren");
        estudantes.add("Sasha");
        estudantes.add("Falco");

        System.out.println("Contagem: " + estudantes.stream().count());
        
        System.out.println("Maior (length): " + estudantes.stream().max(Comparator.comparingInt(String::length)));
        
        System.out.println("Menor (length): " + estudantes.stream().min(Comparator.comparingInt(String::length)));
        
        System.out.println("Contains 'r': " + estudantes.stream().filter((estudante) ->
            estudante.toLowerCase().contains("r")).collect(Collectors.toList()));

        System.out.println("Nome->Length: " + estudantes.stream().map(estudante -> 
            estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList())); 
            
        System.out.println("3 primeiros: " + estudantes.stream().limit(3).collect(Collectors.toList()));

        System.out.print("Retorna os elementos: ");
        estudantes.stream().peek(System.out::print).collect(Collectors.toList());

        System.out.println("Elementos em um forEach:");
        estudantes.forEach(System.out::println);

        System.out.println("Tem algum elemento com W? " + estudantes.stream().allMatch((e) -> e.contains("W")));
    
        System.out.println("Tem algum elemento com P? " + estudantes.stream().anyMatch((e) -> e.contains("P")));
        
        System.out.println("Não tem algum elemento com P? " + estudantes.stream().noneMatch((e) -> e.contains("P")));
        
        System.out.print("Primeiro elemento da coleção: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);


        //Exemplo de uma operação encadeada
        System.out.println("\nOperacao encadeada:");
        System.out.println(estudantes.stream().peek(System.out::println)
            .map(e -> e.concat(" - ").concat(String.valueOf(e.length())))
            .peek(System.out::println).filter((e) -> e.toLowerCase().contains("r"))
            // .collect(Collectors.toList()));
            // .collect(Collectors.joining(", ")));
            // .collect(Collectors.toSet()));
            .collect(Collectors.groupingBy(e -> e.substring(e.indexOf("-") + 1))));


        
        List<String> frutas = Arrays.asList("Maçã", "Laranja", "Banana", "Limão");
        System.out.println(frutas);
    }
}