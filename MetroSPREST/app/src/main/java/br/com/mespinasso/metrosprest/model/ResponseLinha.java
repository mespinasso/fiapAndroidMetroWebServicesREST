package br.com.mespinasso.metrosprest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLinha {

    @SerializedName("linha")
    private List<Linha> linhaList;

    public List<Linha> getLinhaList() {
        return linhaList;
    }

    public void setLinhaList(List<Linha> linhaList) {
        this.linhaList = linhaList;
    }
}
