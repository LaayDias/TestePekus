package com.example.testepekus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemLista extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista);


        Intent intent = getIntent();

        String message = intent.getStringExtra("item");
        TextView itemSelecionado = findViewById(R.id.itemSelecionado);

        itemSelecionado.setText(message);
    }
}
