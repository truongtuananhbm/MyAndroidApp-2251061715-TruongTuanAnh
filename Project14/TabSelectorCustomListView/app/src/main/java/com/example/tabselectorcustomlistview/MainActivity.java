package com.example.tabselectorcustomlistview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import com.example.tabselectorcustomlistview.Item;
import com.example.tabselectorcustomlistview.myarrayAdapter;



public class MainActivity extends AppCompatActivity {
    ListView lv1, lv2, lv3;
    ArrayList<Item> list1, list2, list3;
    myarrayAdapter myarray1, myarray2, myarray3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addControl() {
        TabHost tab = findViewById(R.id.tabhost);
        tab.setup();

        TabHost.TabSpec tab1 = tab.newTabSpec("t1");
        tab1.setContent(R.id.lv1);
        tab1.setIndicator("Tab 1", getResources().getDrawable(R.drawable.search));
        tab.addTab(tab1);

        TabHost.TabSpec tab2 = tab.newTabSpec("t2");
        tab2.setContent(R.id.lv2);
        tab2.setIndicator("Tab 2", getResources().getDrawable(R.drawable.list));
        tab.addTab(tab2);

        TabHost.TabSpec tab3 = tab.newTabSpec("t3");
        tab3.setContent(R.id.lv3);
        tab3.setIndicator("Tab 3", getResources().getDrawable(R.drawable.favourite));
        tab.addTab(tab3);

        lv1 = findViewById(R.id.lv1);
        lv2 = findViewById(R.id.lv2);
        lv3 = findViewById(R.id.lv3);

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        myarray1 = new myarrayAdapter(this, R.layout.listitem, list1);
        myarray2 = new myarrayAdapter(this, R.layout.listitem, list2);
        myarray3 = new myarrayAdapter(this, R.layout.listitem, list3);

        lv1.setAdapter(myarray1);
        lv2.setAdapter(myarray2);
        lv3.setAdapter(myarray3);
    }

    private void addEvent() {
        TabHost tab = findViewById(R.id.tabhost);
        tab.setOnTabChangedListener(tabId -> {
            if (tabId.equalsIgnoreCase("t1")) {
                list1.clear();
                list1.add(new Item("52300", "Em là ai", 0));
                list1.add(new Item("52600", "Chờ đợi", 1));
                myarray1.notifyDataSetChanged();
            }

            if (tabId.equalsIgnoreCase("t2")) {
                list2.clear();
                list2.add(new Item("57236", "Gửi em ở cuối sông Hồng", 0));
                list2.add(new Item("51536", "Say tình", 0));
                myarray2.notifyDataSetChanged();
            }

            if (tabId.equalsIgnoreCase("t3")) {
                list3.clear();
                list3.add(new Item("57896", "Hát với dòng sông", 0));
                list3.add(new Item("57610", "Say tình Remix", 0));
                myarray3.notifyDataSetChanged();
            }
        });
    }
}
