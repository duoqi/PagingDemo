package com.yxtbd.pagingdemo

import android.app.Application
import android.content.Context


/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
class GloabApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object {
        private lateinit var mContext: Context
        fun getContext(): Context {
            return mContext
        }
    }
}