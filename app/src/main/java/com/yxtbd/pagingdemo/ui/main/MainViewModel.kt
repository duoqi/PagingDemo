package com.yxtbd.pagingdemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yxtbd.pagingdemo.model.bean.Student
import com.yxtbd.pagingdemo.model.bean.User
import com.yxtbd.pagingdemo.model.db.AppDatabase
import java.util.concurrent.Executors

class MainViewModel : ViewModel() {
    private val studentDao by lazy { AppDatabase.get().getStudentDao() }
    private val userDao by lazy { AppDatabase.get().getUserDao() }

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
        for (i in 1..100) {
            val student = Student(null, "abc$i")
            Executors.newSingleThreadExecutor().execute { studentDao.insertStudents(student) }

            val user = User(null, "user$i")
            Executors.newSingleThreadExecutor().execute { userDao.insertUsers(user) }
        }

    }

    fun getUsers(): List<User> {
        return userDao.getAllUsers()
    }

}
