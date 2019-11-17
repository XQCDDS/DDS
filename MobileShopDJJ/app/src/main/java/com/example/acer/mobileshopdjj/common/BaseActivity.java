package com.example.acer.mobileshopdjj.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initView();
        initData();
    }

    protected void initData(){
    }

    protected void initView(){
    }

    public abstract int getContentViewId();

    public void toastShort(String msg){Toast.makeText(this,msg,Toast.LENGTH_SHORT).show(); }

    public void toastLong(String msg){Toast.makeText(this,msg,Toast.LENGTH_LONG).show();}
}
