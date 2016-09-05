package com.android.xxnan.daynews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.xxnan.daynews.IActivity.IZhiHuActivity;
import com.android.xxnan.daynews.adapter.ZhiHuRecycleAdapter;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuDays;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuDaysItem;
import com.android.xxnan.daynews.implpersenter.ImplZhiHuPersenter;

import java.util.ArrayList;

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
    private ZhiHuDays zhiHuDays;
    private ArrayList<ZhiHuDaysItem> mZhiHuDaysItems;
    private ZhiHuRecycleAdapter zhihuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ButterKnife.inject(this);
        mZhiHuDaysItems=new ArrayList<>();
        initView();
    }

    private void initView() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在加载...");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        zhihuAdapter=new ZhiHuRecycleAdapter(mZhiHuDaysItems);
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
    public void updateList(ZhiHuDays zhiHuDays) {
        this.zhiHuDays=zhiHuDays;
        mZhiHuDaysItems=zhiHuDays.getmZhiHuDaysItem();
        zhihuAdapter.notifyDataSetChanged();
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
