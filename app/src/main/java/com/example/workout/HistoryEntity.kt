package com.example.workout

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class TheHistoryEntity(
    @PrimaryKey
    val date : String
)