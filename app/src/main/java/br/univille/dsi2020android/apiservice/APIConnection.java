package br.univille.dsi2020android.apiservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {
    private static APIConnection instance;
    private APIService service;
    private APIConnection(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(APIService.class);
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
