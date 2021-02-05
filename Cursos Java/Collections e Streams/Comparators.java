import java.util.*;

import entities.*;

public class Comparators {
    public static void main(String[] args) {
        
        /*
          Interface usada para ordenação de objetos complexos e classes 
        criadas pelo desenvolvedor a partir de tipos primitivos.
          Usado principalment em List<Classe>;
        */

        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Casalli", 20));
        estudantes.add(new Estudante("Bunhak", 18));
        estudantes.add(new Estudante("Vini", 19));
        estudantes.add(new Estudante("Agnes", 18));

        System.out.println("Ordem de insercao" + estudantes);

        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
        System.out.println("ordem natural pela idade: " + estudantes);

        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
        System.out.println("ordem inversa pela idade: " + estudantes);
        
        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
        System.out.println("ordem natural com Comparator: " + estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        System.out.println("ordem reversa com Comparator: " + estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        System.out.println("ordem reversa com Comparator: " + estudantes);

        Collections.sort(estudantes);
        System.out.println("ordem natural usando Collections.sort: " + estudantes);
        
        Collections.reverse(estudantes);
        System.out.println("ordem natural usando Collections.sort: " + estudantes);

        Collections.sort(estudantes, new EstudanteOrdemReversa());
        System.out.println("ordem natural usando Collections.sort e new EstudanteOrdemReversa(): " + estudantes);
    
        // Collections.sort(Set.of(1, 5, 0, 9, 12, 23), new MapComparator());
        // Collections.sort(Set.of(1, 5, 0, 9, 12, 23));
        // Collections.sort(Map.of("one", 1, "five", 5, "zero", 0, "nine", 9, "twelve", 12, "twenty tree", 23));
        // Collections.sort(Set.of(1, 5, 0, 9, 12, 23), new SetComparator());
        // Collections.sort(List.of(1, 5, 0, 9, 12, 23));
    }
}