package com.example.testepekus;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Integer contador = 0, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.lista);

        ArrayList<String> numeros = preencherNumeros();

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, R.layout.item_lista);
        lista.setAdapter(arrayAdapter);

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
