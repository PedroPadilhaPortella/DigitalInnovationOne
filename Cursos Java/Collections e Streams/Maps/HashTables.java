package Maps;

import java.util.*;

public class HashTables {
    public static void main(String[] args) {

        //HashTable, pouco usado

        Hashtable<String, Integer> alunos = new Hashtable<>();

        alunos.put("Pedro", 25);
        alunos.put("João", 15);
        alunos.put("Gabriel", 19);
        alunos.put("Vinicius", 30);
        
        alunos.put("Vinicius", 28);
        
        System.out.println(alunos);

        alunos.remove("João");

        System.out.println(alunos.get("Pedro"));

        System.out.println(alunos.size());

        for (Entry<String, Integer> entry : alunos.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Number; " + entry.getValue());
        }

        for (String key : alunos.keySet()) {
             System.out.println(key + "(" + alunos.get(key) + ")");
        }
    }
}
