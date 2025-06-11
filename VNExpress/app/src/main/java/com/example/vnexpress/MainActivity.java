package com.example.vnexpress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    MyArrayAdapter myadapter;
    ArrayList<List> mylist;
    String URL_FEED = "https://vnexpress.net/rss/tin-moi-nhat.rss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, mylist);
        lv.setAdapter(myadapter);

        loadRssData();
    }

    private void loadRssData() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            ArrayList<List> result = new ArrayList<>();
            try {
                XMLParser parser = new XMLParser();
                String xml = parser.getXmlFromUrl(URL_FEED);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(xml));

                int eventType = xpp.getEventType();
                String title = "", link = "", des = "";
                Bitmap img = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tag = xpp.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (tag.equalsIgnoreCase("title")) {
                                title = xpp.nextText();
                            } else if (tag.equalsIgnoreCase("link")) {
                                link = xpp.nextText();
                            } else if (tag.equalsIgnoreCase("description")) {
                                des = xpp.nextText();
                                try {
                                    int start = des.indexOf("src=\"") + 5;
                                    int end = des.indexOf("\"", start);
                                    String imgUrl = des.substring(start, end);
                                    URL u = new URL(imgUrl);
                                    img = BitmapFactory.decodeStream(u.openConnection().getInputStream());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if (tag.equalsIgnoreCase("item")) {
                                result.add(new List(img, title, des, link));
                            }
                            break;
                    }
                    eventType = xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            handler.post(() -> {
                mylist.clear();
                mylist.addAll(result);
                myadapter.notifyDataSetChanged();
            });
        });
    }
}
