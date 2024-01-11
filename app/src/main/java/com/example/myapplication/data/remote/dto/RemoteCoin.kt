package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.model.Coin

data class RemoteCoin(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun RemoteCoin.toCoin():Coin = Coin(id , name, rank, symbol, isActive = is_active )