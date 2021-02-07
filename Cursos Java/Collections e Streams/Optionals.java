import java.util.Optional;


public class Optionals {
    public static void main(String[] args) {
        
        Optional<String> optionalString = Optional.of("Valor presente");
        System.out.print("Valor opcional que esta presente: ");
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