package com.example.myapplication.commons

import com.example.myapplication.data.remote.CoinPaprikaApi
import com.example.myapplication.domain.repository.CoinRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object HitlSengltons {


    @Provides
    @Singleton
    public fun retrofitBuilder(): Retrofit = Retrofit.Builder().baseUrl(CoinPaprikaApi.baseUrl.url).addConverterFactory(GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    public fun coinPaprikaApi(retrofit: Retrofit): CoinPaprikaApi = retrofit.create(CoinPaprikaApi::class.java)

}