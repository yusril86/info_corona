package com.pareandroid.infocorona.Api;

import com.pareandroid.infocorona.Model.ModelIndonesia;
import com.pareandroid.infocorona.Model.ModelJumlahIndonesia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("indonesia/provinsi")
    Call<List<ModelIndonesia>>getDataIndonesia();

    @GET("indonesia")
    Call<List<ModelJumlahIndonesia>>getJumlahIndonesia();
}
