package com.example.rescylerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rescylerview.R
import com.example.rescylerview.data.Match

class MatchAdapter(val list:List<Match>): RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return MatchViewHolder(view)
    }



    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentItem=list[position]
         holder.apply {
         textNameteam1.text=currentItem.homeTeamName
         textNameteam2.text=currentItem.awayTeamName
         textStedioum.text=currentItem.stadium
         textScoreteam1.text=currentItem.homeTeamGoals
         textScoreteam2.text=currentItem.awayTeamGoals
         textYear.text=currentItem.year
     }




    }



    override fun getItemCount(): Int =list.size







    class MatchViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textNameteam1=itemView.findViewById<TextView>(R.id.text_Name1)
        val textNameteam2=itemView.findViewById<TextView>(R.id.text_Name2)
        val textScoreteam1=itemView.findViewById<TextView>(R.id.score_team1)
        val textScoreteam2=itemView.findViewById<TextView>(R.id.score_team2)
        val textYear=itemView.findViewById<TextView>(R.id.text_year)
        val textStedioum=itemView.findViewById<TextView>(R.id.text_stedioum)

    }
}