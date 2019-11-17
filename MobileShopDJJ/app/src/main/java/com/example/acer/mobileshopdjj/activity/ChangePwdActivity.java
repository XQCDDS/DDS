package com.example.acer.mobileshopdjj.activity;

import android.view.View;
import android.widget.TextView;

import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.common.BaseActivity;


import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity {

//    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId() { return R.layout.activity_change_pwd; }

    @Override
    protected void initView() {
        super.initView();
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("修改密码");

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
