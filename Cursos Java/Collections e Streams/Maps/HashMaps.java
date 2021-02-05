package Maps;

import java.util.*;

public class HashMaps {
    public static void main(String[] args) {

        //HashMap, estrutura chave - valor que implementa Cloneable e Serializable
        
        Map<String, Integer> campeoesMundiais = new HashMap<String, Integer>();
        
        campeoesMundiais.put("Brasil", 4);
        campeoesMundiais.put("Alemanha", 4);
        campeoesMundiais.put("Itália", 4);
        campeoesMundiais.put("Uruguai", 2);
        campeoesMundiais.put("Argentina", 2);
        campeoesMundiais.put("Franca", 2);
        campeoesMundiais.put("Inglaterra", 1);
        campeoesMundiais.put("Espanha", 1);
        
        campeoesMundiais.put("Brasil", 5); //atualizar o valor

        System.out.println(campeoesMundiais);

        System.out.println("Vitórias da Argentina; " + campeoesMundiais.get("Argentina")); //pega o valor

        campeoesMundiais.remove("Franca"); //remove elemento

        System.out.println("Contém  a chave Franca? " + campeoesMundiais.containsKey("Franca")); //contém chave 'Franca'

        System.out.println("Contém alguma chave com valor 6?" + campeoesMundiais.containsValue(6)); //contém valor 6

        System.err.println("Tamanho: " + campeoesMundiais.size()); //tamanho

        for (Map.Entry<String, Integer> campeao : campeoesMundiais.entrySet() {
            System.out.print(campeao.getKey() + " -- " + campeao.getValue() + ", ");   
        }

        System.out.println();
        for (String key : campeoesMundiais.keySet()) {
            System.out.print(key + " -- " + campeoesMundiais.get(key) + ", ");
        }

        campeoesMundiais.clear();
    }
}
