package com.example.rescylerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rescylerview.data.domain.DataManager
import com.example.rescylerview.databinding.ActivityMainBinding
import com.example.rescylerview.util.CsvParse
import java.io.BufferedReader
import java.io.InputStreamReader

        class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

    }
                fun setup(){
                openfile()
                val matchAdapter=MatchAdapter(DataManager.matches)
                binding.recycler.adapter=matchAdapter

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

}