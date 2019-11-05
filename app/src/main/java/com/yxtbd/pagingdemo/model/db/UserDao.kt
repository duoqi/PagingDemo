package com.yxtbd.pagingdemo.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yxtbd.pagingdemo.model.bean.User


/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
@Dao
interface UserDao {

    @Query("select * from user order by id desc")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)
}