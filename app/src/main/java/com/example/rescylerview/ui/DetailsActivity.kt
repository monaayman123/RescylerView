package com.example.rescylerview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rescylerview.R
import com.example.rescylerview.data.Match
import com.example.rescylerview.databinding.ActivityDetailsBinding
import com.example.rescylerview.util.Constant

class DetailsActivity: AppCompatActivity() {
   lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()

    }

    fun setUp(){
        val  match:Match?=intent.getSerializableExtra(Constant.KEY_MATCH) as Match
        match?.let {
            bindMatch(it)
        }
    }

    private fun bindMatch(match: Match) {
      binding.apply {
          textName1.text=match.homeTeamName
          textName2.text=match.awayTeamName
          textStedioum.text=match.stadium
          textYear.text=match.year
          scoreTeam1.text=match.homeTeamGoals
          scoreTeam2.text=match.awayTeamGoals
      }
    }
}