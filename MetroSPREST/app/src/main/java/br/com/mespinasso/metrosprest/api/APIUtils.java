package br.com.mespinasso.metrosprest.api;

public class APIUtils {

    public static final String BASE_URL = "http://10.3.1.4:3000";

    public static MetroAPI getLinhasMetro() {
        return RetrofitClient.getClient(BASE_URL).create(MetroAPI.class);
    }
}
