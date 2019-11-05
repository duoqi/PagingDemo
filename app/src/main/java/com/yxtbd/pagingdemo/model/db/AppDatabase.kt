package com.yxtbd.pagingdemo.model.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yxtbd.pagingdemo.GloabApplication
import com.yxtbd.pagingdemo.model.bean.Student
import com.yxtbd.pagingdemo.model.bean.User

/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
@Database(entities = [Student::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao
    abstract fun getUserDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun get(): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    GloabApplication.getContext(),
                    AppDatabase::class.java, "paging_room_demo.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

    }
}