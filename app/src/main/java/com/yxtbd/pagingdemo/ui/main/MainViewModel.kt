package com.yxtbd.pagingdemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yxtbd.pagingdemo.model.db.DbManager
import com.yxtbd.pagingdemo.model.bean.Student
import java.util.concurrent.Executors

class MainViewModel : ViewModel() {
    private val studentDao by lazy { DbManager.getInstance().mAppDatabase.getStudentDao() }

    init {
        insertData()
    }
    ////传入Room返回的DataSource.Factory
    var liveArray: LiveData<PagedList<Student>> =
        LivePagedListBuilder(
            studentDao.getAllStudents(), PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .setEnablePlaceholders(false)
                .build()
        ).build()

    private fun insertData() {
        val lists = arrayListOf<Student>()
        for (i in 1..100) {
            val student = Student(null, "abc$i")
            lists.add(student)
            Executors.newFixedThreadPool(20).execute { studentDao.insertStudents(student) }
        }

    }

}
