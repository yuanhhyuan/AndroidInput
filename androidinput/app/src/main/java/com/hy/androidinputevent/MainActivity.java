package com.hy.androidinputevent;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String DEBUG_TAG = "060_Gestures";
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDown: " + event.toString() + ">>>>>>>>短按");
        return true;
    }

    final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        if (event1.getX() - event2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling left
            Log.d(DEBUG_TAG, "Fling left" + ">>>>>>>>向左滑屏");
            Toast.makeText(MainActivity.this, "Fling Left", Toast.LENGTH_SHORT).show();
        } else if (event2.getX() - event1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling right
            Log.d(DEBUG_TAG, "Fling right" + ">>>>>>>>向右滑屏");
            Toast.makeText(MainActivity.this, "Fling Right", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString() + ">>>>>>>>长按");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString() + ">>>>>>>>滑动");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString() + ">>>>>>>>单击");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString() + ">>>>>>>>双击");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }


    @Override
    public void onTrimMemory(int level) {
        // TODO Auto-generated method stub
        Log.d("060_"," onTrimMemory ... level:" + level);

        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                //释放资源
                /*编写释放资源代码*/
                Log.d("060_"," TRIM_MEMORY_UI_HIDDEN" );
                break;
            default:
                break;
        }

        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        //do release operation
    }


}


