package lee.com.teachingsystemapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appple on 2017/5/6.
 */

public abstract class TSABaseAdapter <T> extends BaseAdapter {
    protected Activity mContext;
    protected LayoutInflater mLayoutInflater;

    public TSABaseAdapter(Activity context) {
        mContext = context;
        String serviceName = Context.LAYOUT_INFLATER_SERVICE;
        Object service = mContext.getSystemService(serviceName);
        mLayoutInflater = (LayoutInflater) service;

    }

    protected ArrayList<T> mData;

    public ArrayList<T> getmData() {
        return mData;
    }

    public void setData(List<T> data) {
        if (mData == null)
            mData = new ArrayList<>();
        mData.clear();
        if (data != null)
            mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        if (mData == null)
            mData = new ArrayList<>();
        if (data != null)
            mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(T data) {
        if (mData == null)
            mData = new ArrayList<>();
        if (data != null)
            mData.add(data);
        notifyDataSetChanged();
    }

    protected View.OnClickListener mOnClickListener;

    public void setOnClickListener(View.OnClickListener l) {
        mOnClickListener = l;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        if(mData!=null&&mData.size()>position){
            return mData.get(position);
        }else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}

