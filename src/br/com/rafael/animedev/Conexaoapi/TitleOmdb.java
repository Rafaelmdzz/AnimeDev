package br.com.rafael.animedev.Conexaoapi;

import java.util.List;

record Jpg(String image_url) {}
record ImagensAnime(Jpg jpg) {}
record Trailer(String url) {}
record Aired(String string) {}
record Studio (String name) {}

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
