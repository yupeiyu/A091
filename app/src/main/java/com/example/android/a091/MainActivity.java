package com.example.android.a091;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ImageButton fab; //floating action Button 按下去有反應 浮動按鈕
    Context context;//紀錄this
    String[][] exs={
            {"A091(FAB)","MainActivity/ExamplesAdapter/ExamplesInfo","activity_main/example"},
            {"A081(CardView/RecyclerView)", "MainActivity/ExamplesAdapter/ExamplesInfo", "activity_main/examples_list"},
            {"A071(dialog)", "MainActivity", "activity_main"},
            {"A062(login)", "MainActivity", "activity_main"},
            {"A061(toggle/QuickContactBadage)", "MainActivity", "activity_main"},
            {"A051(Intent)", "MainActivity/NextActivity", "activity_main/activity_next"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        context=this;

        //
        lv=(ListView)findViewById(R.id.listView);

        //listView Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){//把資料轉進來 用Adapter
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,exs[position][0],Toast.LENGTH_LONG).show();
                //MainActivity.this = 要的那個this
                //用toast show資料

            }
        });

        //ImageButton
        fab=(ImageButton)findViewById(R.id.imageButton);

        final ArrayList<String> list=new ArrayList<>();
        final ExamplesAdapter aa=new ExamplesAdapter(this, list);

        //listener
        fab.setOnClickListener(new View.OnClickListener() {
            int a=0;
            @Override
            public void onClick(View v) {
               list.add(exs[a][0]);
                a++; //每+1次 往下走
                if (a>=exs.length) {
                    a=0;
                }
                aa.notifyDataSetChanged();//通知資料被改變, 上面要final 不讓下一代繼承
            }
        });
        lv.setAdapter(aa);
    }
}
