package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.CoinPaprikaApi
import com.example.myapplication.data.remote.dto.RemoteCoin
import com.example.myapplication.data.remote.dto.RemoteCoinDetails
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(val coinPaprikaApi: CoinPaprikaApi) : CoinRepo{
    override suspend fun getCoin(id: String): RemoteCoinDetails {
        return coinPaprikaApi.getCoin(id)
    }

    override suspend fun getCoins(): List<RemoteCoin> {
        return coinPaprikaApi.getCoins()
    }
}