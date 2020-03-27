package com.pareandroid.infocorona.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pareandroid.infocorona.Model.ModelIndonesia;
import com.pareandroid.infocorona.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterInfoIndonesia extends RecyclerView.Adapter<AdapterInfoIndonesia.itemviewholder> {
    private  List<ModelIndonesia> indonesiaList;

    public AdapterInfoIndonesia(List<ModelIndonesia> modelIndonesias) {
        this.indonesiaList = modelIndonesias ;
    }

    @NonNull
    @Override
    public itemviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new itemviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemviewholder holder, int position) {
        ModelIndonesia model = indonesiaList.get(position);

        holder.tv_sembuh.setText(model.getAttributes().getKasusSemb().toString());
        holder.tv_provinsi.setText(model.getAttributes().getProvinsi());
        holder.tv_mati.setText(model.getAttributes().getKasusMeni().toString());
        holder.tv_positif.setText(model.getAttributes().getKasusPosi().toString());
    }

    @Override
    public int getItemCount() {
        return indonesiaList.size();
    }

    public class itemviewholder extends RecyclerView.ViewHolder {
        TextView tv_positif,tv_mati,tv_sembuh,tv_provinsi;
        CardView btn_info;

        public itemviewholder(@NonNull View itemView) {
            super(itemView);

            tv_positif = itemView.findViewById(R.id.tvListConfirmed);
            tv_mati = itemView.findViewById(R.id.tvListDeath);
            tv_sembuh = itemView.findViewById(R.id.tvListRecovered);
            tv_provinsi = itemView.findViewById(R.id.tv_provinsi);
            btn_info = itemView.findViewById(R.id.btn_prov);
        }
    }
}
