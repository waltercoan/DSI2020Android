package br.univille.dsi2020android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.univille.dsi2020android.apiservice.APIConnection;
import br.univille.dsi2020android.apiservice.APIService;
import br.univille.dsi2020android.model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){

        APIService service = APIConnection.getInstance().getService();

        Usuario usuario = new Usuario();
        usuario.setUsuario("admin");
        usuario.setSenha("admin");

        Call<String> chamada = service.signin(usuario);
        chamada.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this,response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage().toString());
                Toast.makeText(MainActivity.this,t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

        //

        /*Toast.makeText(this,"Eu não acredito", Toast.LENGTH_LONG).show();
        Bundle dados = new Bundle();
        dados.putString("Nome","Zezinho");
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("dados",dados);
        startActivity(intent);*/
    }
}