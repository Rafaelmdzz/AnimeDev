package br.com.rafael.animedev.Conexaoapi;

import br.com.rafael.animedev.models.Titles;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class ConexaoApi {

    public ArrayList<Titles> fazerPesquisaNome (String pesquisa){
        Gson gson = new Gson();
        ArrayList<Titles> resultados = new ArrayList<>();

        String busca = "https://api.tenrai.org/v1/anime?q=" + pesquisa.replace(" ", "+");;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(busca))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String itemPego = response.body();


                TitleOmdb.DataWrapperBusca resultadoBusca = gson.fromJson(itemPego, TitleOmdb.DataWrapperBusca.class);
                for (int i = 0; i < resultadoBusca.data().size(); i++) {
                    Titles titulo = new Titles(resultadoBusca.data().get(i));
                    resultados.add(titulo);
                }

        }catch (IllegalArgumentException e) {
            System.out.println("foi encontrado um erro na URL de busca");
            System.out.println(e);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resultados;
    }
    public Titles fazerPesquisaId (String pesquisa){
        Gson gson = new Gson();
        Titles titulo = null;

        String busca = "https://api.tenrai.org/v1/anime/" + pesquisa;


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(busca))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String itemPego = response.body();


            TitleOmdb.DataWrapperId resultadoId = gson.fromJson(itemPego, TitleOmdb.DataWrapperId.class);
            titulo = new Titles(resultadoId.data());


        }catch (IllegalArgumentException e) {
            System.out.println("foi encontrado um erro na URL de busca");
            System.out.println(e);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return titulo;
    }

}
