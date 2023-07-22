package com.example.workout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.workout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FinishActivity : AppCompatActivity() {

    private var binding : ActivityFinishBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val toolBar = binding?.toolbarFinish
        setSupportActionBar(binding?.toolbarFinish)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolBar?.navigationIcon?.setTint(Color.WHITE)
            toolBar?.setTitleTextColor(Color.WHITE)
        }

        binding?.toolbarFinish?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding?.btnFinish?.setOnClickListener {
            finish()
        }

        val dao = (application as WorkoutApp).db.historyDao()
        addDateToDatabase(dao)


    }

    private fun addDateToDatabase(historyDao: HistoryDao){

        val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("Date","" + dateTime)

        val sdf = SimpleDateFormat("dd MMM yyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("Formatted Date : ", "" + date)

        lifecycleScope.launch {
            historyDao.insert(TheHistoryEntity(date))
            Log.e("Date : ", "Added..")
        }
    }
}