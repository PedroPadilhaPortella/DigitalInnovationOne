
public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        //Funcoes de alta ordem são funcoes que recebem outra funcao por parametro ou que retorna outra funcao
        //A interface Calculo, é uma interface funcional pois tem apenas um metodo para implementar

        Calculo soma = (a, b) -> a + b;
        Calculo subtracao = (a, b) -> a - b;
        Calculo produto = (a, b) -> a * b;
        Calculo divisao = (a, b) -> a / b;

        System.out.println(executarOperacao(soma, 1, 3));
        System.out.println(executarOperacao(subtracao, 7, 3));
        System.out.println(executarOperacao(produto, 2, 2));
        System.out.println(executarOperacao(divisao, 12, 3));
    }

    //metodo estatico que recebe uma implementacao da interface e dois valores
    public static int executarOperacao(Calculo calculo, int a, int b) {
        return calculo.calculo(a, b);
    }
}

//interface de implementacao
interface Calculo {
    public int calculo(int a, int b);
}
