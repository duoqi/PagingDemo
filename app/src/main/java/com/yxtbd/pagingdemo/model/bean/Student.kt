package com.yxtbd.pagingdemo.model.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String
)