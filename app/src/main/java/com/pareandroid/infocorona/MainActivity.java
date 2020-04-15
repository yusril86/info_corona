package com.pareandroid.infocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.pareandroid.infocorona.Adapter.AdapterDetail;
import com.pareandroid.infocorona.Adapter.AdapterInfoIndonesia;
import com.pareandroid.infocorona.Api.ApiConfig;
import com.pareandroid.infocorona.Api.ApiInterface;
import com.pareandroid.infocorona.Model.ModelIndonesia;
import com.pareandroid.infocorona.Model.ModelJumlahIndonesia;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView1;
    private RecyclerView.Adapter Radapterprovinsi,RadapterJumlah;
    AdapterInfoIndonesia adapterInfoIndonesia;
    AdapterDetail adapterDetail;
    List<ModelJumlahIndonesia> modelJumlahIndonesias;
    List<ModelIndonesia> modelIndonesias;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);
        recyclerView1 = findViewById(R.id.rv_list_detail);


         apiInterface = ApiConfig.getapi().create(ApiInterface.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setHasFixedSize(true);
        tampiljumlah();





        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager1);
        tampilprovinsi();



    }


    private void tampiljumlah (){

        Call<List<ModelJumlahIndonesia>> modeljumlah = apiInterface.getJumlahIndonesia();
        modeljumlah.enqueue(new Callback<List<ModelJumlahIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelJumlahIndonesia>> call, Response<List<ModelJumlahIndonesia>> response) {
                List<ModelJumlahIndonesia> modelJumlahIndonesias = response.body();
                RadapterJumlah = new AdapterDetail(modelJumlahIndonesias);
                recyclerView1.setAdapter(RadapterJumlah);
            }

            @Override
            public void onFailure(Call<List<ModelJumlahIndonesia>> call, Throwable t) {

            }
        });
     }

    public void tampilprovinsi(){
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
    }


}
