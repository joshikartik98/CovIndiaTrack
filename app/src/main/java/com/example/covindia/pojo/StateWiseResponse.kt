package com.example.covindia.pojo


import com.google.gson.annotations.SerializedName

data class StateWiseResponse(
    @SerializedName("cases_time_series")
    val casesTimeSeries: List<CasesTimeSery>,
    @SerializedName("statewise")
    val statewise: List<Statewise>,
    @SerializedName("tested")
    val tested: List<Tested>
)