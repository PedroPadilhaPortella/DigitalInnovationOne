public class Lambdas {
    public static void main(String[] args) {

        //Sem Funcao Lambda
        Funcao addPrefix1 = new Funcao() {
            @Override
            public String gerar(String nome) {
                return "Sr. " + nome;
            }
        };
        System.out.println(addPrefix1.gerar("Pedro Portella"));
        
        //Com Funcao Lambda
        Funcao addPrefix2 = nome -> "Sr." + nome;
        System.out.println(addPrefix2.gerar("Pedro Portella"));
    }
}

@FunctionalInterface
interface Funcao {
    String gerar(String nome);
}