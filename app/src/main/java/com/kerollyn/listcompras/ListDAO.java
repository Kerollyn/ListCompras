package com.kerollyn.listcompras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListDAO {

    public static final void inserir(Produto list, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", list.getNome() );
        valores.put("perço", list.getPreco() );
        valores.put("quantidade",list.getQuantidade());
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("produtos", null, valores);
    }

    public static final void excluir(int idList, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("produtos", "id = "+idList, null);
    }

    public static final List<Produto> listar(Context context){
        List<Produto> listaProdutos = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM anotacoes ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto nota = new Produto();
                nota.setId( cursor.getInt( 0 ) );
                nota.setNome(etNome.getText().toString());
                nota.setPreco(etPreco.getText().toString());
                nota.setQuantidade(etQuantidade.getText().toString());
                listaProdutos.add( nota );
            }while ( cursor.moveToNext() );
        }
        return listaProdutos;
    }



}
