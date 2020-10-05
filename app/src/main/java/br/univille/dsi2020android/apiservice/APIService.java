package br.univille.dsi2020android.apiservice;

import br.univille.dsi2020android.model.Paciente;
import br.univille.dsi2020android.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    @POST("auth/signin")
    Call<String> signin(@Body Usuario usuario);
    @GET("pacientes/{id}")
    Call<Paciente> getPacienteById(@Path("id") long id);
}
