package school.sptech;

import javax.naming.LimitExceededException;
import java.util.Scanner;

public class ExemploThrow {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("Digite a 1ª nota (de 0 a 10): ");
            Double nota1 = leitor.nextDouble();
            if (nota1 < 0.0 || nota1 > 10.0){
                throw new LimiteUltrapassadoException("Nota 1 inválida!");
            }

            System.out.println("Digite a 2ª nota (de 0 a 10): ");
            Double nota2 = leitor.nextDouble();

            if (nota2 < 0.0 || nota2 > 10.0){
                throw new LimiteUltrapassadoException("Nota 2 inválida!");
            }

            System.out.println("Média = " + ((nota1 + nota2) / 2));
        }
        catch (LimiteUltrapassadoException erro) {
            System.out.println(erro + " - " + erro.dataHora);
            erro.printStackTrace();
        }
    }
}
