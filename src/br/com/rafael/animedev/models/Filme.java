package br.com.rafael.animedev.models;

public class Filme extends Titles{

    public Filme( String titleEnglish, String titleJapanese, String status, String image, int dataInicio, int dataFim, String duration, String synopsis, String studio, String youtubeTrailher, int views, int likes) {
        super( titleEnglish, titleJapanese, status, image, dataInicio, dataFim, duration, synopsis, studio, youtubeTrailher, views, likes);
    }
}
