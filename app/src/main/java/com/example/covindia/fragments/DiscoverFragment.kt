package com.example.covindia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
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
    lateinit var recyclerAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recyclerAdapter = ListAdapter(context!!)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter


        val apiInterface = Api.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<StateWiseResponse>{
            override fun onResponse(call: Call<StateWiseResponse>?, response: Response<StateWiseResponse>?) {

                if(response?.body() != null)
                    recyclerAdapter.setStatesList(response.body()!!.statewise)
            }

            override fun onFailure(call: Call<StateWiseResponse>?, t: Throwable?) {

            }
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

}