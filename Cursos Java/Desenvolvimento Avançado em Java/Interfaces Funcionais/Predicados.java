import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        //Predicate é uma interface funcional pois tem apenas um metodo a implementar: test() 
        
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        System.out.println(estaVazio.test("vazio"));
        System.out.println(estaVazio.test(""));
    }
}
