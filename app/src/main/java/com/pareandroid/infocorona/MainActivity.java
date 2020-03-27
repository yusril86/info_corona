package com.pareandroid.infocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.pareandroid.infocorona.Adapter.AdapterInfoIndonesia;
import com.pareandroid.infocorona.Api.ApiConfig;
import com.pareandroid.infocorona.Api.ApiInterface;
import com.pareandroid.infocorona.Model.ModelIndonesia;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterInfoIndonesia adapterInfoIndonesia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);

        ApiInterface apiInterface = ApiConfig.getapi().create(ApiInterface.class);
        Call<List<ModelIndonesia>> modelIndonesiaCall = apiInterface.getDataIndonesia();
        modelIndonesiaCall.enqueue(new Callback<List<ModelIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelIndonesia>> call, Response<List<ModelIndonesia>> response) {
                LoadData(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelIndonesia>> call, Throwable t) {

            }
        });
    }
    private void LoadData(List<ModelIndonesia> modelIndonesias){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapterInfoIndonesia = new AdapterInfoIndonesia(modelIndonesias);
        recyclerView.setAdapter(adapterInfoIndonesia);
    }
}
