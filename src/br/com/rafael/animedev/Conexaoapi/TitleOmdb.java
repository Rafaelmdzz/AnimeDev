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
                        String image_url,
                        int favorites) {
    public record DataWrapper(TitleOmdb data) {}
}
