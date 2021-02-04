import java.util.List;
import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        
        List<String> esportes = new Vector<>();

        //Adicionar 4 esportes
        esportes.add("Futebol");
        esportes.add("Voleibol");
        esportes.add("Basquetebol");
        esportes.add("Handebol");

        esportes.set(2, "Softbol");

        esportes.remove(0);
        esportes.remove("Handebol");

        System.out.println(esportes.get(0));

        for (String esporte : esportes) {
            System.out.println("--> " + esporte);
        }
    }
}
