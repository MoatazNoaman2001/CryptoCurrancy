package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.RemoteCoin
import com.example.myapplication.data.remote.dto.RemoteCoinDetails

interface CoinRepo {

    suspend fun getCoin(id:String) : RemoteCoinDetails

    suspend fun getCoins() : List<RemoteCoin>
}