package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WeatherAndForecastFragment();
            case 1:
                return new WeatherAndForecast1Fragment();
            case 2:
                return new WeatherAndForecast2Fragment();
            default:
                return new WeatherAndForecastFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
