package com.android.xxnan.daynews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.xxnan.daynews.IActivity.IZhiHuActivity;
import com.android.xxnan.daynews.adapter.MeunAdapter;
import com.android.xxnan.daynews.adapter.ZhiHuRecycleAdapter;
import com.android.xxnan.daynews.bean.zhihu.MenuBean;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuBean;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuStories;
import com.android.xxnan.daynews.implpersenter.ImplZhiHuPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements IZhiHuActivity {
    @InjectView(R.id.left_listview)
    ListView left_listview;
    @InjectView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.content)
    RelativeLayout content;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ImplZhiHuPersenter implZhiHuPersenter;
    private ProgressDialog progressDialog;
    private Snackbar snackbar;
    private ZhiHuBean zhiHuBean;
    private ArrayList<ZhiHuStories> stories;
    private ZhiHuRecycleAdapter zhihuAdapter;

    private List<MenuBean> muenlist = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0x110) {
                zhiHuBean = (ZhiHuBean) msg.obj;
                stories = zhiHuBean.getStories();
                zhihuAdapter.setData(stories);
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
        initMuneData();
        initView();
        implZhiHuPersenter = new ImplZhiHuPersenter(MainActivity.this, this);
        implZhiHuPersenter.getLastZhihuNews();
    }

    private void initMuneData() {
        MenuBean menuBean=new MenuBean();
        menuBean.setIconId(R.drawable.zhihu);
        menuBean.setTitle("知乎日报");
        muenlist.add(menuBean);

        menuBean=new MenuBean();
        menuBean.setIconId(R.drawable.wangyi);
        menuBean.setTitle("网易头条");
        muenlist.add(menuBean);

        menuBean=new MenuBean();
        menuBean.setIconId(R.drawable.look2);
        menuBean.setTitle("每日看看");
        muenlist.add(menuBean);
    }

    private void initView() {
        left_listview = (ListView) findViewById(R.id.left_listview);
        left_listview.setAdapter(new MeunAdapter(MainActivity.this, muenlist));
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载...");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        zhiHuBean = new ZhiHuBean();
        stories = new ArrayList<ZhiHuStories>();
        zhihuAdapter = new ZhiHuRecycleAdapter(MainActivity.this, stories);
        recyclerView.setAdapter(zhihuAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateList(final ZhiHuBean bean) {
        Message msg = handler.obtainMessage();
        msg.arg1 = 0x110;
        msg.obj = bean;
        handler.sendMessage(msg);

    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorMessage(String error) {
        snackbar = Snackbar.make(content, error, Snackbar.LENGTH_SHORT);
    }
}
