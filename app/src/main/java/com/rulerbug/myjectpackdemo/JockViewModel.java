package com.rulerbug.myjectpackdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class JockViewModel extends ViewModel {
    public LiveData<PagedList<JockBean.ResultBean.DataBean>> list;

    public JockViewModel( ) {

        PagedList.Config build = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(JockDataSourse.pagesize)
                .setInitialLoadSizeHint(JockDataSourse.pagesize * 4)
                .setPrefetchDistance(3)
                .build();
        list = (new LivePagedListBuilder<Integer, JockBean.ResultBean.DataBean>
                (new JockDataSourceFactory(), build))
                .build();
    }

}
