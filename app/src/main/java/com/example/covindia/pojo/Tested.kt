package com.example.covindia.pojo


import com.google.gson.annotations.SerializedName

data class Tested(
    @SerializedName("dailyrtpcrsamplescollectedicmrapplication")
    val dailyrtpcrsamplescollectedicmrapplication: String,
    @SerializedName("individualstestedperconfirmedcase")
    val individualstestedperconfirmedcase: String,
    @SerializedName("positivecasesfromsamplesreported")
    val positivecasesfromsamplesreported: String,
    @SerializedName("samplereportedtoday")
    val samplereportedtoday: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("source1")
    val source1: String,
    @SerializedName("source3")
    val source3: String,
    @SerializedName("testedasof")
    val testedasof: String,
    @SerializedName("testpositivityrate")
    val testpositivityrate: String,
    @SerializedName("testsconductedbyprivatelabs")
    val testsconductedbyprivatelabs: String,
    @SerializedName("testsperconfirmedcase")
    val testsperconfirmedcase: String,
    @SerializedName("testspermillion")
    val testspermillion: String,
    @SerializedName("totalindividualstested")
    val totalindividualstested: String,
    @SerializedName("totalpositivecases")
    val totalpositivecases: String,
    @SerializedName("totalrtpcrsamplescollectedicmrapplication")
    val totalrtpcrsamplescollectedicmrapplication: String,
    @SerializedName("totalsamplestested")
    val totalsamplestested: String,
    @SerializedName("updatetimestamp")
    val updatetimestamp: String
)