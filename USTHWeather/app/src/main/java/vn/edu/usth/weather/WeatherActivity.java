package vn.edu.usth.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.ExecutionException;


public class WeatherActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    //ImageButton btnRefresh;
    MyAsyncTask myAsyncTask;
    String url = "https://kenh14cdn.com/thumb_w/600/QuickNewsK14/107392794/2015/02/img_201502282130320133.jpeg";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*btnRefresh = (ImageButton) findViewById(R.id.refresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask(WeatherActivity.this);
                myAsyncTask.execute();
            }
        });*/


        ForecastFragment ff = ForecastFragment.newInstance("", "");
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, ff).commit();
        WeatherFragment wf = WeatherFragment.newInstance("","");
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, wf).commit();
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh) {
            /*final Handler handler = new Handler();

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    //This method is run in worked thread
                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Network Connected!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
            t.start();*/

            //myAsyncTask = new MyAsyncTask(WeatherActivity.this);
            //myAsyncTask.execute();
            myAsyncTask = new MyAsyncTask(WeatherActivity.this);

            imageView = findViewById(R.id.imageView);
            try {
                Bitmap bitmap = myAsyncTask.execute(url).get();
                imageView.setImageBitmap(bitmap);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        else if (id == R.id.setting) {
            openPrefActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openPrefActivity() {
        Intent intent = new Intent(this, PrefActivity.class);
        startActivity(intent);
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

