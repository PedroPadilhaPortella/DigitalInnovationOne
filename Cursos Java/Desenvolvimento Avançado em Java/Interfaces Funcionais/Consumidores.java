import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        //Consumer é uma interface funcional pois tem apenas um metodo a implementar: accept() 
        //utiliza o parametro da forma que ele foi recebido

        Consumer<String> printFrase = System.out::println;
        Consumer<String> printFrase2 = frase -> System.out.println(frase);

        printFrase.accept("Teste Frase");
        printFrase2.accept("Teste Frase");
    }
}
