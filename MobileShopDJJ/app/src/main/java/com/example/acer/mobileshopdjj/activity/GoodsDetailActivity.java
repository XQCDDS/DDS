package com.example.acer.mobileshopdjj.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsDetailActivity extends BaseActivity {
//    @BindView(R.id.tv_title)
    TextView tvTitle;
    private int goods_id;
    private String goods_name;

    @Override
    public int getContentViewId() { return R.layout.activity_goods_detail; }

    @Override
    protected void initView() {
        super.initView();
        goods_id = getIntent().getIntExtra("goods_id",0);
        tvTitle=findViewById(R.id.tv_title);
        tvTitle.setMaxEms(9);
        tvTitle.setLines(1);
        if (TextUtils.isEmpty(goods_name)){
            tvTitle.setText("商品详情");
        }else {
            tvTitle.setText(goods_name);
        }

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }
//    @OnClick(R.id.iv_back)
    void close(){ finish();}
}
