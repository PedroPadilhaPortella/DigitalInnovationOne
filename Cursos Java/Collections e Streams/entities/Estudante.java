package entities;

public class Estudante implements Comparable<Estudante>{
    
    private final String nome;
    private final Integer idade;

    public Estudante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return this.nome; }

    public Integer getIdade() { return this.idade; }

    @Override
    public String toString() { return nome + ": " + idade; }

    @Override
    public int compareTo(Estudante colega) {
        return colega.getIdade() - this.getIdade();
    }
}
