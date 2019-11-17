package com.example.acer.mobileshopdjj.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.activity.ChangePwdActivity;
import com.example.acer.mobileshopdjj.activity.LoginActivity;
import com.example.acer.mobileshopdjj.activity.MyAddressActivity;
import com.example.acer.mobileshopdjj.activity.MyCollectActivity;
import com.example.acer.mobileshopdjj.activity.MyOrderActivity;
import com.example.acer.mobileshopdjj.common.BaseFragment;
import com.example.acer.mobileshopdjj.utils.SystemConfig;
import com.nostra13.universalimageloader.core.ImageLoader;

public class PersonalFragment extends BaseFragment {
    @Override
    public int getContentViewId() { return R.layout.fragment_personal; }

//    //已登录
//    @BindView(R.id.personal_for_login)
//    RelativeLayout personal_for_login;
//    @BindView(R.id.user_img_view)
//    ImageView user_img_view;
//    @BindView(R.id.user_name)
//    TextView user_name;
//    @BindView(R.id.user_level)
//    TextView user_level;
//
//    //未登录
//    @BindView(R.id.personal_for_not_login)
//    RelativeLayout personal_for_not_login;
//
//    //退出登录
//    @BindView(R.id.person_logout_layout)
//    RelativeLayout person_logout_layout;

    @Override
    protected void initView(View view) {
        super.initView(view);

        //初始状态配置
        resetUI();
    }

    private void resetUI(){
        if (SystemConfig.isLogin()){
            //已登录，显示已登录的UI,隐藏未登录的UI
            personal_for_login.setVisibility(View.VISIBLE);
            personal_for_not_login.setVisibility(View.GONE);
            person_logout_layout.setVisibility(View.VISIBLE);

            //显示已登录的信息
            //显示头像
            ImageLoader.getInstance().displayImage(SystemConfig.getLoginUserHead(),user_img_view);
            //显示用户名
            user_name.setText(SystemConfig.getLoginUserName());
            //显示邮箱
            user_level.setText(SystemConfig.getLoginUserEmail());
        }else{
            //未登录，显示未登录的UI，隐藏已登录的UI
            personal_for_login.setVisibility(View.GONE);
            personal_for_not_login.setVisibility(View.VISIBLE);
            person_logout_layout.setVisibility(View.GONE);
        }
    }

//    @OnClick(R.id.personal_login)
//    void login(){
//        Intent intent = new Intent(getActivity(),LoginActivity.class);
//        startActivityForResult(intent,1000);
//    }
//
//    @OnClick(R.id.person_my_order)
//    void person_my_order() {
//        //我的订单
//        if (SystemConfig.isLogin()) {
//            startActivity(new Intent(getActivity(), MyOrderActivity.class));
//        } else {
//            Intent intent = new Intent(getActivity(), LoginActivity.class);
//            startActivityForResult(intent, 1001);
//        }
//    }
//
//    @OnClick(R.id.my_collect)
//    void my_collect(){
//         //我的收藏
//         if(SystemConfig.isLogin()){
//             startActivity(new Intent(getActivity(),MyCollectActivity.class));
//         }else{
//             Intent intent = new Intent(getActivity(),LoginActivity.class);
//             startActivityForResult(intent,1002);
//         }
//    }
//
//    @OnClick(R.id.my_address)
//    void my_address(){
//        //我的地址
//        if(SystemConfig.isLogin()){
//            startActivity(new Intent(getActivity(),MyAddressActivity.class));
//        }else{
//            Intent intent = new Intent(getActivity(),LoginActivity.class);
//            startActivityForResult(intent,1003);
//        }
//    }
//
//    @OnClick(R.id.my_account)
//    void my_account(){
//        //修改密码
//        if(SystemConfig.isLogin()){
//            startActivity(new Intent(getActivity(),ChangePwdActivity.class));
//        }else{
//            Intent intent = new Intent(getActivity(),LoginActivity.class);
//            startActivityForResult(intent,1004);
//        }
//    }
//
//    @OnClick(R.id.person_logout_layout)
//    void logout(){
//        //退出登录
//        SystemConfig.logout();
//        resetUI();
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            //重置UI
            resetUI();

            //打开登录之前想要进入的页面
            Intent intent = new Intent();
            if (requestCode == 1000){

            }else if (requestCode == 1001){
                intent.setClass(getActivity(),MyOrderActivity.class);
                startActivity(intent);
            }else if (requestCode == 1002){
                intent.setClass(getActivity(),MyCollectActivity.class);
                startActivity(intent);
            }else if (requestCode == 1003){
                intent.setClass(getActivity(),MyAddressActivity.class);
                startActivity(intent);
            }else if (requestCode == 1004){
                intent.setClass(getActivity(),ChangePwdActivity.class);
                startActivity(intent);
            }
        }
    }


    private View view;
    private Button btn;

    RelativeLayout personal_for_login;
    ImageView user_img_view;
    TextView user_name;
    TextView user_level;
    RelativeLayout personal_for_not_login;
    RelativeLayout person_logout_layout;

    Button personal_login;
    RelativeLayout my_order;
    RelativeLayout my_collect;
    RelativeLayout my_address;
    RelativeLayout my_account;
    TextView my_account_text1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal, null);
//        btn = (Button) view.findViewById(R.id.personal_login);

        personal_for_login=(RelativeLayout)view.findViewById(R.id.personal_for_login);
        user_img_view=(ImageView)view.findViewById(R.id.user_img_view);
        user_name=(TextView)view.findViewById(R.id.user_name);
        user_level=(TextView)view.findViewById(R.id.user_level);
        personal_for_not_login=(RelativeLayout)view.findViewById(R.id.personal_for_not_login);
        person_logout_layout=(RelativeLayout)view.findViewById(R.id.person_logout_layout);

        //找到PersonalFragment上的控件
        personal_login=(Button)view.findViewById(R.id.personal_login);
        my_order=(RelativeLayout)view.findViewById(R.id.person_my_order);
        my_collect=(RelativeLayout)view.findViewById(R.id.my_collect);
        my_address=(RelativeLayout) view.findViewById(R.id.my_address);
        my_account=(RelativeLayout) view.findViewById(R.id.my_account);
        my_account_text1=(TextView)view.findViewById(R.id.my_account_text1);


        //初始状态配置
        resetUI();

        //return view2=inflater.inflate(R.layout.fragment1, null);// 错误的写法
        return view;
    }

    //实现点击事件
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),LoginActivity.class);
//                intent.putExtra("user_name","DJJ5308");
//                startActivity(intent);
//            }
//        });
        personal_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_LONG);
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,1000);
            }
        });
        my_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"订单",Toast.LENGTH_LONG);
                //我的订单
                if (SystemConfig.isLogin()) {
                    startActivity(new Intent(getActivity(), MyOrderActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1001);
                }
            }
        });
        my_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"收藏",Toast.LENGTH_LONG);
                //我的收藏
                if(SystemConfig.isLogin()){
                    startActivity(new Intent(getActivity(),MyCollectActivity.class));
                }else{
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,1002);
                }
            }
        });
        my_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"地址",Toast.LENGTH_LONG);
                //我的地址
                if(SystemConfig.isLogin()){
                    startActivity(new Intent(getActivity(),MyAddressActivity.class));
                }else{
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,1003);
                }
            }
        });
        my_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"密码",Toast.LENGTH_LONG);
                //修改密码
                if(SystemConfig.isLogin()){
                    startActivity(new Intent(getActivity(),ChangePwdActivity.class));
                }else{
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,1004);
                }
            }
        });
        my_account_text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //退出登录
                SystemConfig.logout();
                resetUI();
            }
        });
    }
}
