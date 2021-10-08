package vn.edu.usth.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ForecastFragment ff = ForecastFragment.newInstance("", "");
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, ff).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "inside onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "inside onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "inside omStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "inside onDestroy");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i("Weather", "onCreate");
    }

}

