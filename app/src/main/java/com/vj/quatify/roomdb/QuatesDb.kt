package com.vj.quatify.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vj.quatify.Quates

@Database(entities = [QuatesEn::class], version = 1)
abstract class QuatesDb : RoomDatabase() {
    abstract fun getDao(): QuatesDao

    companion object {
        @Volatile
        private var instance: QuatesDb? = null


        fun getdatabase(context: Context): QuatesDb {
            if (instance != null) {
                return instance!!
            } else {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuatesDb::class.java, "Quatesdatabase"
                    ).build()
                    return instance!!
                }
            }

        }

    }
}