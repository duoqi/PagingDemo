package com.yxtbd.pagingdemo.model.db

import androidx.room.Room
import com.yxtbd.pagingdemo.GloabApplication

/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
class DbManager {

    val mAppDatabase: AppDatabase = Room.databaseBuilder(
        GloabApplication.getContext(),
        AppDatabase::class.java,
        "paging_room_demo.db"
    )
        .allowMainThreadQueries()
        .build()

    companion object {
        fun getInstance() = SingleHolder.mInstance
    }

    object SingleHolder {
        val mInstance = DbManager()
    }
}