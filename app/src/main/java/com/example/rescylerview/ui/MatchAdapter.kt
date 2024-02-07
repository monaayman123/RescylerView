package com.example.rescylerview.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.rescylerview.R
import com.example.rescylerview.data.Match
import com.example.rescylerview.databinding.ItemMatchBinding


class MatchAdapter(private var list:List<Match>,private val listener: MatchInteractionListener): RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return MatchViewHolder(view)
    }



    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {


        val currentItem=list[position]
         holder.binding.apply {
  
            textName1.text=currentItem.homeTeamName
            textName2.text=currentItem.awayTeamName
            textStedioum.text=currentItem.stadium
             scoreTeam1.text=currentItem.homeTeamGoals
             scoreTeam2.text=currentItem.awayTeamGoals
             textYear.text=currentItem.year


             if (currentItem.homeTeamGoals>currentItem.awayTeamGoals){
                 scoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                 scoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
             }else    if (currentItem.homeTeamGoals<currentItem.awayTeamGoals){
                 scoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                 scoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
             }else{
                 scoreTeam1.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
                 scoreTeam2.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
             }
             textName1.setOnClickListener { Toast.makeText(textName1.context,currentItem.homeTeamName,Toast.LENGTH_LONG).show() }
             textName2.setOnClickListener { Toast.makeText(textName2.context,currentItem.awayTeamName,Toast.LENGTH_LONG).show() }
             iconDelete.setOnClickListener { listener.deleteItemAtIndex(position) }
             root.setOnClickListener{
             listener.onClickItem(currentItem)
             }
     }}
       fun setData(newList:List<Match>){
          list=newList
          notifyDataSetChanged()
       }








    override fun getItemCount(): Int =list.size







    class MatchViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val binding=ItemMatchBinding.bind(itemView)
     
    }
}