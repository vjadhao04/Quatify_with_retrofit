package com.vj.quatify.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vj.quatify.Quates

@Dao
interface QuatesDao {

    @Insert
    suspend fun insertQuates(quatesEn: QuatesEn)

    @Insert
    suspend fun insertAllQuates(lq:Array<QuatesEn>)

    @Delete
    suspend fun deleteQuates(quatesEn: QuatesEn)

    @Update
    suspend fun updateQuates(quatesEn: QuatesEn)

    @Query("SELECT * FROM QuatesEn")
    fun selectAll():LiveData<List<QuatesEn>>

}