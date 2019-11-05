package com.yxtbd.pagingdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yxtbd.pagingdemo.R
import com.yxtbd.pagingdemo.adapter.MainAdapter
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    private val TAG = "MainFragment"

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val mAdapter = MainAdapter()
        viewModel.liveArray.observe(this, Observer {
            mAdapter.submitList(it)
        })
        recycler.adapter = mAdapter

        Log.e(TAG, viewModel.getUsers().toString())
    }

}
