package br.univille.dsi2020android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle dados = getIntent().getBundleExtra("dados");
        mensagem = (EditText) findViewById(R.id.mensagem);
        mensagem.setText(dados.getString("Nome"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Bundle dados = getIntent().getBundleExtra("dados");
        mensagem = (EditText) findViewById(R.id.mensagem);
        dados.putString("Nome",mensagem.getText().toString());
    }
}