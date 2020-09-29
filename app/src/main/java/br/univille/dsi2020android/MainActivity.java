package br.univille.dsi2020android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){
        Toast.makeText(this,"Eu não acredito", Toast.LENGTH_LONG).show();
        Bundle dados = new Bundle();
        dados.putString("Nome","Zezinho");
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("dados",dados);
        startActivity(intent);
    }
}