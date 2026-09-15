package br.com.rafael.animedev.Conexaoapi;

import br.com.rafael.animedev.models.Titles;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConexaoApi {

    public void fazerPesquisa (String pesquisa, int tipo){
        Gson gson = new Gson();

        String busca = null;
        if (tipo == 1){
            busca = "https://api.tenrai.org/v1/anime?q=" + pesquisa.replace(" ", "+");
        } else if(tipo == 2){
            int pesquisaId = Integer.parseInt(pesquisa);
            busca = "https://api.tenrai.org/v1/anime/" + pesquisaId;
        }else {
            System.out.println("opção invalida, verifique o menu e tente novamente");
        }

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(busca))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String itemPego = response.body();


            if (tipo == 1){
                TitleOmdb.DataWrapperBusca resultadoBusca = gson.fromJson(itemPego, TitleOmdb.DataWrapperBusca.class);
                for (int i = 0; i < resultadoBusca.data().size(); i++) {
                    Titles titulo = new Titles(resultadoBusca.data().get(i));
                    int exibição = i + 1;
                    System.out.println("           ------------" + exibição +  "------------");
                    titulo.exibirTitulo();

                }
            } else if (tipo == 2) {
                TitleOmdb.DataWrapperId resultadoId = gson.fromJson(itemPego, TitleOmdb.DataWrapperId.class);
                Titles titulo = new Titles(resultadoId.data());
                titulo.exibirTitulo();
                System.out.println();
            }

        }catch (IllegalArgumentException e) {
            System.out.println("foi encontrado um erro na URL de busca");
            System.out.println(e);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
