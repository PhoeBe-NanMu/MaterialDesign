package com.example.leiyang.materialdesign;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 24436 on 2018/2/9.
 */

public class ListActivityDemo extends ListActivity {


    private String[] persidents = {"北京","重庆","武汉","长沙","杭州","上海"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();

        TextView headerTextView = new TextView(this);
        headerTextView.setText("城市列表头");
        listView.addHeaderView(headerTextView);

        TextView footerTextView = new TextView(this);
        footerTextView.setText("城市列表尾");
        listView.addFooterView(footerTextView);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,persidents));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (!(position == 0 || position ==persidents.length+1)){
            Toast.makeText(this, "你选择了： " + persidents[position-1], Toast.LENGTH_SHORT).show();
        }
    }
}
