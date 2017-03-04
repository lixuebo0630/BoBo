package com.lixuebo.bobo.vm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lixuebo.bobo.R;

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
        //设置actionbar
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout_main);

        ActionBarDrawerToggle barDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open, R.string.close);

        barDrawerToggle.syncState();
        // 如果想看到菜单滑动过程中，Toolbar的一些细节变化（菜单按钮）
        drawerLayout.addDrawerListener(barDrawerToggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_main);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);
        drawerLayout.closeDrawers();
        ;

        return false;
    }
}
