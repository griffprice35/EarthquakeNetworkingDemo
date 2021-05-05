package com.jones.honorsmobileapps.networkingdemo

import android.util.Log
import androidx.lifecycle.ViewModel
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class EarthquakeViewModel : ViewModel() {
    fun getEarthquakes(){
        val request = EarthquakeAPI.earthquakeApi.getEarthquakes()
        request.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", response.body().toString())
            }
        })
    }
}