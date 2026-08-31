package br.com.rafael.animedev.models;

public class Episodes {
    private int numero;
    private String titles;
    private String titleJapones;
    private String lancamento;
    private int duracao;
    private String synopsis;


    public Episodes(int numero, String titles, String titleJapones, String lancamento, int duracao, String synopsis) {
        this.numero = numero;
        this.titles = titles;
        this.titleJapones = titleJapones;
        this.lancamento = lancamento;
        this.duracao = duracao;
        this.synopsis = synopsis;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitles() {
        return titles;
    }

    public String getTitleJapones() {
        return titleJapones;
    }

    public String getLancamento() {
        return lancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
