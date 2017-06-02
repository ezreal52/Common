package com.example.kshclf1.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kshclf1.myapplication.R;
import com.example.kshclf1.myapplication.adapter.ArticleAdapter;
import com.example.kshclf1.myapplication.bean.OneType;
import com.example.kshclf1.myapplication.common.Constant;
import com.example.kshclf1.myapplication.http.BaseCallBack;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class MainFragment extends Fragment{

    private static final String TAG = "MainFragment";
    private SuperRecyclerView recyclerView;
    private int currentPage = 0;
    private List<OneType.DatasBean.ClassListBean> dataList = new ArrayList<>();
    private ArticleAdapter articleAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"MainFragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (SuperRecyclerView) view.findViewById(R.id.superRecyclerView);

        configListView();

        articleAdapter = new ArticleAdapter(getActivity(),dataList);

        recyclerView.setAdapter(articleAdapter);

        loadData(Constant.LIST_ACTION.REFRESH,1);

        return view;
    }
    /**
     * 配置SuperRecyclerView
     */
    private void configListView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setRefreshEnabled(true);// 可以定制是否开启下拉刷新
        recyclerView.setLoadMoreEnabled(true);// 可以定制是否开启加载更多
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);// 下拉刷新的样式
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);// 上拉加载的样式
        recyclerView.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                loadData(Constant.LIST_ACTION.REFRESH,1);
            }

            @Override
            public void onLoadMore() {
                loadData(Constant.LIST_ACTION.LOAD_MORE,currentPage+1);
            }
        });// 下拉刷新，上拉加载的监听

    }

    /**
     * 加载数据
     */
    private void loadData(final Constant.LIST_ACTION action, final int page) {
        OkHttpUtils.post()
                    .url(Constant.CLASSIFY_URL)
                    .build()
                    .execute(new BaseCallBack<OneType>(OneType.class) {

                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.d(TAG,"onError");
                        }

                        @Override
                        public void onResponse(OneType response, int id) {
                            recyclerView.completeRefresh();
                            recyclerView.completeLoadMore();
                            if(response.getCode() == 200){
                                List<OneType.DatasBean.ClassListBean> listBean = response.getDatas().getClass_list();
                                Log.d(TAG,"onResponse--"+listBean.size());
                                Log.d(TAG,"onResponse--"+listBean.get(0).getGc_name());
                                switch (action) {
                                    case REFRESH:   //下拉刷新
                                        dataList.clear();
                                        if (listBean==null||listBean.size()==0) {
                                            currentPage = 0;
                                        } else {
                                            dataList.addAll(listBean);
                                        }
                                        articleAdapter.notifyDataSetChanged();
                                        break;
                                    case LOAD_MORE: //上拉加载

                                        if (page < 5) {
                                            dataList.addAll(listBean);
                                        } else {
                                            recyclerView.setNoMore(true);
                                        }
                                        articleAdapter.notifyDataSetChanged();
                                        break;
                                }

                            }

                        }
                    });
    }


}
