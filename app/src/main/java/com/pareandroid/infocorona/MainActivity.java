package com.pareandroid.infocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pareandroid.infocorona.Adapter.AdapterDetail;
import com.pareandroid.infocorona.Adapter.AdapterInfoIndonesia;
import com.pareandroid.infocorona.Api.ApiConfig;
import com.pareandroid.infocorona.Api.ApiInterface;
import com.pareandroid.infocorona.Model.ModelIndonesia;
import com.pareandroid.infocorona.Model.ModelJumlahIndonesia;
import com.pareandroid.infocorona.Presenter.ProvinsiPresenter;
import com.pareandroid.infocorona.View.ProvinsiView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProvinsiView {
    RecyclerView recyclerViewProv,recyclerViewdetail;
    private RecyclerView.Adapter Radapterprovinsi,RadapterJumlah;
    AdapterInfoIndonesia adapterInfoIndonesia;
    AdapterDetail adapterDetail;
    List<ModelJumlahIndonesia> modelJumlahIndonesias;
    List<ModelIndonesia> modelIndonesias;
    ApiInterface apiInterface;
    ProgressBar progressBar;
    ProvinsiPresenter provinsiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewProv = findViewById(R.id.rv_list);
        recyclerViewdetail = findViewById(R.id.rv_list_detail);
        progressBar = findViewById(R.id.pg_loadaing);


         apiInterface = ApiConfig.getapi().create(ApiInterface.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewdetail.setLayoutManager(linearLayoutManager);
        recyclerViewdetail.setHasFixedSize(true);
        tampiljumlah();





        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerViewProv.setHasFixedSize(true);
        recyclerViewProv.setLayoutManager(linearLayoutManager1);
        provinsiPresenter = new ProvinsiPresenter(this);
        provinsiPresenter.tampilprovinsi();


    }

    //Data Indonesia Saya Menggunakan dengan Cara Manual
    private void tampiljumlah (){

        Call<List<ModelJumlahIndonesia>> modeljumlah = apiInterface.getJumlahIndonesia();
        modeljumlah.enqueue(new Callback<List<ModelJumlahIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelJumlahIndonesia>> call, Response<List<ModelJumlahIndonesia>> response) {
                List<ModelJumlahIndonesia> modelJumlahIndonesias = response.body();
                RadapterJumlah = new AdapterDetail(modelJumlahIndonesias);
                recyclerViewdetail  .setAdapter(RadapterJumlah);
            }

            @Override
            public void onFailure(Call<List<ModelJumlahIndonesia>> call, Throwable t) {

            }
        });
     }


     //Data Provinsi saya Menggunakan MVP

         @Override
         public void Showloadinng () {
             progressBar.setVisibility(View.VISIBLE);
         }

         @Override
         public void hideLoading () {
             progressBar.setVisibility(View.GONE);
             recyclerViewProv.setVisibility(View.VISIBLE);
         }

         @Override
         public void Onresponse (List < ModelIndonesia > modelIndonesias) {
             Radapterprovinsi = new AdapterInfoIndonesia(modelIndonesias);
             recyclerViewProv.setAdapter(Radapterprovinsi);
         }

         @Override
         public void OnFailure (String message){
            Toast.makeText(this,"Error...",Toast.LENGTH_SHORT).show();
         }



   /* public void tampilprovinsi(){
        Call<List<ModelIndonesia>> modelIndonesiaCall = apiInterface.getDataIndonesia();
        modelIndonesiaCall.enqueue(new Callback<List<ModelIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelIndonesia>> call, Response<List<ModelIndonesia>> response) {
                    List<ModelIndonesia> modelprovinsi = response.body();
                    Radapterprovinsi = new AdapterInfoIndonesia(modelprovinsi);
                    recyclerView.setAdapter(Radapterprovinsi);

            }

            @Override
            public void onFailure(Call<List<ModelIndonesia>> call, Throwable t) {

            }
        });
    }*/



}
