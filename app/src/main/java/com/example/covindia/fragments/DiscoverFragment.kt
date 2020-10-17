package com.example.covindia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covindia.*
import com.example.covindia.pojo.StateWiseResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DiscoverFragment : Fragment() {
    private lateinit var listAdapter: ListAdapter
    private val TAG = "DiscoverFragment"

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var recyclerAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_discover, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)
        recyclerAdapter = ListAdapter(context!!)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter

        sendRequest()

        return view;
    }

    private fun  sendRequest(){
        progressBar(true)
        val apiInterface = Api.create().getStates()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue(object : Callback<StateWiseResponse> {
            override fun onResponse(
                call: Call<StateWiseResponse>?,
                response: Response<StateWiseResponse>?
            ) {
                progressBar(false)
                if (response?.body() != null) {
                    recyclerAdapter.setStatesList(response.body()!!.statewise)
                } else {
                    Log.i(TAG, "onResponse: NULL Response"+response.toString())
                }

            }

            override fun onFailure(call: Call<StateWiseResponse>?, t: Throwable?) {
                progressBar(false)
                Log.d(TAG, "onFailure: NUll")
            }
        })
    }

    private fun progressBar(value : Boolean){
        if(value){
            recyclerView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }else{
            recyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

}