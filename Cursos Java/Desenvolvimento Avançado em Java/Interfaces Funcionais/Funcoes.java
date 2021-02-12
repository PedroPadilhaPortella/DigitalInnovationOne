import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        //Function é uma interface funcional pois tem apenas um metodo a implementar: apply() 
        
        Function<String, String> ReverseString = text -> new StringBuilder(text).reverse().toString().toLowerCase();
        // Function<String, Integer> ConvertToInteger = string -> Integer.valueOf(string);
        Function<String, Integer> ConvertToInteger = Integer::valueOf;

        System.out.println(ReverseString.apply("Pedro Portella"));
        System.out.println(ConvertToInteger.apply("50"));
    }
}