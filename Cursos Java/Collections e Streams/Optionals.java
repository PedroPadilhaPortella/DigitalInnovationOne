import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;


public class Optionals {
    public static void main(String[] args) {
        
        //Optional para tipos primitivos
        System.out.print("* Valor inteiro opcional: ");
        OptionalInt.of(12).ifPresent(System.out::println);

        System.out.print("* Valor decimal opcional: ");
        OptionalDouble.of(54.8).ifPresent(System.out::println);

        System.out.print("* Valor longo opcional: ");
        OptionalLong.of(23L).ifPresent(System.out::println);


        Optional<String> optional = Optional.of("String presente");
        // Optional<String> optional = Optional.empty();
        System.out.println("A string optional esta Presente? Ou Vazia?");
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());


        //Optinal para estados possivelmente presentes,  nulos ou vazios
        Optional<String> optionalString = Optional.of("Valor presente");
        System.out.print("\nValor opcional que esta presente: ");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("não esta presente"));

        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.print("Valor opcional que não esta presente: ");
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = não esta presente"));
        
        Optional<String> optionalEmpty = Optional.empty();
        System.out.print("Valor opcional que não esta presente: ");
        optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("empty = não esta presente"));
        
        System.out.print("Valor opcional que lanca erro NullPointerException: ");
        Optional<String> optionalNullError = Optional.of(null);
        optionalNullError.ifPresentOrElse(System.out::println, () -> System.out.println("erro = não esta presente"));
    }
}