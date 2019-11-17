package com.example.acer.mobileshopdjj.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.acer.mobileshopdjj.ProgressDialogSubscriber;
import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.activity.GoodsListActivity;
import com.example.acer.mobileshopdjj.adapter.CategoryLeftAdapter;
import com.example.acer.mobileshopdjj.adapter.CategoryRightAdapter;
import com.example.acer.mobileshopdjj.common.BaseFragment;
import com.example.acer.mobileshopdjj.http.entity.CategoryEntity;
import com.example.acer.mobileshopdjj.http.entity.GoodsEntity;


import com.example.acer.mobileshopdjj.ProgressDialogSubscriber;
import com.example.acer.mobileshopdjj.http.presenter.CategoryPresenter;
import com.example.acer.mobileshopdjj.http.presenter.GoodsPresenter;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends BaseFragment {
    @Override
    public int getContentViewId(){return R.layout.fragment_category;}

//    @BindView(R.id.rv_left)
    RecyclerView rv_left;
//    @BindView(R.id.rv_right)
    RecyclerView rv_right;
    LinearLayout ll_search;

    private List<CategoryEntity> leftData;
    private List<CategoryEntity> rightData;
    private CategoryLeftAdapter leftAdapter;
    private CategoryRightAdapter rightAdapter;

//    @OnClick(R.id.ll_search)
    void search(){ toastLong("开发中");}

    @Override
    protected void initData() {
        super.initData();

        //获取一级列表
        CategoryPresenter.getTopList(new ProgressDialogSubscriber<List<CategoryEntity>>(getActivity()){
            @Override
            public void onNext(List<CategoryEntity> categoryEntities) {
                leftData.clear();
                leftData.addAll(categoryEntities);
                //刷新列表
                leftAdapter.notifyDataSetChanged();
                //左边选中的位置 刷新UI
                leftAdapter.setSelect(0);
                //加载二级列表
                loadSecondList(0);
            }
        });
    }

    private void loadSecondList(int pos){
        if (leftData==null||leftData.size()==0){
            return;
        }

        CategoryEntity entity = leftData.get(pos);
        CategoryPresenter.getSecondList(new ProgressDialogSubscriber<List<CategoryEntity>>(getActivity()){
            @Override
            public void onNext(List<CategoryEntity> categoryEntities) {
                rightData.clear();
                rightData.addAll(categoryEntities);
                rightAdapter.notifyDataSetChanged();
            }
        }, entity.getCat_id());
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        leftData=new ArrayList<>();
        rightData=new ArrayList<>();

        rv_left=(RecyclerView)view.findViewById(R.id.rv_left);
        rv_right=(RecyclerView)view.findViewById(R.id.rv_right);
        ll_search=(LinearLayout)view.findViewById(R.id.ll_search);

        //设置列表样式
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftManager.setOrientation(OrientationHelper.VERTICAL);
        rv_left.setLayoutManager(leftManager);

        //垂直表格
        GridLayoutManager rightManager = new GridLayoutManager(getActivity(),3,OrientationHelper.VERTICAL,false);
        rv_right.setLayoutManager(rightManager);

        leftAdapter = new CategoryLeftAdapter(getActivity(),leftData);
        leftAdapter.setOnItemClickListener(new CategoryLeftAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, CategoryEntity entity) {
                //左边选中的位置 刷新UI
                leftAdapter.setSelect(position);
                //加载二级列表
                loadSecondList(position);
            }
        });
        rightAdapter = new CategoryRightAdapter(getActivity(),rightData);
        rightAdapter.setOnItemClickListener(new CategoryRightAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, CategoryEntity entity) {
                //跳转到商品列表界面
                Intent intent = new Intent(getActivity(),GoodsListActivity.class);
                intent.putExtra("cat_id",entity.getCat_id());
                startActivity(intent);
            }
        });

        rv_left.setAdapter(leftAdapter);
        rv_right.setAdapter(rightAdapter);
    }

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, null);
        initView(view);
        initData();
        //return view2=inflater.inflate(R.layout.fragment1, null);// 错误的写法
        return view;
    }

    //实现点击事件
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                search();
            }
        });
    }
}

