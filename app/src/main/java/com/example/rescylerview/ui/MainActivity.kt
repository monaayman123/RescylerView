package com.example.rescylerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable

import android.util.Log
import android.widget.Toast
import com.example.rescylerview.data.Match
import com.example.rescylerview.data.domain.DataManager
import com.example.rescylerview.databinding.ActivityMainBinding
import com.example.rescylerview.util.Constant

import com.example.rescylerview.util.CsvParse
import kotlinx.parcelize.Parcelize
import java.io.BufferedReader
import java.io.InputStreamReader
@Parcelize
        class MainActivity() : AppCompatActivity() ,MatchInteractionListener, Parcelable {
        lateinit var binding: ActivityMainBinding
         lateinit var matchAdapter: MatchAdapter


            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

    }
                fun setup(){
                openfile()
                matchAdapter=MatchAdapter(DataManager.matches,this)
                binding.recycler.adapter=matchAdapter
                binding.fabIcon.setOnClickListener {
                    addFinalMatch()
                }
            }

            private fun addFinalMatch(){
                val finalMatch=Match(
                    homeTeamName = "France",
                    awayTeamName = "Egypt",
                    homeTeamGoals =" 2",
                    awayTeamGoals =" 5",
                    year = "2018",
                    stadium = "Lazhaiki"
                )
                DataManager.addMatchAtIndex(1,finalMatch)
                matchAdapter.setData(DataManager.matches)
            }

    fun openfile(){
        val inputStream=  assets.open("worldcup.csv")
        val bufferR=BufferedReader(InputStreamReader(inputStream))
        val parser=CsvParse()
        bufferR.forEachLine {
            Log.v("m",it)
            val currentmatch=parser.parse(it)
            DataManager.addmatch(currentmatch)
        }

    }

            override fun onClickItem(match:Match) {
           val myIntent=Intent(this,DetailsActivity::class.java)
            myIntent.putExtra(Constant.KEY_MATCH,match)
                startActivity(myIntent)
            }

                override fun onClickTeamName(name: String) {
                Toast.makeText(applicationContext,name,Toast.LENGTH_LONG).show()
            }

            override fun deleteItemAtIndex(index: Int) {
               DataManager.deleteMatch(index)
                matchAdapter.setData(DataManager.matches)
            }


        }



