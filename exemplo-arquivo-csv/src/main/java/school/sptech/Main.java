package school.sptech;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cachorro> lista = new ArrayList<>();

        lista.add(new Cachorro(1, "Zeus", "Grande", 55.0));
        lista.add(new Cachorro(2, "Zeus2", "Pequeno", 7.0));
        lista.add(new Cachorro(3, "Zeus3", "Médio", 17.0));
        lista.add(new Cachorro(4, "Zeus4", "Grande", 43.0));
        lista.add(new Cachorro(5, "Zeus5", "Pequeno", 9.0));
        lista.add(new Cachorro(6, "Zeus6", "Médio", 21.0));
        lista.add(new Cachorro(7, "Zeus7", "Grande", 39.0));

        for (Cachorro c : lista) {
            System.out.println(c);
        }

        System.out.println("Gravando arquivo dogs.csv...");
        gravaArquivoCsv(lista, "dogs");
        System.out.println("Arquivo gravado com sucesso!");

        System.out.println("Lendo e exibindo o arquivo dogs.csv");
        leExibeArquivoCsv("dogs");
        
    }

    public static void gravaArquivoCsv(List<Cachorro> lista, String nomeArq){
        OutputStreamWriter saida = null; // objeto saída será usado para escrita do csv
        Boolean deuRuim = false;
        nomeArq += ".csv"; // acrescenta a extensão .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            saida = new OutputStreamWriter(new FileOutputStream(nomeArq),
                    StandardCharsets.UTF_8);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1); // Status de erro
        }

        // Bloco try-catch para gravar e fechar o arquivo
        try {

            // Para gravar no arquivo, basta usar saida.write ou saida.append
            // Grava o cabecalho do arquivo
            saida.append("ID;NOME;PORTE;PESO\n");

            // Percorre a lista de dogs e grava os atributos de cada dog em uma linha do arquivo
            for (Cachorro dog : lista){
                saida.write(String.format("%d;%s;%s;%.1f\n", dog.getId(), dog.getNome(),
                        dog.getPorte(), dog.getPeso()));
            }
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            try {
                saida.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }

    // Metodo para ler o arquivo CSV
    public static void leExibeArquivoCsv(String nomeArq){

        FileReader arq = null; // Corresponde ao arquivo
        Scanner entrada = null; // Objeto usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n"); // Cria um objeto scanner para ler o arq que usa o delimitador ; ou \n
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo inexistente!");
            System.exit(1);
        }

        // Bloco try-catch para ler e fechar o arquivo
        try {
            Boolean cabecalho = true;

            // Enquanto não chegou ao final do arquivo
            while (entrada.hasNext()) {
                if (cabecalho) { // Vendo a primeira linha sendo cabecalho
                    String titulo1 = entrada.next();
                    String titulo2 = entrada.next();
                    String titulo3 = entrada.next();
                    String titulo4 = entrada.next();

                    // Printa os títulos em colunas na console
                    System.out.printf("%4s %-19s %-9s %4s\n", titulo1, titulo2, titulo3, titulo4);
                    cabecalho = false;
                }
                else {
                    Integer id = entrada.nextInt();
                    String nome = entrada.next();
                    String porte = entrada.next();
                    Double peso = entrada.nextDouble();

                    System.out.printf("%4d %-19s %-9s %4.1f\n", id, nome, porte, peso);
                }
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas!");
            erro.printStackTrace();
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo!");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            try {
                entrada.close();
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }
}