import br.com.rafael.animedev.Conexaoapi.ConexaoApi;
import br.com.rafael.animedev.Conexaoapi.TitleOmdb;
import br.com.rafael.animedev.models.Titles;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteComBusca {
    static void main(String[] args) throws IOException, InterruptedException {
        Scanner leituraBusca = new Scanner(System.in);
        Gson gson = new Gson();
        ConexaoApi conexao = new ConexaoApi();

        ArrayList<Titles> listaDesejo = new ArrayList<>();

        System.out.println("Bem vindo a central de conteudos!");

        int navegacao = 1;

        while (navegacao >= 1 || navegacao <= 4) {
            System.out.println("""
                    Oque gostaria de fazer?
                    1 - Pesquisar um titulo
                    2 - inserir um titulo na lista de desejos
                    3 - ver lista de desejos
                    4- Criar um arquivo com lista
                    """);

            navegacao = leituraBusca.nextInt();

            switch (navegacao) {
                case 1:
                    System.out.println("""
                            Como gostaria de buscar pelo Titulo?
                            1- Nome
                            2- ID
                            """);

                    int escolhaPesquisa = leituraBusca.nextInt();
                    leituraBusca.nextLine();

                    if (escolhaPesquisa == 1) {
                        System.out.print("Qual o nome do anime: ");
                        String leitura = leituraBusca.nextLine();
                        ArrayList<Titles> resultado = conexao.fazerPesquisaNome(leitura);
                        resultado.forEach(titles -> titles.exibirTitulo());
                    } else if (escolhaPesquisa == 2) {
                        System.out.print("Qual o id do anime: ");
                        String leitura = leituraBusca.nextLine();
                        Titles resultado = conexao.fazerPesquisaId(leitura);
                        resultado.exibirTitulo();
                    } else {
                        System.out.println("opçã invalida, tente reverificar o menu e testar novamente");
                    }
                    break;
                case 2:
                    System.out.println("""
                            Como gostaria de buscar pelo Titulo?
                            1- Nome
                            2- ID
                            """);

                    escolhaPesquisa = leituraBusca.nextInt();
                    leituraBusca.nextLine();

                    if (escolhaPesquisa == 1) {
                        System.out.print("Qual o nome do anime: ");
                        String leitura = leituraBusca.nextLine();
                        ArrayList<Titles> resultado = conexao.fazerPesquisaNome(leitura);
                        for (int i = 0; i < resultado.size(); i++) {
                            int indice = i + 1;
                            System.out.println("      ------------" + indice + "------------\n\n");
                            resultado.get(i).exibirTitulo();
                        }

                        System.out.println("qual desses titulos gostaria de acrescentar a lista?");

                        int tituloEscolha = leituraBusca.nextInt() - 1;
                        listaDesejo.add(resultado.get(tituloEscolha));

                    } else if (escolhaPesquisa == 2) {
                        System.out.print("Qual o id do anime: ");
                        String leitura = leituraBusca.nextLine();
                        Titles resultado = conexao.fazerPesquisaId(leitura);
                        listaDesejo.add(resultado);

                    } else {
                        System.out.println("opçã invalida, tente reverificar o menu e testar novamente");
                    }
                    System.out.println("\nTitulo adicionado a fila");
                    break;
                case 3:
                    int tempoTotal = 0;
                    for (int i = 0; i < listaDesejo.size(); i++) {
                        tempoTotal += listaDesejo.get(i).getDurationMin();
                    }
                    System.out.printf("""
                            Dados da Lista:
                            Numero de titulos: %d
                            tempo total para assistir: %d minutos
                            
                            
                            
                            """, listaDesejo.size(), tempoTotal);
                    listaDesejo.forEach(titles -> titles.exibirTitulo());
                    break;
                case 4:
                    System.out.println("""
                            Quer em forma de texto ou Json
                            1- Texto
                            2- Json
                            """);
                    int escolha = leituraBusca.nextInt();

                    if (escolha == 1){
                        FileWriter escrita = new FileWriter("listaDesejo.text");
                        escrita.write(gson.toString());
                    }else {
                        FileWriter escrita = new FileWriter("listaDesejo.json");
                        escrita.write(gson.toJson(listaDesejo));
                    }

            }

//        System.out.println("""
//                Como gostaria de buscar pelo Titulo?
//                1- Nome
//                2- ID
//                """);
//
//        int escolhaPesquisa = leituraBusca.nextInt();
//        leituraBusca.nextLine();
//
//        if (escolhaPesquisa == 1){
//            System.out.print("Qual o nome do anime: ");
//            String leitura = leituraBusca.nextLine();
//            conexao.fazerPesquisaNome(leitura);
//        } else if (escolhaPesquisa == 2) {
//            System.out.print("Qual o id do anime: ");
//            String leitura = leituraBusca.nextLine();
//            conexao.fazerPesquisaId(leitura);
//        }else {
//            System.out.println("opçã invalida, tente reverificar o menu e testar novamente");
//        }
        }
    }
}
