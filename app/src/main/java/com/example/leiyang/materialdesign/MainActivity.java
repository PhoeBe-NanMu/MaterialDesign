package com.example.leiyang.materialdesign;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btn_show(View view) {
        Snackbar.make(view, "标题", Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Snackbar", Toast.LENGTH_SHORT).show();
            }
        }).setDuration(Snackbar.LENGTH_LONG).show();
    }

    public void btn_login(View view) {

        editTextUsername = findViewById(R.id.et_username);
        editTextPassword = findViewById(R.id.et_password);
        textInputLayoutUsername = findViewById(R.id.tl_username);
        textInputLayoutPassword = findViewById(R.id.tl_password);
        String editTextPasswordString = editTextPassword.getText().toString();
        String editTextUsernameString = editTextUsername.getText().toString();
        if (!isValidUsername(editTextUsernameString)){
            textInputLayoutUsername.setErrorEnabled(true);
            textInputLayoutUsername.setError("请输入正确的邮箱地址");
        } else if (!isValidPassword(editTextPasswordString)){
            textInputLayoutPassword.setErrorEnabled(true);
            textInputLayoutPassword.setError("密码长度至少为6位");
        } else {
            textInputLayoutUsername.setErrorEnabled(false);
            textInputLayoutPassword.setErrorEnabled(false);
            Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
        }

    }

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public boolean isValidUsername(String editTextUsernameString){
        Matcher matcher = pattern.matcher(editTextUsernameString);
        return  matcher.matches();
    }

    public boolean isValidPassword(String editTextPasswordString){
        return editTextPasswordString.length() > 6;
    }
}
