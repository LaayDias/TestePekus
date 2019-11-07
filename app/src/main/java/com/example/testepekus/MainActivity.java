package com.example.testepekus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, numerosArray);
        lista.setAdapter(arrayAdapter);

        //capturando valor digitado pelo usuário
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nao deixar edited vazio
                if (numDigitado.getText().toString().isEmpty() || numDigitado.getText() == null) {
                    Toast.makeText(MainActivity.this,
                            "Não pode ficar em branco", Toast.LENGTH_SHORT).show();

                    return;
                }
                int number = Integer.valueOf(numDigitado.getText().toString());
                //adicionando numeros na lista
                for (int i = 0; i < number; i++) {
                    int showNumber = i + 1;
                    dados.add("0000" + showNumber + "– Item " + showNumber);
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(dados);

                //fechando teclado
                closeKeyboard();
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View child, int position,
                                    long adapterPositon) {

                String item = dados.get(position);

                //Toast.makeText(MainActivity.this,"voce clicou faz algo " + item, Toast.LENGTH_SHORT).show();

                //Abrindo item selecionado
                Intent intent = new Intent(MainActivity.this, ItemLista.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }

        });

    }
    // metodo para fechar teclado
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    //valores exibidos na lista
    private ArrayList<String> preencherNumeros() {
        return new ArrayList<>();
    }

}
