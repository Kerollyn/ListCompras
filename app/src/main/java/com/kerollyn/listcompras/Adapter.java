package com.kerollyn.listcompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Produto> lista;
    private LayoutInflater inflater;

    public Adapter(Context context, List<Produto> lista){
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate
                    (R.layout.activity_list_lista, null);
            item = new Suporte();
            item.tvCodigo = (TextView)
                    convertView.findViewById(R.id.ltvProdutos);
            item.tvNome = (TextView)
                    convertView.findViewById(R.id.ltvProdutos);
            item.tvQuantidade = (TextView)
                    convertView.findViewById(R.id.ltvProdutos);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Produto produto = lista.get( position );
        //item.tvCodigo.setText( String.valueOf( produto.getId() ) );
        item.tvNome.setText(produto.getNome());
        //item.tvPreco.setText(  produto.getPreco()  );
        item.tvQuantidade.setText(produto.getQuantidade());




        return convertView;
    }

    private class Suporte{
        TextView tvCodigo, tvNome, tvPreco,tvQuantidade;
    }

}