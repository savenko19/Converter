package com.example.testconverter.ui.selection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testconverter.R;
import com.example.testconverter.model.pojo.Currency;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ArrayList<Currency> currencies);
    }

    private View itemView;
    private OnItemClickListener mItemClickListener;
    private ArrayList<Currency> mCurrencies;

    public CurrencyAdapter(ArrayList<Currency> currencies, OnItemClickListener onItemClickListener) {
        mCurrencies = currencies;
        mItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.currensy_item_layout, parent, false);
        return new ViewHolder(itemView, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.ViewHolder holder, int position) {
        if (mCurrencies.get(position).isSelect()) {
            itemView.setBackground(itemView.getResources().getDrawable(R.drawable.selected_bg));
        }
        holder.charCodeView.setText(mCurrencies.get(position).getCharCode());
        holder.nameView.setText(mCurrencies.get(position).getName());
        holder.valueView.setText(new DecimalFormat("##.###").format(mCurrencies.get(position).getValue()
                / mCurrencies.get(position).getNominal()));
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OnItemClickListener onItemClickListener;

        TextView charCodeView;
        TextView nameView;
        TextView valueView;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            charCodeView = itemView.findViewById(R.id.char_code_view);
            nameView = itemView.findViewById(R.id.name_view);
            valueView = itemView.findViewById(R.id.value_view);

            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            for (Currency currency : mCurrencies) {
                currency.setSelect(false);
            }
            mCurrencies.get(getAdapterPosition()).setSelect(true);
            onItemClickListener.onItemClick(mCurrencies);
        }
    }
}
