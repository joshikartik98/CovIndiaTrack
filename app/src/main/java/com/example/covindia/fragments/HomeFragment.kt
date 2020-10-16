package com.example.covindia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covindia.Client
import com.example.covindia.R
import com.example.covindia.Response
import com.example.covindia.StateWiseItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.coroutines.*


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) { Client.api.execute() }
            if (response.isSuccessful) {
                val data = Gson().fromJson(response.body?.string(), Response::class.java)
                launch(Dispatchers.Main) {
                    bindCombinedData(data.statewise[0])
                }
            }
        }
    }
    private fun bindCombinedData(data: StateWiseItem) {
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