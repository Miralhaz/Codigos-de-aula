import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class TesteLivraria {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Connection connection = new Connection();
        JdbcTemplate con = new JdbcTemplate(connection.getDataSource());


        con.execute("CREATE TABLE IF NOT EXISTS Livraria (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(60)," +
                "preco DECIMAL(10, 2)" +
                ");");


        System.out.println("+---------------------------+");
        System.out.println("| Livraria SPTECH           |");
        System.out.println("+---------------------------+");
        System.out.println("| 1) Cadastrar Livro        |");
        System.out.println("| 2) Exibir Livros          |");
        System.out.println("| 3) Atualizar Livro        |");
        System.out.println("| 4) Remover Livro          |");
        System.out.println("| 5) Buscar por nome        |");
        System.out.println("| 6) Sair                   |");
        System.out.println("+---------------------------+\n");

        System.out.println("Selecione uma opção: ");
        Integer opcao = leitor.nextInt();

        if (opcao.equals(1)){
            System.out.println("Digite o nome do livro: ");
            String nome = leitor.next();
            System.out.println("Digite o preço dele: ");
            Double preco = leitor.nextDouble();

            con.update("INSERT INTO Livraria (nome, preco) VALUES ('" + nome + "', " + preco + ");");
        } else if (opcao.equals(2)){
            List<Livros> listaLivros = con.query("SELECT * FROM Time;",
                    new BeanPropertyRowMapper(Livros.class));

            System.out.println("Exibindo objetos de Times");
            for (int i = 0; i < listaLivros.size(); i++) {
                System.out.println(listaLivros.get(i));
        }
    }
}
