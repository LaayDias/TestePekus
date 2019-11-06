package com.example.testepekus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lista);

        final ArrayList<String> equipes = preencherNumeros();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1  , equipes);
        lista.setAdapter(arrayAdapter);

        lista.OnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Numero " + equipes.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<String> preencherNumeros() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Informação 1");
        dados.add("Informação 2");
        dados.add("Informação 3");
        dados.add("Informação 4");
        return dados;
    }


}
