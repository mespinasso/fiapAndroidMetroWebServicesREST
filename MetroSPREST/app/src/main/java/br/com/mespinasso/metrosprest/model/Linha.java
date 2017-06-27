package br.com.mespinasso.metrosprest.model;

import com.google.gson.annotations.SerializedName;

public class Linha {

    @SerializedName("cor")
    private String cor;

    @SerializedName("numero")
    private String numero;

    @SerializedName("urlImagem")
    private String urlImagem;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
