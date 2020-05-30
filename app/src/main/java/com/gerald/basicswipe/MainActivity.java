package com.gerald.basicswipe;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private String TAG = "swiped position";
    private float x1,x2,y1,y2;
    private static int min_distance = 150;
    private GestureDetector GesDec;

    Random random = new Random();
    private ImageView imVi;

    int[]sampleImages ={R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imVi = findViewById(R.id.imageView);
        setImageRandom(sampleImages.length);

        //Gesture Detector
        this.GesDec = new GestureDetector(MainActivity.this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        GesDec.onTouchEvent(e);

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = e.getX();
                y1 = e.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = e.getX();
                y2 = e.getY();

                float valX = x2 - x1;
                float valY = y2 - y1;

                if (Math.abs(valX) > min_distance) {
                    if(x2 > x1){
                        Toast.makeText(MainActivity.this, "swiped to right", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "right swipe.");
                        setImageRandom(sampleImages.length);
                    }else {
                        Toast.makeText(MainActivity.this, "swiped to left", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Left swipe.");
                        setImageRandom(sampleImages.length);
                    }
                }else if(Math.abs(valY) > min_distance) {
                    if(y2 > y1){
                        Toast.makeText(MainActivity.this, "swiped to bottom", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "bottom swipe.");
                        setImageRandom(sampleImages.length);
                    }else {
                        Toast.makeText(MainActivity.this, "swiped to top", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "top swipe.");
                        setImageRandom(sampleImages.length);
                    }
                }
                break;
        }
        return super.onTouchEvent(e);
    }
    private void setImageRandom(int length) {
        int i = random.nextInt(length);
        Log.d(TAG, "index : " + i);
        imVi.setImageResource(sampleImages[i]);
    }
    @Override
    public boolean onDown(MotionEvent motionEvent) {
//        Toast.makeText(MainActivity.this, "Swiped", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
