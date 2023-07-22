package com.example.workout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private var binding : ActivityHistoryBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val toolBar = binding?.toolBarHistory
        setSupportActionBar(binding?.toolBarHistory)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            title = "HISTORY"
            toolBar?.navigationIcon?.setTint(Color.WHITE)
            toolBar?.setTitleTextColor(Color.WHITE)

        }
        binding?.toolBarHistory?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}