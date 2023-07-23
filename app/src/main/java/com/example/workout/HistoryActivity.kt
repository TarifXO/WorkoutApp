package com.example.workout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.workout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

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

        val dao = (application as WorkoutApp).db.historyDao()
        getAllCompletedDates(dao)

    }

    private fun getAllCompletedDates(historyDao: HistoryDao){
        lifecycleScope.launch {
            historyDao.fetchAllDates().collect{ allCompletedDates ->
                for (i in allCompletedDates){
                    Log.e("Date: ", "" +i)
            }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}