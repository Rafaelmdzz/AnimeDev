import br.com.rafael.animedev.Conexaoapi.TitleOmdb;
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
        System.out.print("Qual o id do anime: ");
        int leitura = leituraBusca.nextInt();

        String busca = "https://api.tenrai.org/v1/anime/" + leitura;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String itemPego = response.body();
        //System.out.println(itemPego);

        Gson gson = new Gson();
        TitleOmdb.DataWrapper testeAnime = gson.fromJson(itemPego, TitleOmdb.DataWrapper.class);
        System.out.println("separando");
        System.out.println(testeAnime);
    }
}
