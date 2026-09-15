package br.com.rafael.animedev.models;

public class Filme extends Titles{
    private int views;

    public Filme( String titleEnglish, String titleJapanese, String status, String image, String dataInicio, int dataFim, String duration, String synopsis, String studio, String youtubeTrailher, int views, int likes) {
        super( titleEnglish, titleJapanese, status, image, dataInicio, dataFim, duration, synopsis, studio, youtubeTrailher, views, likes);
    }

    public Filme(String nome, String status) {
        super(nome, status);
    }
}
