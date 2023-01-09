package com.example.convo_10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * Adapter for the [RecyclerView] in [HistoryFragment].
 */
class HistoryAdapter(context: Context): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return HistoryViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val itemOne = resultOneList[position]
        val itemTwo = resultTwoList[position]

        //Set Text
        holder.resultOne.text = itemOne
        holder.resultTwo.text = itemTwo
    }

    override fun getItemCount() = resultOneList.size

    class HistoryViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val resultOne = view.findViewById<TextView>(R.id.result_1_history)
        val resultTwo = view.findViewById<TextView>(R.id.result_2_history)
    }
}