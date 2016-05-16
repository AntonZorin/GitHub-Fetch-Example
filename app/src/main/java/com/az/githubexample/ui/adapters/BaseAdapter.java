package com.az.githubexample.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.az.githubexample.interfaces.ViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */

public abstract class BaseAdapter<T1, T2 extends View & ViewModel, T3 extends BaseViewHolder<T2>>
        extends RecyclerView.Adapter<T3> {

    protected List<T1> mContent = new ArrayList<>();

    @Override
    public abstract T3 onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(T3 holder, int position) {
        T2 view = holder.getView();
        view.setData(mContent.get(position));
    }

    public T1 getModel(int position) {
        return mContent.get(position);
    }

    public void addData(T1 data) {
        mContent.add(data);
        notifyItemInserted(mContent.size() - 1);
    }

    public List<T1> getData() {
        return mContent;
    }

    public void setData(List<T1> data) {
        if (data != null) {
            mContent = data;
            notifyDataSetChanged();
        }
    }

    public T1 getData(int position) {
        return mContent.get(position);
    }

    public void insertDataToStart(T1 data) {
        mContent.add(0, data);
        notifyItemInserted(0);
    }

    public void addData(List<T1> data) {
        mContent.addAll(data);
        notifyItemRangeInserted(mContent.size() - 1 - data.size(), data.size());
    }

    public void removeData(int position) {
        if (getItemCount() > position) {
            mContent.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mContent.size() + 1);
        }
    }

    @Override
    public int getItemCount() {
        return (mContent == null) ? 0 : mContent.size();
    }
}