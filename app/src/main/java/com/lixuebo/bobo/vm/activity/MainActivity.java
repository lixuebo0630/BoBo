package com.lixuebo.bobo.vm.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lixuebo.bobo.R;
import com.lixuebo.bobo.factory.FragmentFactory;
import com.lixuebo.bobo.utils.UIUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main_act);
        toolbar.setTitle("BoBo");
        toolbar.setTitleTextColor(Color.WHITE);
        //设置actionbar
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout_main);

        ActionBarDrawerToggle barDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open, R.string.close);

        barDrawerToggle.syncState();
        // 如果想看到菜单滑动过程中，Toolbar的一些细节变化（菜单按钮）
        drawerLayout.addDrawerListener(barDrawerToggle);

        //左侧拉出菜单
        NavigationView navigationView =  (NavigationView) findViewById(R.id.nav_main);

        navigationView.setNavigationItemSelectedListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_main_act);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_main_act);
        viewPager.setAdapter(new mViewPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);

    }


    private class mViewPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] titles;

        public mViewPagerAdapter(FragmentManager fm) {
            super(fm);

            titles = UIUtils.getStrings(R.array.content_title);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.getFragment(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {


            return titles[position];
        }



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);
        drawerLayout.closeDrawers();


        return false;
    }
}
