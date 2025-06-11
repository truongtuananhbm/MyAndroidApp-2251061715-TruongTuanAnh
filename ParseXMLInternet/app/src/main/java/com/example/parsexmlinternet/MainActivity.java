package com.example.parsexmlinternet;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import java.util.ArrayList;
import android.os.AsyncTask;


public class MainActivity extends AppCompatActivity {

    Button btnparse;
    ListView lv;
    ArrayAdapter<String> myadapter;
    ArrayList<String> datashow;

    String URL = "https://api.androidhive.info/pizza/?format=xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnparse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);
        datashow = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datashow);
        lv.setAdapter(myadapter);

        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadExampleTask().execute();
            }
        });
    }

    class LoadExampleTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> list = new ArrayList<>();
            try {
                XMLParser parser = new XMLParser();
                String xml = parser.getXmlFromUrl(URL);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(xml));

                int eventType = xpp.getEventType();
                String tagValue = "";
                boolean insideItem = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagName = xpp.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (tagName.equalsIgnoreCase("item")) {
                                insideItem = true;
                            } else if (insideItem && tagName.equalsIgnoreCase("name")) {
                                tagValue = "";
                            }
                            break;
                        case XmlPullParser.TEXT:
                            tagValue = xpp.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if (tagName.equalsIgnoreCase("name") && insideItem) {
                                list.add(tagValue);
                            } else if (tagName.equalsIgnoreCase("item")) {
                                insideItem = false;
                            }
                            break;
                    }
                    eventType = xpp.next();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            datashow.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            datashow.addAll(result);
            myadapter.notifyDataSetChanged();
        }
    }
}
