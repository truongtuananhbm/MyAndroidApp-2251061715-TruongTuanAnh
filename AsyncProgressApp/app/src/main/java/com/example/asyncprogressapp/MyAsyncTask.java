package com.example.asyncprogressapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    Activity contextCha;

    public MyAsyncTask(Activity ctx) {
        contextCha = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextCha, "Bắt đầu tiến trình", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++) {
            publishProgress(i); // gửi dữ liệu tiến trình lên giao diện
            try {
                Thread.sleep(100); // delay mỗi 100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        ProgressBar progressBar = contextCha.findViewById(R.id.progressBar1);
        TextView txt = contextCha.findViewById(R.id.textView1);

        int val = values[0];
        progressBar.setProgress(val);
        txt.setText(val + "%");
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Toast.makeText(contextCha, "Tiến trình hoàn tất!", Toast.LENGTH_LONG).show();
    }
}

