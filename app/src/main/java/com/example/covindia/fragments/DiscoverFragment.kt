package com.example.covindia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covindia.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.coroutines.*



class DiscoverFragment : Fragment() {
    private lateinit var    listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.async {
            val response = withContext(Dispatchers.IO){ Client.api.execute() }
            if(response.isSuccessful) {
                val data = Gson().fromJson(response.body?.toString(), Response::class.java)
                async(Dispatchers.Main){
                    bindStateWiseData(data.statewise.subList(0, data.statewise.size))
                }
            }
        }
    }

    private fun bindStateWiseData(subList: List<StateWiseItem>){
        listAdapter= ListAdapter(subList)
        list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.list_header, list,false))
        list.adapter =  listAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }


}