package com.example.rescylerview.data.domain

  import com.example.rescylerview.data.Match

object DataManager {
      private val matchList= mutableListOf<Match>()
      private var matchIndex=1
      val matches:List<Match>
          get() = matchList.reversed()
    fun deleteMatch(index:Int){
        matchList.removeAt(index)
    }


    fun addMatch(match: Match){
     matchList.add(match)
    }
    fun getNextMatch():Match{
       matchIndex++
     if(matchIndex==matchList.size){
         matchIndex=1
     }
      return matchList[matchIndex]
    }
    fun getPreviusMatch():Match{
      matchIndex--
        if(matchIndex==-1){
            matchIndex=matchList.size-1
        }
      return  matchList[matchIndex]
    }
    fun getCurrentMatch():Match=matchList[matchIndex]
    fun addmatch(match: Match){
        matchList.add(match)
    }
}
