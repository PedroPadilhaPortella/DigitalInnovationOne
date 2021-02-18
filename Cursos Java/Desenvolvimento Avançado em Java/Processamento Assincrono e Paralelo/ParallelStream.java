import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(num -> fatorial(num)); //serial
        long fim = System.currentTimeMillis();
        System.out.println("tempo de execucao em Série: " + (fim - inicio));

        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num)); //parallel
        fim = System.currentTimeMillis();
        System.out.println("tempo de execucao Paralela: " + (fim - inicio));

        List<String> nomes = Arrays.asList("PEDRO", "ANDRE", "THIAGO");
        nomes.parallelStream().forEach(System.out::println);
    }

    public static long fatorial(long num) {
        long fat = 1;

        for (long i = 2; i <= num; i++) {
            fat *= i;
        }
        return fat;
    }
}