package br.com.rafael.animedev.models;

import com.google.gson.annotations.SerializedName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titles {
    private String titleEnglish;
    private String titleJapanese;
    private String status;
    private String image;
    private int dataInicio;
    private int duration;
    private String synopsis;
    private String studio;
    private String trailher;
    private int likes;

    public Titles(String titleEnglish, String titleJapanese, String status, String image, int dataInicio, int dataFim, String duration, String synopsis, String studio, String trailher, int views, int likes) {
        this.titleEnglish = titleEnglish;
        this.titleJapanese = titleJapanese;
        this.status = status;
        this.image = image;
        this.dataInicio = dataInicio;
        this.duration = converterTempoDuracao(duration);
        this.synopsis = synopsis;
        this.studio = studio;
        this.trailher = trailher;
        this.likes = likes;
    }

    public Titles(String titleEnglish, String status) {
        this.titleEnglish = titleEnglish;
        this.status = status;
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

    public int getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getStudio() {
        return studio;
    }

    public String getYoutubeTrailher() {
        return trailher;
    }

    public int getLikes() {
        return likes;
    }

    public static int converterTempoDuracao (String duracaoStr) {
        if (duracaoStr == null || duracaoStr.isEmpty() || duracaoStr.equals("Unknown")) {
            return 0; // Retorna 0 caso a API não tenha a duração do anime
        }

        int minutosTotais = 0;

        // 1. Procura o número antes da palavra "hr"
        Matcher matcherHora = Pattern.compile("(\\d+)\\s*hr").matcher(duracaoStr);
        if (matcherHora.find()) {
            minutosTotais += Integer.parseInt(matcherHora.group(1)) * 60; // Multiplica por 60 minutos
        }

        // 2. Procura o número antes da palavra "min"
        Matcher matcherMin = Pattern.compile("(\\d+)\\s*min").matcher(duracaoStr);
        if (matcherMin.find()) {
            minutosTotais += Integer.parseInt(matcherMin.group(1)); // Soma os minutos restantes
        }

        return minutosTotais;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "titleEnglish='" + titleEnglish + '\'' +
                ", titleJapanese='" + titleJapanese + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", dataInicio=" + dataInicio +
                ", duration=" + duration +
                ", studio='" + studio + '\'' +
                ", trailher='" + trailher + '\'' +
                ", likes=" + likes +
                '}';
    }
}
