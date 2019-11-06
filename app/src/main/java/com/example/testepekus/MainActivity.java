package com.example.testepekus;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Integer[] tamanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.lista);
        final EditText numDigitado = findViewById(R.id.edtNumero);
        Button btnPesquisar = findViewById(R.id.bntPesquisar);
        final ArrayList<String> numerosArray = preencherNumeros();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numerosArray);
        lista.setAdapter(arrayAdapter);

        //capturando valor digitado pelo usuário
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.valueOf(numDigitado.getText().toString());
                Toast.makeText(getApplicationContext(), "numero " + number, Toast.LENGTH_SHORT).show();
            }
        });


        //erro no lista???
       /* lista.OnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Numero " + numerosArray.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });*/
    }

    //valores exibidos na lista
    private ArrayList<String> preencherNumeros() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Informação 1");
        dados.add("Informação 2");
        dados.add("Informação 3");
        dados.add("Informação 4");
        return dados;
    }


}
