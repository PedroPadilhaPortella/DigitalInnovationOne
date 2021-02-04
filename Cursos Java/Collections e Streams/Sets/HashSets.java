package Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSets {
    public static void main(String[] args) {

        //java.util.set
        //Não ordena, nem permite itens repetidos, permite adição e remoção,
        //Não possui formas de busca por item nem ordenação.

        //HashSet, LinkedHashSet e TreeSet

        //HashSet
        //Usado quando não é necessário manter a ordem, ele não permite valores repetidos, é o mais performático
        //Semelhante ao set() do python;
        Set<Double> notas = new HashSet<>();

        notas.add(5.8);
        notas.add(9.4);
        notas.add(2.3);
        notas.add(6.6);
        notas.add(9.6);
        notas.add(10.0);
        notas.add(7.8);
        notas.add(6.4);
        notas.add(5.8);

        System.out.println(notas);

        notas.remove(6.6);

        System.out.println(notas);

        System.out.println("Tamanho: " + notas.size());

        Iterator<Double> iterator = notas.iterator();

        System.out.println("ITERATOR: ");
        while(iterator.hasNext()) {
            System.out.print("=> " + iterator.next() + ", ");
        }

        System.out.println("\nFOREACH");
        for (Double nota : notas) {
            System.out.print("=> " + nota  + ", ");
        }

        notas.clear();

        System.out.println(notas.isEmpty());
    }
}