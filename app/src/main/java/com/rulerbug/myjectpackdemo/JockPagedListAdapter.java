package com.rulerbug.myjectpackdemo;

import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rulerbug.myjectpackdemo.databinding.ItemJockBinding;

public class JockPagedListAdapter extends PagedListAdapter<JockBean.ResultBean.DataBean, JockPagedListAdapter.JockViewHolder> {


    private static DiffUtil.ItemCallback<JockBean.ResultBean.DataBean> diffCallback = new DiffUtil.ItemCallback<JockBean.ResultBean.DataBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull JockBean.ResultBean.DataBean oldItem, @NonNull JockBean.ResultBean.DataBean newItem) {
            return oldItem.getHashId().equals(oldItem.getHashId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull JockBean.ResultBean.DataBean oldItem, @NonNull JockBean.ResultBean.DataBean newItem) {
            return oldItem.getHashId().equals(oldItem.getHashId());
        }
    };

    public JockPagedListAdapter( ) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public JockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemJockBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_jock, parent, false, null);
        return new JockViewHolder(inflate.getRoot());
    }


    @Override
    public void onBindViewHolder(@NonNull JockViewHolder holder, int position) {
        JockBean.ResultBean.DataBean item = getItem(position);
        if (item != null) {
            ItemJockBinding bind = DataBindingUtil.bind(holder.itemView);
            bind.setJockBean(item);
            bind.executePendingBindings();
        }
    }


    public class JockViewHolder extends RecyclerView.ViewHolder {

        public JockViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
