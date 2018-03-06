package com.example.leiyang.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
    }

    public void btn_change_listActivity(View view) {
        Intent intent = new Intent(MyListViewActivity.this,ListActivityDemo.class);
        startActivity(intent);

    }

    public void btn_change_listView(View view) {
        Intent intent = new Intent(MyListViewActivity.this,MyListViewDemo.class);
        startActivity(intent);
    }
}
