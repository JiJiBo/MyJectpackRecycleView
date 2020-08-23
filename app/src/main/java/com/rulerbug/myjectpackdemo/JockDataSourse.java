package com.rulerbug.myjectpackdemo;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.rulerbug.bugutils.Domain.BugOkHttpDataList;
import com.rulerbug.bugutils.Utils.BugLogUtils;
import com.rulerbug.bugutils.Utils.BugOkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class JockDataSourse extends PageKeyedDataSource<Integer, JockBean.ResultBean.DataBean> {
    public static int pagesize = 10;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, JockBean.ResultBean.DataBean> callback) {

        int page = 1;
        BugOkHttpUtils.postHttp(Whole.url, BugOkHttpUtils.getFormBody(
                new BugOkHttpDataList()
                        .add("key", Whole.key)
                        .add("page", page+"")
                        .add("pagesize", pagesize + "")
                        .add("sort", "desc")
                        .add("time", (System.currentTimeMillis() + "").substring(0, 10))
        ), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String string = response.body().string();

                    JockBean bean = new Gson().fromJson(string, JockBean.class);
                    if (bean.getError_code() == 0) {
                        callback.onResult(bean.getResult().getData(), null, page + 1);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, JockBean.ResultBean.DataBean> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, JockBean.ResultBean.DataBean> callback) {

BugLogUtils.e(params.key+"页");
        BugOkHttpUtils.postHttp(Whole.url, BugOkHttpUtils.getFormBody(
                new BugOkHttpDataList()
                        .add("key", Whole.key)
                        .add("page", params.key + "")
                        .add("pagesize", pagesize + "")
                        .add("sort", "desc")
                        .add("time", (System.currentTimeMillis() + "").substring(0, 10))
        ), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String string = response.body().string();

                    JockBean bean = new Gson().fromJson(string, JockBean.class);
                    if (bean.getError_code() == 0) {
                        callback.onResult(bean.getResult().getData(), params.key + 1);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
