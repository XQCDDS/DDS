package com.example.acer.mobileshopdjj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.activity.LoginActivity;
import com.example.acer.mobileshopdjj.common.BaseFragment;

public class HomeFragment extends BaseFragment {
    public int getContentViewId() {
        return R.layout.fragment_home;
    }


    private View view;
    private ProgressBar pro1;
    private ToggleButton btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        btn = (ToggleButton) view.findViewById(R.id.button_home1);
        pro1 = (ProgressBar) view.findViewById(R.id.progress_home1);

        return view;
    }

    //实现点击事件
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = btn.isChecked();
                if (checked) {
                    pro1.setVisibility(ProgressBar.GONE);
                } else {
                    pro1.setVisibility(ProgressBar.VISIBLE);
                }
            }
        });
    }
}
