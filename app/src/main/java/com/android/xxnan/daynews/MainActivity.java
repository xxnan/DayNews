package com.android.xxnan.daynews;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.xxnan.daynews.adapter.MeunAdapter;
import com.android.xxnan.daynews.adapter.MyPageAdapter;
import com.android.xxnan.daynews.bean.zhihu.MenuBean;
import com.android.xxnan.daynews.fragment.BaseFragment;
import com.android.xxnan.daynews.fragment.WangYiFragment;
import com.android.xxnan.daynews.fragment.ZhiHuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements BaseFragment.IUpdateView {
    @InjectView(R.id.left_listview)
    ListView left_listview;
    @InjectView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.content)
    LinearLayout content;
    @InjectView(R.id.viewpager)
    ViewPager viewPager;
    @InjectView(R.id.title_dian)
    LinearLayout title_dian;
    private ProgressDialog progressDialog;
    private Snackbar snackbar;


    private List<MenuBean> muenlist = new ArrayList<>();
    private static final String ZHIHU = "知乎日报";
    private static final String WANGYI = "网易头条";
    private static final String LOOKLOOK = "每日看看";
    //    @InjectView(R.id.zhihufragment)
    private ZhiHuFragment zhiHuFragment;
    private WangYiFragment wangYiFragment;
    private FragmentManager fragmetManager;
    private final int pageCount = 3;
    private final int DEAFULT_MSG = 0X110;
    private final int DEALY_TIME = 5000;//viewpager延时间隔
    private List<View> pageViews = new ArrayList<>(pageCount);
    private List<View> titleDians = new ArrayList<>(pageCount);
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == DEAFULT_MSG) {
                viewPager.setCurrentItem(msg.arg1);
                setDianBg(msg.arg1);
                handler.postDelayed(new titleRunable(), DEALY_TIME);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.inject(this);
        initView();
        inittitlepageview();
        initMuneData();
        initPageData();
        fragmetManager = getSupportFragmentManager();
        fragmetManager.beginTransaction().add(R.id.content, zhiHuFragment).commit();

    }

    /**
     * 初始化viewpager下方循环点
     */
    private void inittitlepageview() {
        for (int i = 0; i < pageCount; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.drawable.dian_gry);
            titleDians.add(i, imageView);
            title_dian.addView(imageView);
        }

    }

    /**
     * 设置点的背景颜色
     *
     * @param i
     */
    private void setDianBg(int i) {
        for (int i1 = 0; i1 < titleDians.size(); i1++) {
            if (i1 == i)
                titleDians.get(i1).setBackgroundResource(R.drawable.dian_white);
            else
                titleDians.get(i1).setBackgroundResource(R.drawable.dian_gry);
        }
    }

    /**
     * 初始化菜单数据
     */
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

    int index = 0;

    private void initPageData() {
        ImageView imageView1 = (ImageView) LayoutInflater.from(MainActivity.this).inflate(R.layout.page_item, null);
        imageView1.setBackgroundResource(R.drawable.title_1);
        pageViews.add(imageView1);
        ImageView imageView2 = (ImageView) LayoutInflater.from(MainActivity.this).inflate(R.layout.page_item, null);
        imageView2.setBackgroundResource(R.drawable.title_2);
        pageViews.add(imageView2);
        ImageView imageView3 = (ImageView) LayoutInflater.from(MainActivity.this).inflate(R.layout.page_item, null);
        imageView3.setBackgroundResource(R.drawable.title_3);
        pageViews.add(imageView3);
        viewPager.setAdapter(new MyPageAdapter(pageViews));
        viewPager.setOffscreenPageLimit(1);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                viewPager.setCurrentItem(position);
//                index=position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //初始化点的背景颜色
        setDianBg(index);
        handler.postDelayed(new titleRunable(), DEALY_TIME);
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
        zhiHuFragment = new ZhiHuFragment();
        zhiHuFragment.setiUpdateView(this);
        wangYiFragment = new WangYiFragment();
        wangYiFragment.setiUpdateView(this);

    }

    /**
     * 菜单点击事件
     * @param title
     */
    private void meunClick(String title) {
        Intent intent = new Intent();
        if (title.equals(ZHIHU)) {
            fragmetManager.beginTransaction().replace(R.id.content, zhiHuFragment).commit();
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else if (title.equals(WANGYI)) {
            fragmetManager.beginTransaction().replace(R.id.content, wangYiFragment).commit();
            drawerLayout.closeDrawer(Gravity.LEFT);
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
            if (!drawerLayout.isDrawerOpen(Gravity.LEFT))
                drawerLayout.openDrawer(Gravity.LEFT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 显示进度条
     */
    public void showProgress() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载...");
        progressDialog.show();
    }

    /**
     * 隐藏进度条
     */
    public void hideProgress() {
        progressDialog.dismiss();
    }

    /**
     * 显示错误信息
     * @param error
     */
    public void showError(String error) {
        snackbar = Snackbar.make(content, error, Snackbar.LENGTH_SHORT);
    }

    /**
     * page循环的runnable
     */
    class titleRunable implements Runnable {

        @Override
        public void run() {
            Message ms = handler.obtainMessage();
            ms.what = DEAFULT_MSG;
            ms.arg1 = index++ % pageCount;
            handler.sendMessage(ms);
        }
    }
}
