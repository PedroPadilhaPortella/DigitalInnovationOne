import java.util.function.Supplier;

public class Suplidores {
    public static void main(String[] args) {
        //Supplier é uma interface funcional pois tem apenas um metodo a implementar: get() 

        Supplier<Pessoa> suppliers = () -> new Pessoa("Daniel", 12);
        System.out.println(suppliers.get());
    }
}


class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "Pedro";
        idade = 19;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", idade: " + idade;
    }
}
