package br.univille.dsi2020android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.univille.dsi2020android.apiservice.APIConnection;
import br.univille.dsi2020android.apiservice.APIService;
import br.univille.dsi2020android.model.Usuario;

public class LoginActivity extends AppCompatActivity implements LoginResponse{

    private EditText txtUsuario, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
    }

    public void clickEntrar(View view){
        Usuario usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        APIConnection.getInstance().login(usuario,this);
    }

    @Override
    public void loginResponse(boolean result) {
        if(result){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
        }
    }
}