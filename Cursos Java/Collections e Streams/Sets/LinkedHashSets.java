package Sets;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {

        //LinkedHashSet
        //usao quando é necessário manter a ordem, de acordo com a inserção dos elementos
        //é mais lenta por ter que manter a ordenação.
        LinkedHashSet<Integer> sequencia = new LinkedHashSet<>();

        sequencia.add(1);
        sequencia.add(15);
        sequencia.add(13);
        sequencia.add(9);
        sequencia.add(12);
        sequencia.add(2);

        System.out.println(sequencia);

        sequencia.remove(12);

        System.out.println("Tamanho: " + sequencia.size());

        Iterator<Integer> iterator = sequencia.iterator();

        System.out.println("ITERATOR: ");
        while(iterator.hasNext()) {
            System.out.print("=> " + iterator.next() + ", ");
        }

        System.out.println("\nFOREACH");
        for (Integer valor : sequencia) {
            System.out.print("=> " + valor  + ", ");
        }

        sequencia.clear();

        System.out.println(sequencia.isEmpty());
    }
}
