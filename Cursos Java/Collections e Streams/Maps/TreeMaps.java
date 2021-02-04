package Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        
        //TreeMap
        //ele mantém uma ordem segundo a arvore binária, onde a ordenação é masi importante que a performance

        TreeMap<String, String> capitais = new TreeMap<>();

        capitais.put("RS", "Porto Alegre");
        capitais.put("SP", "São Paulo");
        capitais.put("PR", "Curitiba");
        capitais.put("SC", "Florianópolis");
        capitais.put("MT", "Cuiabá");
        capitais.put("TO", "Palmas");

        System.out.println(capitais);

        System.out.println("Primeira chave: " + capitais.firstKey());
        System.out.println("Ultima chave: " + capitais.lastKey());
        System.out.println("Chave anterior a SC: " + capitais.lowerKey("SC"));
        System.out.println("Chave superior a SC: " + capitais.higherKey("SC"));

        System.out.println(capitais.firstEntry().getKey() + " - " + capitais.firstEntry().getValue());
        System.out.println(capitais.lastEntry().getKey() + " - " + capitais.lastEntry().getValue());

        System.out.println(capitais.lowerEntry("RS").getKey() + " - " + capitais.lowerEntry("RS").getValue());
        System.out.println(capitais.higherEntry("RS").getKey() + " - " + capitais.higherEntry("RS").getValue());

        Map.Entry<String, String> firstEntry = capitais.pollFirstEntry(); //retorna o primeiro e remove
        Map.Entry<String, String> lastEntry = capitais.pollLastEntry(); //retorna o ultimo e remove

        System.out.println("deletando " + firstEntry.getKey() + " - " + firstEntry.getValue());
        System.out.println("deletando " + lastEntry.getKey() + " - " + lastEntry.getValue());

        Iterator<String> iterator = capitais.keySet().iterator();

        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " -> " + capitais.get(key));
        }

        for (String capital : capitais.keySet()) {
            System.out.println(capital + " => " + capitais.get(capital));
        }

        for (Map.Entry<String, String> capital : capitais.entrySet()) {
            System.out.println(capital.getKey() + " => " + capital.getValue());
        }
    }
}
