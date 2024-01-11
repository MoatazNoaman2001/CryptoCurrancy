package com.example.myapplication.presentation.coinDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commons.Resource
import com.example.myapplication.domain.model.Coin
import com.example.myapplication.domain.model.CoinDetails
import com.example.myapplication.domain.use_cases.GetCoinDetailsUseCase
import com.example.myapplication.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(val getCoinDetailsUseCase: GetCoinDetailsUseCase ) : ViewModel() {
    fun coinListRes(id:String): Flow<Resource<CoinDetails>> = getCoinDetailsUseCase(id)
}