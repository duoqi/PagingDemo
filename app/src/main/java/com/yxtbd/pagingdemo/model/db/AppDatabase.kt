package com.yxtbd.pagingdemo.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yxtbd.pagingdemo.model.bean.Student

/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
@Database(entities = [Student::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao
}