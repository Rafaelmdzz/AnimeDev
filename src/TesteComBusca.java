import br.com.rafael.animedev.Conexaoapi.ConexaoApi;
import br.com.rafael.animedev.Conexaoapi.TitleOmdb;
import br.com.rafael.animedev.models.Titles;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TesteComBusca {
    static void main(String[] args) throws IOException, InterruptedException {
        Scanner leituraBusca = new Scanner(System.in);
        Gson gson = new Gson();
        ConexaoApi conexao = new ConexaoApi();

        System.out.println("""
                Bem vindo a central de animes, vai pesquisar o anime por qual metodo?
                1- Nome
                2- ID
                """);

        int escolhaPesquisa = leituraBusca.nextInt();
        leituraBusca.nextLine();

        if (escolhaPesquisa == 1){
            System.out.print("Qual o nome do anime: ");
            String leitura = leituraBusca.nextLine();
            conexao.fazerPesquisa(leitura, escolhaPesquisa);
        } else if (escolhaPesquisa == 2) {
            System.out.print("Qual o id do anime: ");
            String leitura = leituraBusca.nextLine();
            conexao.fazerPesquisa(leitura, escolhaPesquisa);
        }else {
            System.out.println("opçã invalida, tente reverificar o menu e testar novamente");
        }
    }
}
