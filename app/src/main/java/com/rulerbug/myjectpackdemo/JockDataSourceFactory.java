package com.rulerbug.myjectpackdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class JockDataSourceFactory extends DataSource.Factory<Integer, JockBean.ResultBean.DataBean> {
//    private MutableLiveData<JockDataSourse> list =new MutableLiveData<>();


    @Override
    public DataSource<Integer, JockBean.ResultBean.DataBean> create() {
        JockDataSourse dataSource = new JockDataSourse();
//        list.postValue(dataSource);
        return dataSource;
    }
}
