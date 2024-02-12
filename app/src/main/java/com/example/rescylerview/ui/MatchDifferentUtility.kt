package com.example.rescylerview.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.rescylerview.data.Match

class MatchDifferentUtility(val mOldItem:List<Match>,val mNewItem:List<Match>):DiffUtil.Callback() {
    override fun getOldListSize()=mOldItem.size

    override fun getNewListSize()=mNewItem.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return(
                mOldItem[oldItemPosition].homeTeamName==mNewItem[newItemPosition].homeTeamName
                        &&mOldItem[oldItemPosition].awayTeamName==mNewItem[newItemPosition].awayTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return(mOldItem[oldItemPosition].homeTeamGoals==mNewItem[newItemPosition].awayTeamGoals
               )
    }
}