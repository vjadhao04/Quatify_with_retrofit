package com.vj.quatify.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuatesEn(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author: String,
    val text: String
)