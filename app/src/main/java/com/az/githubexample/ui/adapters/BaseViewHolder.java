package com.az.githubexample.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder<T1 extends View> extends RecyclerView.ViewHolder {

    private T1 mItemView;

    public BaseViewHolder(T1 itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

    public T1 getView() {
        return mItemView;
    }

    public void setView(T1 view) {
        mItemView = view;
    }
}