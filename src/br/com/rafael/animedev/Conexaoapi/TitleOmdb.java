package br.com.rafael.animedev.Conexaoapi;

import java.util.List;



public record TitleOmdb(String title_english,
                        String title_japanese,
                        String status,
                        Aired aired,
                        String duration,
                        String synopsis,
                        List<Studio> studios,
                        Trailer trailer,
                        ImagensAnime images,
                        int favorites

) {
    public record DataWrapper(TitleOmdb data) {}
    public record DataWrapperId(TitleOmdb data) {}
    public record DataWrapperBusca(List<TitleOmdb> data) {}

    public record Jpg(String image_url) {}
    public record ImagensAnime(Jpg jpg) {}
    public record Trailer(String url) {}
    public record Aired(String string) {}
    public record Studio (String name) {}

    @Override
    public String toString() {
        return "TitleOmdb{" +
                "title_english='" + title_english + '\'' +
                ", title_japanese='" + title_japanese + '\'' +
                ", status='" + status + '\'' +
                ", lançamento=" + aired +
                ", duration='" + duration + '\'' +
                ", studios=" + studios +
                ", trailer=" + trailer +
                ", image_url='" + images + '\'' +
                ", favorites=" + favorites +
                '}';
    }
}
