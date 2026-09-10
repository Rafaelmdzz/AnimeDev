import br.com.rafael.animedev.models.Filme;

import java.util.Scanner;

public class testes {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("digite o nome do filme: ");
        String nome = scanner.nextLine();
        String status = null;
        try {
            Filme filme = new Filme(nome, status);
            System.out.println("titulo criado");
        } catch (NullPointerException e){
            System.out.println("erro na criação");
        }

    }
}
