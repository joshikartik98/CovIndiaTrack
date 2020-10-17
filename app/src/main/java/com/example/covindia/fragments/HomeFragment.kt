package com.example.covindia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covindia.Api
import com.example.covindia.Client
import com.example.covindia.R
import com.example.covindia.pojo.ApiResp
import com.example.covindia.pojo.StateWiseItem
import com.example.covindia.pojo.StateWiseResponse
import com.example.covindia.pojo.Statewise
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private  val TAG = "HomeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val apiInterface = Api.create().getStates()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue(object : Callback<StateWiseResponse> {
            override fun onResponse(
                call: Call<StateWiseResponse>?,
                response: Response<StateWiseResponse>?
            ) {
                if (response?.body() != null) {
                    bindCombinedData(response.body()!!.statewise[0])
                } else {
                    Log.i(TAG, "onResponse: NULL Response"+response.toString())
                }

            }

            override fun onFailure(call: Call<StateWiseResponse>?, t: Throwable?) {
                Log.d(TAG, "onFailure: NUll")
            }
        })

    }
    private fun bindCombinedData(data: Statewise) {
        confirmedTv.text = data.confirmed
        activeTv.text = data.active
        recoveredTv.text = data.recovered
        deceasedTv.text = data.deaths
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}