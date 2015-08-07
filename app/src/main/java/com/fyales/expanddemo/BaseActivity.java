package com.fyales.expanddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    Toolbar toolbar;
    LinearLayout contentLl;
    private TextView centerTitleTv;
    private TextView leftTitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);

        contentLl = (LinearLayout) findViewById(R.id.content_ll);
        View v = LayoutInflater.from(this).inflate(layoutResID,contentLl,false);
        contentLl.addView(v);

        addToolbar();

    }


    private void addToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            centerTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_center_title);
            leftTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_left_title);

            if (centerTitleTv != null && getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    public void setPageTitle(String title){
        centerTitleTv.setText(title);
    }

    // 通过AndroidManifest指定的Title会自动显示到这个TextView中
    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (centerTitleTv != null) {
            centerTitleTv.setText(title);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
