package com.example.testconverter.ui.selection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testconverter.R;
import com.example.testconverter.model.pojo.Currency;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    ArrayList<Currency> mCurrencies;

    public CurrencyAdapter(ArrayList<Currency> currencies) {
        mCurrencies = currencies;
    }

    @NonNull
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.currensy_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.ViewHolder holder, int position) {
        holder.charCodeView.setText(mCurrencies.get(position).getCharCode());
        holder.nameView.setText(mCurrencies.get(position).getName());
        holder.valueView.setText(String.valueOf(mCurrencies.get(position).getValue()));
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView charCodeView;
        TextView nameView;
        TextView valueView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            charCodeView = itemView.findViewById(R.id.char_code_view);
            nameView = itemView.findViewById(R.id.name_view);
            valueView = itemView.findViewById(R.id.value_view);
        }
    }
}
