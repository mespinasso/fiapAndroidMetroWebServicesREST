package br.com.mespinasso.metrosprest.api;

import java.util.List;

import br.com.mespinasso.metrosprest.model.Linha;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MetroAPI {

    @GET("/linhas")
    Call<List<Linha>> getLinhas();
}
