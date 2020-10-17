package com.example.covindia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covindia.pojo.Statewise

class ListAdapter (context:Context):  RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var list : List<Statewise> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.stateV.text = list.get(position).state
        holder.confirmedV.text = list.get(position).confirmed
        holder.activeV.text = list.get(position).active
        holder.recordedV.text = list.get(position).recovered
        holder.deadV.text = list.get(position).deaths
    }

    fun setStatesList(list: List<Statewise>){
        this.list = list;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val stateV: TextView = itemView!!.findViewById(R.id.stateTv)
        val confirmedV: TextView = itemView!!.findViewById(R.id.confirmedTv)
        val activeV: TextView = itemView!!.findViewById(R.id.activeTv)
        val recordedV: TextView = itemView!!.findViewById(R.id.recoveredTv)
        val deadV: TextView = itemView!!.findViewById(R.id.deceasedTv)

    }
}