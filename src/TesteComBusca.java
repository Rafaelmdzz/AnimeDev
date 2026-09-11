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

        System.out.println("""
                Bem vindo a sentral de animes, vai pesquisar o anime por qual metodo?
                1- Nome
                2- ID
                """);

        int escolhaPesquisa = leituraBusca.nextInt();
        leituraBusca.nextLine();
        String busca = null;

        if (escolhaPesquisa == 1){
            System.out.print("Qual o nome do anime: ");
            String leitura = leituraBusca.nextLine();

            busca = "https://api.tenrai.org/v1/anime?q=" + leitura;
        } else if (escolhaPesquisa == 2) {
            System.out.print("Qual o id do anime: ");
            int leitura = leituraBusca.nextInt();
            busca = "https://api.tenrai.org/v1/anime/" + leitura;
        }else {
            System.out.println("opçã invalida, tente reverificar o menu e testar novamente");
        }



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String itemPego = response.body();
        //System.out.println(itemPego);

        if (escolhaPesquisa == 1) {
            // Se buscou por nome (Array), usa o DataWrapperBusca e pega o item 0
            TitleOmdb.DataWrapperBusca resultadoBusca = gson.fromJson(itemPego, TitleOmdb.DataWrapperBusca.class);
            for (int i = 0; i < resultadoBusca.data().size(); i++) {
                Titles titulo = new Titles(resultadoBusca.data().get(i));
                System.out.println(titulo);
            }

        } else if (escolhaPesquisa == 2) {
            TitleOmdb.DataWrapperId resultadoId = gson.fromJson(itemPego, TitleOmdb.DataWrapperId.class);
            Titles titulo = new Titles(resultadoId.data());
            System.out.println(titulo);
            System.out.println();
        }
    }
}
