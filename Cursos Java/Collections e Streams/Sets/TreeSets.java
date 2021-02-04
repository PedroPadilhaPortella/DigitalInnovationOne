package Sets;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {

        //TreeSet
        //Quando pode ser necessário alterar a ordem através de Comparators,
        //mantém a ordem, mas é mais lento.
        TreeSet<String> capitais = new TreeSet<>();

        capitais.add("São Paulo");
        capitais.add("Rio de Janeiro");
        capitais.add("Curitiba");
        capitais.add("Macapá");
        capitais.add("Cuiabá");
        
        System.out.println(capitais);
        
        System.out.println("First: " + capitais.first());
        
        System.out.println("Last: " + capitais.last());
        
        System.out.println("Lower: " + capitais.lower("Macapá"));
        
        System.out.println("Higher: " + capitais.higher("Macapá"));
        
        System.out.println("Exibe e remove primeiro: " + capitais.pollFirst());
        
        System.out.println("Exibe e remove ultimo: " + capitais.pollLast());

        System.out.println(capitais);

        Iterator<String> iterator = capitais.iterator();
        System.out.println("ITERATOR: ");
        while(iterator.hasNext()) {
            System.out.print("=> " + iterator.next() + ", ");
        }

        System.out.println("\nFOREACH");
        for (String capital : capitais) {
            System.out.print("=> " + capital  + ", ");
        }
    }
}
