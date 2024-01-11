package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.RemoteCoin
import com.example.myapplication.data.remote.dto.RemoteCoinDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    object baseUrl{
        val url = "https://api.coinpaprika.com/"
    }

    @GET("/v1/coins")
    suspend fun getCoins(): List<RemoteCoin>


    @GET("/v1/coins/{coin_id}")
    suspend fun getCoin(@Path("coin_id") coinId:String) : RemoteCoinDetails


}