package com.example.testepekus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dados = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.lista);
        final EditText numDigitado = findViewById(R.id.edtNumero);
        Button btnPesquisar = findViewById(R.id.bntPesquisar);
        final ArrayList<String> numerosArray = preencherNumeros();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numerosArray);
        lista.setAdapter(arrayAdapter);

        //capturando valor digitado pelo usuário
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numDigitado.getText().toString().isEmpty() || numDigitado.getText() == null) {
                    Toast.makeText(MainActivity.this, "nao pode ficar em branco", Toast.LENGTH_SHORT).show();
                    return;
                }
                int number = Integer.valueOf(numDigitado.getText().toString());

                for (int i = 0; i < number; i++) {
                    int showNumber = i + 1;
                    dados.add("0000" + showNumber + "– Item " + showNumber);
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(dados);
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View child, int position,
                                    long adapterPositon) {

                String item = dados.get(position);

                Toast.makeText(MainActivity.this, "voce clicou faz algo " + item, Toast.LENGTH_SHORT).show();
            }

        });

    }

    //valores exibidos na lista
    private ArrayList<String> preencherNumeros() {
        return new ArrayList<>();
    }

}
