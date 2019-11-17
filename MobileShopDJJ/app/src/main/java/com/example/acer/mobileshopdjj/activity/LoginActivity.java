package com.example.acer.mobileshopdjj.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.acer.mobileshopdjj.R;
import com.example.acer.mobileshopdjj.ProgressDialogSubscriber;
import com.example.acer.mobileshopdjj.common.BaseActivity;
import com.example.acer.mobileshopdjj.http.entity.MemberEntity;
import com.example.acer.mobileshopdjj.http.presenter.MemberPresenter;
import com.example.acer.mobileshopdjj.utils.SystemConfig;


import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private EditText et_username;
    private EditText et_pwd;
    private Button bt_login;
    private ImageView iv_back;

//    @BindView(R.id.et_username)
//    EditText etUsername;
//    @BindView(R.id.et_pwd)
//    EditText etPwd;

    @Override
    public int getContentViewId() { return R.layout.activity_login; }

//    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }

//    @OnClick(R.id.bt_login)
    void login(){
        String userName = et_username.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        if(TextUtils.isEmpty(userName)){
            toastShort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                //保存登录状态
                SystemConfig.setLogin(true);
                //弹出登录成功提示
                toastLong("登录成功");
                //保存登录账户的信息
                SystemConfig.setLoginUserName(memberEntity.uname);
                SystemConfig.setLoginUserEmail(memberEntity.email);
                SystemConfig.setLoginUserHead(memberEntity.image);
                //返回数据，只有调用了setResult，在调用的地方才会回调onActivityResult方法
                setResult(RESULT_OK);
                finish();
            }
        },userName,pwd);

    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        initView();

        et_username =findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);

        bt_login = findViewById(R.id.bt_login);
        iv_back = findViewById(R.id.iv_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

//    private void initView(){
//        findViewById(R.id.iv_back).setOnClickListener(this);
//        findViewById(R.id.bt_login).setOnClickListener(this);
//
//        et_username = findViewById(R.id.et_username);
//        et_pwd = findViewById(R.id.et_pwd);
//        //获取通过Intent传递过来的参数
//        String user_name = getIntent().getStringExtra("user_name");
//        Log.d(TAG,"user_name = "+user_name);
//        et_username.setText(user_name);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.iv_back:
//                close();
//                break;
//            case R.id.bt_login:
//                login();
//                break;
//        }
//    }
}
