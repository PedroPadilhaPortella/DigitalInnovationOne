import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lists {
    public static void main(String[] args) {

        // Declaração de um ArrayList
        List<String> nomes = new ArrayList<>();

        //Adicionar elementos
        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("João");
        nomes.add("Gabriel");
        nomes.add("Vinicius");

        nomes.set(2, "Larissa"); //Atualizando pela posição

        nomes.remove(4); //remove Gabriel pelo index
        nomes.remove("Carlos"); //remove Carlos

        Collections.sort(nomes);

        System.out.println(nomes);

        String nome = nomes.get(2); //Pega um valor da Lista, no caso, Pedro
        // String nome = nomes.get(6); Gera erro, pois não tem elemento na posição 6
        // String nome = nomes.get(-1); Retorna o último elemento
        System.out.println(nome);

        System.out.println(nomes.size()); //Tamanho do ArrayList

        System.out.println("Contém Pedro? "+nomes.contains("Pedro")+" Contém Carlos? "+nomes.contains("Carlos"));
        System.out.println("Posição de Vinicius: " + nomes.indexOf("Vinicius"));
        System.out.println("Posição de Edwin: " + nomes.indexOf("Edwin") + " (não existe)");
        
        // for (String name : nomes) {
        //     System.out.println(name);
        // }

        Iterator<String> iterator = nomes.iterator(); //Iterators, semelhante a iteração do foreach

        while(iterator.hasNext()) {
            System.out.println("--> " + iterator.next());
        }

        nomes.clear();
        System.out.println("A Lista está vazia? " + nomes.isEmpty());
        
        //Outros metodos de ArrayLists
        // nomes.addAll(c);
        // nomes.forEach(action);
        // nomes.equals(o);
        // nomes.hashCode();
        // nomes.lastIndexOf(o);
        // nomes.removeAll(c);
        // nomes.removeIf(filter);
        // nomes.subList(fromIndex, toIndex);
        // nomes.toArray();
        // nomes.toString();
        // nomes.replaceAll(operator);
    }
}