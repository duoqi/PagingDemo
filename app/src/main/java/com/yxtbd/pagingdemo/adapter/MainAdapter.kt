package com.yxtbd.pagingdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yxtbd.pagingdemo.R
import com.yxtbd.pagingdemo.model.bean.Student

/**
 * description ： TODO
 *
 * author : taodq
 * date : 2019-09-04 21:17
 */
class MainAdapter : PagedListAdapter<Student, MainAdapter.MainViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MainViewHolder(layoutInflater.inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val student = getItem(position)
        if (student != null) {
            holder.bind(student)
        } else {
            holder.clear()
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem?.id == newItem?.id
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem == newItem
            }
        }
    }


    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvId = view.findViewById<TextView>(R.id.tv_id)
        private val tvName = view.findViewById<TextView>(R.id.tv_name)

        fun bind(student: Student) {
            tvId.text = student.id.toString()
            tvName.text = student.name
        }

        fun clear() {
            tvName.text = null
            tvId.text = null
        }
    }
}