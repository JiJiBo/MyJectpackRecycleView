package com.rulerbug.myjectpackdemo;

import android.content.Context;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rulerbug.bugutils.Utils.BugApp;
import com.rulerbug.bugutils.Utils.BugLogUtils;

public class RvAdapter {
    @BindingAdapter(value = {"bindJockAdapterData", "bindJockContext"})
    public static void bindAdapter(RecyclerView rv, PagedList<JockBean.ResultBean.DataBean> list, Context mc) {
        BugLogUtils.e(list);
        JockPagedListAdapter adapter = new JockPagedListAdapter();
        rv.setAdapter(adapter);
        adapter.submitList(list);
        rv.setLayoutManager(new LinearLayoutManager(mc));
        rv.addItemDecoration(new DividerItemDecoration(mc, DividerItemDecoration.VERTICAL));
    }
}
