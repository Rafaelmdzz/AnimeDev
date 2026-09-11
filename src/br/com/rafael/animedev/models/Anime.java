package br.com.rafael.animedev.models;

public class Anime extends  Titles{
    private int episodes;
    private int dataFim;

    public Anime(String titleEnglish, String titleJapanese, String status, String image, int dataInicio, int dataFim, String duration, String synopsis, String studio, String youtubeTrailher, int views, int likes, int episodes) {
        super(titleEnglish, titleJapanese, status, image, dataInicio, dataFim, duration, synopsis, studio, youtubeTrailher, views, likes);
        this.episodes = episodes;
    }


}
