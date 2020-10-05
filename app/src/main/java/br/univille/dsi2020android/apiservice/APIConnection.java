package br.univille.dsi2020android.apiservice;
import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import br.univille.dsi2020android.LoginResponse;
import br.univille.dsi2020android.MainActivity;
import br.univille.dsi2020android.model.Usuario;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {
    private static APIConnection instance;
    private APIService service;
    private String token = null;
    private Retrofit retrofit;
    private OkHttpClient.Builder httpClient;
    private Gson gson;

    private APIConnection(){
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(APIService.class);
    }

    public void login(Usuario usuario, Activity activity){

        final LoginResponse loginResponse = (LoginResponse)activity;
        httpClient = new OkHttpClient.Builder();

        Call<String> chamada = service.signin(usuario);
        chamada.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, final retrofit2.Response<String> response) {
                if(response.body() != null) {
                    token = response.body().toString();
                    httpClient.addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + response.body().toString()).build();
                            return chain.proceed(request);
                        }
                    });
                    retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:8080/api/v1/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(httpClient.build())
                            .build();
                    service = retrofit.create(APIService.class);
                    loginResponse.loginResponse(true);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                token = null;
                loginResponse.loginResponse(false);
            }
        });
    }

    public APIService getService(){
        return this.service;
    }
    public static APIConnection getInstance(){
        if(instance == null){
            instance = new APIConnection();
        }
        return instance;
    }
}
