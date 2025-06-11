package com.example.project24;

import android.os.Bundle;
import android.widget.ListView;
import android.os.AsyncTask;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTygia;
    MyArrayAdapter myadapter;
    ArrayList<Tygia> dstygia;
    String URL_JSON = "https://dongabank.com.vn/exchange/export";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTygia = findViewById(R.id.lvTygia);
        dstygia = new ArrayList<>();
        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, dstygia);
        lvTygia.setAdapter(myadapter);

        new TygiaTask().execute();
    }

    class TygiaTask extends AsyncTask<Void, Void, ArrayList<Tygia>> {
        @Override
        protected ArrayList<Tygia> doInBackground(Void... params) {
            ArrayList<Tygia> list = new ArrayList<>();
            try {
                URL url = new URL(URL_JSON);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setRequestProperty("Accept", "*/*");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                    builder.append(line);
                reader.close();

                JSONArray array = new JSONObject(builder.toString()).getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);

                    String type = item.getString("type");
                    String imageurl = item.getString("imageurl");
                    String muack = item.getString("muack");
                    String bantienmat = item.getString("bantienmat");
                    String bank = item.getString("bank");

                    Bitmap bitmap = null;
                    try {
                        URL imgUrl = new URL(imageurl);
                        bitmap = BitmapFactory.decodeStream(imgUrl.openConnection().getInputStream());
                    } catch (Exception e) { e.printStackTrace(); }

                    list.add(new Tygia(type, imageurl, bitmap, muack, bantienmat, bank));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Tygia> result) {
            dstygia.clear();
            dstygia.addAll(result);
            myadapter.notifyDataSetChanged();
        }
    }
}
