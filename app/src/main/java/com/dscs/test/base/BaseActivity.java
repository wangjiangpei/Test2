package com.dscs.test.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dscs.test.R;

/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }


    public void initToolBar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ((TextView) findViewById(R.id.app_title)).setText(getActivityTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(canBack());
        }
    }

    public void setToolbarBtnText(String text) {
        if (tv != null)
            tv.setText(text);
    }

    public void showBtn(View.OnClickListener listener) {
        if (tv != null) {
            tv.setVisibility(View.VISIBLE);
            tv.setOnClickListener(listener);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (showTitle()) {
            super.setContentView(R.layout.view_title);
            LayoutInflater.from(this).inflate(layoutResID, (LinearLayout) findViewById(R.id.group));
            setSupportActionBar(toolbar = (Toolbar) findViewById(R.id.toolBar));
            tv = (TextView) findViewById(R.id.title_btn);
//            tv.setTypeface(Typeface.createFromAsset(getAssets(), "Qomolangma-UchenSarchung.ttf"));
            initToolBar();
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
//            actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
            }
        } else {
            super.setContentView(layoutResID);
        }
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        config.fontScale = 1.0f;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    public void toast(String msg) {
        Toast.makeText(getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public Context getAppContext() {
        return getApplicationContext();
    }

    public AlertDialog createAlertDialog(String title,
                                         String message,
                                         String okButton,
                                         String cancelButton,
                                         DialogInterface.OnClickListener okListenner,
                                         DialogInterface.OnClickListener cancelListenner,
                                         boolean isEnd) {
        return new AlertDialog.Builder(getAppContext())
                .setMessage(message).setTitle(title)
                .setPositiveButton(okButton, okListenner)
                .setNegativeButton(cancelButton, cancelListenner)
                .setCancelable(isEnd).create();
    }

    public ProgressDialog createProgressDialog(String title, String message) {
        return ProgressDialog.show(getAppContext(), title, message);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return true;
    }

    /**
     * 如果不需�???  return 0
     *
     * @return
     */


    public abstract String getActivityTitle();

    public boolean canBack() {
        return true;
    }

    ;

    public boolean showTitle() {
        return true;
    }

    @Override
    protected void onDestroy() {
        // �???出时弹出stack
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }
}
