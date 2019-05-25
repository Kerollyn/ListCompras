package com.kerollyn.listcompras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProdutosActivity extends AppCompatActivity {

    private EditText etNome, etPreco,etQuantidade;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produtos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etNome = (EditText) findViewById(R.id.etNome);
        etPreco = (EditText) findViewById(R.id.etPreco);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade) ;
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        Produto nota = new Produto();
        nota.setNome( etNome.getText().toString() );
        nota.setPreco(etPreco.getText().toString());
        nota.setQuantidade(etQuantidade.getText().toString());
        ListDAO.inserir(nota, this);
        this.finish();
    }
}
