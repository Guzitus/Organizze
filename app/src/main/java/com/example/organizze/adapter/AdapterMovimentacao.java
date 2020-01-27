package com.example.organizze.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organizze.R;
import com.example.organizze.model.Movimentacao;

import java.util.List;

public class AdapterMovimentacao extends RecyclerView.Adapter<AdapterMovimentacao.MyViewHolder> {

    private List<Movimentacao> listaMovimentacao;
    private Context context;

    public AdapterMovimentacao(List<Movimentacao> lista, Context context) {
        this.listaMovimentacao = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovimentacao.MyViewHolder holder, int position) {

        Movimentacao movimentacao = listaMovimentacao.get(position);
        holder.descricao.setText(movimentacao.getDescricao());
        holder.data.setText(movimentacao.getData());
        holder.valor.setText(String.valueOf(movimentacao.getValor()));
        holder.valor.setTextColor(context.getResources().getColor(R.color.colorFabReceitas));

        if (movimentacao.getTipo().equals("despesa")){
            holder.valor.setTextColor(context.getResources().getColor(R.color.colorFabDespesas));
            holder.valor.setText("-" + movimentacao.getValor());
        }

    }

    @Override
    public int getItemCount() {
        return listaMovimentacao.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView descricao;
        TextView data;
        TextView valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            descricao = itemView.findViewById(R.id.textDescricao);
            data = itemView.findViewById(R.id.textData);
            valor = itemView.findViewById(R.id.textValor);

        }
    }
}
