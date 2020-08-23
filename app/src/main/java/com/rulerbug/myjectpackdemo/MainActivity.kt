package com.rulerbug.myjectpackdemo

import android.database.DatabaseUtils
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.paging.PagedList
import com.rulerbug.myjectpackdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val jvm = ViewModelProvider(this).get(JockViewModel::class.java)
        binding.mc = this
        binding.data = jvm.list.value
        jvm.list.observe(this, object : Observer<PagedList<JockBean.ResultBean.DataBean>> {
            override fun onChanged(t: PagedList<JockBean.ResultBean.DataBean>?) {
                if (binding.rv.adapter != null) {
                    (binding.rv.adapter as JockPagedListAdapter).submitList(t!!)
                }
            }

        })
    }
}