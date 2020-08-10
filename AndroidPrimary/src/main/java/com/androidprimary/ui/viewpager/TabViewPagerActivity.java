package com.androidprimary.ui.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.androidprimary.R;

public class TabViewPagerActivity extends AppCompatActivity implements TabHost.TabContentFactory {

    private TabHost mTabHost;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_pager);

        mTabHost = findViewById(R.id.tabhost);
        mTabHost.setup();

        int[] titleIDs = {R.string.home, R.string.msg, R.string.me};
        int[] imgIDs = {
                R.drawable.color_tab_icon_home,
                R.drawable.color_tab_icon_message,
                R.drawable.color_tab_icon_me
        };

        for (int i = 0; i < titleIDs.length; i++) {
            View view = getLayoutInflater().inflate(R.layout.tab_view_pager_layout, null);
            ImageView icon = view.findViewById(R.id.iv_tab_icon);
            TextView title = view.findViewById(R.id.tv_text);
            View tabBg = view.findViewById(R.id.tab_bg);

            icon.setImageResource(imgIDs[i]);
            title.setText(titleIDs[i]);
            tabBg.setBackgroundColor(getResources().getColor(R.color.black, null));


            mTabHost.addTab(
                    mTabHost.newTabSpec(getString(titleIDs[i]))
                            .setIndicator(view)
                            .setContent(this)
            );
        }


        /**
         * 添加多个 fragment
         */
        final Fragment[] fragments = {
                TabViewPgerFragment.getInstance("home"),
                TabViewPgerFragment.getInstance("hi"),
                TabViewPgerFragment.getInstance("kao"),
        };

        final ViewPager viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mTabHost != null) {
                    mTabHost.setCurrentTab(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (mTabHost != null) {
                    int position = mTabHost.getCurrentTab();
                    viewPager.setCurrentItem(position);
                }
            }
        });
    }

    @Override
    public View createTabContent(String tag) {
        View view = new View(this);
        view.setMinimumHeight(0);
        view.setMinimumWidth(0);
        return view;
    }
}