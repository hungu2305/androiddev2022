package vn.edu.usth.weather;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer,Void> {
    Activity contextParent;

    public MyAsyncTask(Activity contextParent) {
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextParent, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);

    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(contextParent, "Network connected", Toast.LENGTH_SHORT).show();
    }
}
