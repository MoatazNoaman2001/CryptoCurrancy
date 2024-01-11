package com.example.myapplication.domain.model

import com.example.myapplication.data.remote.dto.Tag
import com.example.myapplication.data.remote.dto.TeamMember

data class CoinDetails(
    val id:String,
    val name:String,
    val disc:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<Tag>,
    val team:List<TeamMember>
) {
}