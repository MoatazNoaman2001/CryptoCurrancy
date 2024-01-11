package com.example.myapplication.domain.use_cases

import com.example.myapplication.commons.Resource
import com.example.myapplication.data.remote.dto.toCoin
import com.example.myapplication.domain.model.Coin
import com.example.myapplication.domain.repository.CoinRepo
import com.example.myapplication.domain.repository.CoinRepoImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(val repo: CoinRepoImpl) {

    operator fun invoke () : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repo.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage))
        }catch (e: IOException){
            emit(Resource.Error(message = "check internet connection"))
        }
    }
}