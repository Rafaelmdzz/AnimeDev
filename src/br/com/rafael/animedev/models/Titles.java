package br.com.rafael.animedev.models;

import br.com.rafael.animedev.Conexaoapi.Studio;
import br.com.rafael.animedev.Conexaoapi.TitleOmdb;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titles {
    private String titleEnglish;
    private String titleJapanese;
    private String status;
    private String image;
    private int dataInicio;
    private int durationMin;
    private String durationString;
    private String synopsis;
    private List<Studio> studio;
    private String trailher;
    private int likes;

    public Titles(String titleEnglish, String titleJapanese, String status, String image, int dataInicio, int dataFim, String duration, String synopsis, String studio, String trailher, int views, int likes) {
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
        this.durationMin = converterTempoDuracao(data.duration());
        this.durationString = data.duration();
        this.synopsis = data.synopsis();
        this.studio = data.studios()
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
