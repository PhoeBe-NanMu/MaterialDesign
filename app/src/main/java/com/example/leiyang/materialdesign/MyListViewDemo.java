package com.example.leiyang.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListViewDemo extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_demo);

        listView = findViewById(R.id.lv_demo);

        initData();

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MyListViewDemo.this, dataList.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {

        dataList = new ArrayList<String>();
        dataList.add("香蕉");
        dataList.add("苹果");
        dataList.add("栗子");
        dataList.add("西瓜");
        dataList.add("好吃的西瓜");
        dataList.add("熟西瓜");
        dataList.add("甜西瓜");
        dataList.add("小西瓜");
        dataList.add("大西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");
        dataList.add("西瓜");

    }
}
