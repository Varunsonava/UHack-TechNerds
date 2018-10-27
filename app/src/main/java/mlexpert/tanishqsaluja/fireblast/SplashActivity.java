package mlexpert.tanishqsaluja.fireblast;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4;
    Animation a;

    class myThread extends Thread {
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                Log.e("TAG", e.getMessage());
            } finally {
                Intent intent = new Intent(getApplicationContext(), SplitActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myThread m = new myThread();
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);
        Typeface tf = Typeface.createFromAsset(getAssets(), "qb.otf");
        t1.setTypeface(tf);
        t2.setTypeface(tf);
        t3.setTypeface(tf);
        t4.setTypeface(tf);
        a = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        t1.setAnimation(a);
        t2.setAnimation(a);
        t3.setAnimation(a);
        t4.setAnimation(a);
        m.start();
    }

}


