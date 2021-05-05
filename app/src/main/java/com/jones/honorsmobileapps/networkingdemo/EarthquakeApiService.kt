package com.jones.honorsmobileapps.networkingdemo

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val QUERY_STRING =
        "query?format=geojson" +
                "&starttime=2021-01-01" +
                "&endtime=2021-01-31" +
                "&minmag=6" +
                "&limit=10"

private const val BASE_URL =
        "https://earthquake.usgs.gov/fdsnws/event/1/"

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create()).build()

interface EarthquakeApiService {
    @GET(QUERY_STRING)
    fun getEarthquakes(): Call<String>
}

object EarthquakeAPI{
    val earthquakeApi: EarthquakeApiService by lazy {
        retrofit.create(EarthquakeApiService::class.java)
    }
}