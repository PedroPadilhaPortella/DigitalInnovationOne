import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args)
    {
        //Queue, ou LinkedList, onde o primeiro que entra é o primeiro que sai, como em pilhas.
        //Não permite a alteração de elementos, apenas adição e remoção.

        Queue<String> filaDoBanco = new LinkedList<>();
        
        filaDoBanco.add("Patrícia");
        filaDoBanco.add("Roberto");
        filaDoBanco.add("Flávio");
        filaDoBanco.add("Pamela");
        filaDoBanco.add("Anderson");
        
        System.out.println(filaDoBanco);
        
        // retorna o primeiro da Lista e remove ele
        String clienteASerAtendido = filaDoBanco.poll(); 
        System.out.println(clienteASerAtendido);

        // retorna o primeiro da Lista mas não remove ele, se a lista estiver vazia, retorna null
        clienteASerAtendido = filaDoBanco.peek(); 
        System.out.println(clienteASerAtendido);
        
        // retorna o primeiro da Lista mas não remove ele, se a lista estiver vazia, retorna uma excessão
        try {
            Queue<String> listaVazia = new LinkedList<>();
            clienteASerAtendido = listaVazia.element();
            System.out.println(clienteASerAtendido);
        }
        catch(Exception e) {
            System.err.println("Erro, a lista está vazia!");
        }

        System.out.println(filaDoBanco);

        //Outros metodos comuns

        for (String cliente : filaDoBanco) {
            System.out.println("# " + cliente);
        }

        Iterator<String> iterator = filaDoBanco.iterator();

        while(iterator.hasNext()) {
            System.out.println("--> " + iterator.next());
        }

        System.out.println(filaDoBanco.size());
        System.out.println(filaDoBanco.isEmpty());

        filaDoBanco.clear();

        //Exercicio

        Queue<String> alunos = new LinkedList<>();
        alunos.add("Juliana");
        alunos.add("Pedro");
        alunos.add("Carlos");
        alunos.add("Larissa");
        alunos.add("João");

        System.out.println("\n\nExercicio:\n");

        for (String aluno : alunos) {
            System.out.println("Aluno: " + aluno);
        }

        System.out.println(alunos.peek());
        System.out.println(alunos.poll());

        alunos.add("Daniel");

        System.out.println(alunos.size());
        System.out.println(alunos.isEmpty());
        System.out.println(alunos.contains("Carlos"));
    } 
}
