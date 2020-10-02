package br.univille.dsi2020android.apiservice;

import br.univille.dsi2020android.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("auth/signin")
    Call<String> signin(@Body Usuario usuario);
}
