package com.android.xxnan.daynews;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.xxnan.daynews.adapter.MeunAdapter;
import com.android.xxnan.daynews.bean.zhihu.MenuBean;
import com.android.xxnan.daynews.fragment.BaseFragment;
import com.android.xxnan.daynews.fragment.ZhiHuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements BaseFragment.IUpdateView{
    @InjectView(R.id.left_listview)
    ListView left_listview;
    @InjectView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.content)
    RelativeLayout content;

    private ProgressDialog progressDialog;
    private Snackbar snackbar;


    private List<MenuBean> muenlist = new ArrayList<>();
    private static final String ZHIHU = "知乎日报";
    private static final String WANGYI = "网易头条";
    private static final String LOOKLOOK = "每日看看";
//    @InjectView(R.id.zhihufragment)
    ZhiHuFragment zhiHuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.inject(this);
        initView();
        initMuneData();

        FragmentManager fragmetManager = getSupportFragmentManager();
        fragmetManager.beginTransaction().add(R.id.content, zhiHuFragment).commit();

    }

    private void initMuneData() {
        MenuBean menuBean = new MenuBean();
        menuBean.setIconId(R.drawable.zhihu);
        menuBean.setTitle(ZHIHU);
        muenlist.add(menuBean);

        menuBean = new MenuBean();
        menuBean.setIconId(R.drawable.wangyi);
        menuBean.setTitle(WANGYI);
        muenlist.add(menuBean);

        menuBean = new MenuBean();
        menuBean.setIconId(R.drawable.look2);
        menuBean.setTitle(LOOKLOOK);
        muenlist.add(menuBean);
    }

    private void initView() {
        left_listview = (ListView) findViewById(R.id.left_listview);
        MeunAdapter meunAdapter = new MeunAdapter(MainActivity.this, muenlist);
        meunAdapter.setMuenClickInterface(new MeunAdapter.MuenClickInterface() {
            @Override
            public void muneClick(String title) {
                meunClick(title);
            }
        });
        left_listview.setAdapter(meunAdapter);
//        zhiHuFragment=(ZhiHuFragment)contentfindViewById(R.id.zhihufragment);
        zhiHuFragment=new ZhiHuFragment();
        zhiHuFragment.setiUpdateView(this);


    }

    private void meunClick(String title) {
        Intent intent = new Intent();
        if (title.equals(ZHIHU)) {
            intent.setClass(MainActivity.this, MainActivity.class);
        } else if (title.equals(WANGYI)) {

        } else if (title.equals(LOOKLOOK)) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            if(!drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.openDrawer(Gravity.LEFT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showProgress() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载...");
        progressDialog.show();
    }


    public void hideProgress() {
        progressDialog.dismiss();
    }


    public void showError(String error) {
        snackbar = Snackbar.make(content, error, Snackbar.LENGTH_SHORT);
    }
}
