package com.pareandroid.infocorona.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pareandroid.infocorona.Api.ApiInterface;
import com.pareandroid.infocorona.DiagramProvinsi;
import com.pareandroid.infocorona.Model.ModelIndonesia;
import com.pareandroid.infocorona.Model.ModelJumlahIndonesia;
import com.pareandroid.infocorona.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterInfoIndonesia extends RecyclerView.Adapter<AdapterInfoIndonesia.itemviewholder> {
    private  List<ModelIndonesia> indonesiaList;

    ApiInterface apiInterface;

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

//        Call<List<ModelIndonesia>> modelIndonesiaCall = apiInterface.getDataIndonesia();
//        modelIndonesiaCall.enqueue(new Callback<List<ModelIndonesia>>() {
//            @Override
//            public void onResponse(Call<List<ModelIndonesia>> call, Response<List<ModelIndonesia>> response) {
//                response.body();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ModelIndonesia>> call, Throwable t) {
//
//            }
//        });

        holder.tv_sembuh.setText(model.getAttributes().getKasusSemb().toString());
        holder.tv_provinsi.setText(model.getAttributes().getProvinsi());
        holder.tv_mati.setText(model.getAttributes().getKasusMeni().toString());
        holder.tv_positif.setText(model.getAttributes().getKasusPosi().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DiagramProvinsi.class);
                intent.putExtra("meninggal",model.getAttributes().getKasusMeni());
                intent.putExtra("positif",model.getAttributes().getKasusPosi());
                intent.putExtra("sembuh",model.getAttributes().getKasusSemb());
                intent.putExtra("provinsi",model.getAttributes().getProvinsi());
                view.getContext().startActivity(intent);
            }
        });
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
