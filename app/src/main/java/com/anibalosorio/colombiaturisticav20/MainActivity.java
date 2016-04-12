package com.anibalosorio.colombiaturisticav20;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Parque").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setTabListener(tabListener).setIcon(R.drawable.logoiglesia);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Fincas").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

        });

    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new ParqueFragment();
                case 1: return new IglesiaFragment();
                case 2: return new FincaFragment();
                default: return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
