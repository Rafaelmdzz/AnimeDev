package br.com.rafael.animedev.models;

import br.com.rafael.animedev.Conexaoapi.TitleOmdb;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titles {
    private String titleEnglish;
    private String titleJapanese;
    private String status;
    private String image;
    private String dataInicio;
    private int durationMin;
    private String durationString;
    private String synopsis;
    private List<String> studio = new ArrayList<>();
    private String trailher;
    private int likes;

    public Titles(String titleEnglish, String titleJapanese, String status, String image, String dataInicio, int dataFim, String duration, String synopsis, String studio, String trailher, int views, int likes) {
        this.titleEnglish = titleEnglish;
        this.titleJapanese = titleJapanese;
        this.status = status;
        this.image = image;
        this.dataInicio = dataInicio;
        this.durationMin = converterTempoDuracao(duration);
        this.synopsis = synopsis;
        this.trailher = trailher;
        this.likes = likes;
    }

    public Titles(String titleEnglish, String status) {
        this.titleEnglish = titleEnglish;
        this.status = status;
    }

    public Titles(TitleOmdb data) {
        this.titleEnglish = data.title_english();
        this.titleJapanese = data.title_japanese();
        this.status = data.status();
        this.dataInicio = data.aired().string();
        this.durationMin = converterTempoDuracao(data.duration());
        this.durationString = data.duration();
        this.synopsis = data.synopsis();
        data.studios().forEach(studio1 -> this.studio.add(studio1.name()));
        this.trailher = data.trailer().url();
        this.image = data.images().jpg().image_url();
        this.likes = data.favorites();
    }

    public String getTitleEnglish() {return titleEnglish;}

    public String getTitleJapanese() {return titleJapanese;}

    public String getStatus() {return status;}

    public String getImage() {return image;}

    public String getDataInicio() {return dataInicio;}

    public int getDurationMin() {return durationMin;}

    public String getDurationString() {return durationString;}

    public String getSynopsis() {return synopsis;}

    public List<String> getStudio() {return studio;}

    public String getTrailher() {return trailher;}

    public int getLikes() {return likes;}

    public void darLike(){
        likes++;
    }

    public static int converterTempoDuracao (String duracaoStr) {
        if (duracaoStr == null || duracaoStr.isEmpty() || duracaoStr.equals("Unknown")) {
            return 0;
        }

        int minutosTotais = 0;

        Matcher matcherHora = Pattern.compile("(\\d+)\\s*hr").matcher(duracaoStr);
        if (matcherHora.find()) {
            minutosTotais += Integer.parseInt(matcherHora.group(1)) * 60;
        }

        Matcher matcherMin = Pattern.compile("(\\d+)\\s*min").matcher(duracaoStr);
        if (matcherMin.find()) {
            minutosTotais += Integer.parseInt(matcherMin.group(1));
        }

        return minutosTotais;
    }

    public void exibirTitulo(){
        System.out.printf("""
                Titulo em ingles: %s
                Titulo em Japones: %s
                Status de exibição: %s
                URL da capa: %s
                Lançamento: %s
                Duração: %s
                Synopsi: %s
                Studios: %s
                ULR do trailher: %s
                Likes: %d
                
                
                
                
                """, titleEnglish, titleJapanese, status, image, dataInicio, durationMin, synopsis, studio,trailher, likes);
    }
}
