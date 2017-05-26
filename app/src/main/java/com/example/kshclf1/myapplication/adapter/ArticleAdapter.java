package com.example.kshclf1.myapplication.adapter;

import android.content.Context;

import com.example.kshclf1.myapplication.R;
import com.example.kshclf1.myapplication.bean.OneType;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;


/**
 * Created by kshclf1 on 2017/5/8.
 */

public class ArticleAdapter extends SuperBaseAdapter<OneType.DatasBean.ClassListBean> {


    public ArticleAdapter(Context context, List<OneType.DatasBean.ClassListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, OneType.DatasBean.ClassListBean item, int position) {
        holder.setText(R.id.tv_text,item.getGc_name());
    }

    @Override
    protected int getItemViewLayoutId(int position, OneType.DatasBean.ClassListBean item) {
        return R.layout.item_article;
    }
}
