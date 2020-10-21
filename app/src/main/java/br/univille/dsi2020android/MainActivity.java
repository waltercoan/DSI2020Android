package br.univille.dsi2020android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.univille.dsi2020android.apiservice.APIConnection;
import br.univille.dsi2020android.apiservice.APIService;
import br.univille.dsi2020android.model.Paciente;
import br.univille.dsi2020android.model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listPaciente;
    private ArrayAdapter<Paciente> listDataPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPaciente = (ListView) findViewById(R.id.listPaciente);
        listDataPaciente = new ArrayAdapter<Paciente>(this,android.R.layout.simple_list_item_1, new ArrayList<Paciente>());
        listPaciente.setAdapter(listDataPaciente);
        updateList();
    }
    public void updateList(){
        APIService service = APIConnection.getInstance().getService();
        service.getAllPaciente().enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
                listDataPaciente.clear();
                listDataPaciente.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Erro chamada servidor", Toast.LENGTH_LONG).show();
            }
        });
    }
    /*public void clickButton(View view){

        APIService service = APIConnection.getInstance().getService();

        Call<Paciente> pacienteCall = service.getPacienteById(1);

        pacienteCall.enqueue(new Callback<Paciente>() {
            @Override
            public void onResponse(Call<Paciente> call, Response<Paciente> response) {
                Paciente paciente = (Paciente)response.body();
                Toast.makeText(MainActivity.this,paciente.getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Paciente> call, Throwable t) {
                System.out.println(t.getMessage().toString());
                Toast.makeText(MainActivity.this,t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

        Toast.makeText(this,"Eu não acredito", Toast.LENGTH_LONG).show();
        Bundle dados = new Bundle();
        dados.putString("Nome","Zezinho");
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("dados",dados);
        startActivity(intent);
    }*/
}