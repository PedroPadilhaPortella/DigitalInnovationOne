package Java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaDeTipo {

    public static void main(String[] args) throws IOException {
        
        /* var
         * 1- não pode usar a nível de classe, como atributos
         * 2- não pode ser usado como parametro de metodos
         * 3- não pode ser usado em variáveis não inicializadas
         * 
         * 4- pode ser usado em funções, dependendo da situação
         * 5- pode ser usado em variaveis locais inicializadas
         * 6- pode ser usado em variáveis usadas dentro de um foreach, criada a partir de uma Lista ou Array
         * 6- pode ser usada dentro do try catch with resources
        */

        // connectAndPrintURL();
        connectAndPrintURL();
        printarNomeCompleto("João", "Santos");
        printarSoma(5, 21);
    }
    
    public static void connectAndPrintURL() throws IOException {
        try {
            var url = new URL("https://docs.oracle.com/javase/10/language/");
            var urlConnection = url.openConnection();
            
            try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", "\n"));
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void printarNomeCompleto(String nome, String sobrenome) {
        var nomeCompleto = nome + " " + sobrenome;
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        int soma;
        if(numeros.length > 0) {
            soma = 0;
            for(var numero : numeros) {
                soma += numero;
            }
            System.out.println(soma);
        }
    }
}