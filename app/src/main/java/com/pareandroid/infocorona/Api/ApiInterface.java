package com.pareandroid.infocorona.Api;

import com.pareandroid.infocorona.Model.ModelIndonesia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("indonesia/provinsi")
    Call<List<ModelIndonesia>>getDataIndonesia();
}
