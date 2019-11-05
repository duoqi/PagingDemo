package com.yxtbd.pagingdemo.model.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yxtbd.pagingdemo.model.bean.Student


/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
@Dao
interface StudentDao {

    @Query("select * from student order by id")
    fun getAllStudents(): DataSource.Factory<Int, Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudents(vararg studends: Student)
}