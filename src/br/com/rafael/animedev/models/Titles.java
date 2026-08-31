package br.com.rafael.animedev.models;

public class Titles {
    private String title;
    private String titleEnglish;
    private String titleJapanese;
    private String status;
    private String image;
    private int dataInicio;
    private int dataFim;
    private String duration;
    private String synopsis;
    private String studio;
    private String youtubeTrailher;
    private int views;
    private int likes;

    public Titles(String title, String titleEnglish, String titleJapanese, String status, String image, int dataInicio, int dataFim, String duration, String synopsis, String studio, String youtubeTrailher, int views, int likes) {
        this.title = title;
        this.titleEnglish = titleEnglish;
        this.titleJapanese = titleJapanese;
        this.status = status;
        this.image = image;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duration = duration;
        this.synopsis = synopsis;
        this.studio = studio;
        this.youtubeTrailher = youtubeTrailher;
        this.views = views;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public String getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getStudio() {
        return studio;
    }

    public String getYoutubeTrailher() {
        return youtubeTrailher;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "Título: " + this.getTitle() + " Título em ingles: " + getTitleEnglish() + "Titulo em Jápones: " + getTitleJapanese() + "Status da obra: " + getStatus() + "lançamento: " + getDataInicio() + "tempo de diração: " + getDuration();
    }
}
