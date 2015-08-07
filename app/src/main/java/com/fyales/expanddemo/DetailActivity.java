package com.fyales.expanddemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

public class DetailActivity extends BaseActivity implements View.OnClickListener{

    public static final String ANIMATOR_POSITION = "animator_position";
    private int mPosition;
    private LinearLayout animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mPosition = getIntent().getIntExtra(ANIMATOR_POSITION, 0);
        animationView = (LinearLayout) findViewById(R.id.animaiton_iew);
        animationView.setOnClickListener(this);

        animationView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                animationView.getViewTreeObserver().removeOnPreDrawListener(this);
                startIntroAnimation();
                return true;
            }
        });
    }

    private void startIntroAnimation() {
        ViewCompat.setElevation(getToolbar(), 0);
        animationView.setScaleY(0.2f);
        animationView.setPivotY(mPosition);

        animationView.animate()
                .scaleY(1)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ViewCompat.setElevation(getToolbar(), 16);

                    }
                })
                .start();
    }



    @Override
    public void onBackPressed() {
//        animationView.setScaleY(1f);
//        animationView.setPivotY(mPosition);
        animationView.animate()
                .scaleY(0.2f)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
//                        ViewCompat.setElevation(getToolbar(), 16);
                    }
                })
                .start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                overridePendingTransition(0, 0);
            }
        },200);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
    public void onClick(View v) {
    }
}
