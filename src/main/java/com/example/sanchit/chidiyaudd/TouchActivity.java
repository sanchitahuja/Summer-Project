package com.example.sanchit.chidiyaudd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class TouchActivity extends AppCompatActivity {
ImageView iv1,iv2,iv3,iv4;
    public static final String TAG="ToucH Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv3= (ImageView) findViewById(R.id.iv3);
        iv4= (ImageView) findViewById(R.id.iv4);
        Log.d(TAG, "onCreate: Logs are active");
        iv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if((event.getAction()==MotionEvent.ACTION_UP)&&(v.getId()==iv1.getId()))
                {
                    Log.d(TAG, "onTouch: EXITED IV1");
                }
                return true;
            }

        });
        iv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if((event.getAction()==MotionEvent.ACTION_UP)&&(v.getId()==iv2.getId()))
                {
                    Log.d(TAG, "onTouch: EXITED IV2");
                }
                return true;
            }

        });

//        iv1.setOnGenericMotionListener(new View.OnGenericMotionListener() {
//            @Override
//            public boolean onGenericMotion(View v, MotionEvent event) {
//                Log.d(TAG, "onGenericMotion: IV1");
//                if(event.getAction()==MotionEvent.ACTION_BUTTON_RELEASE&&v.getId()==iv1.getId()) {
//                    Log.d(TAG, "onTouch: IMAGE VIEW 1 EXITED");
//                }
//                return true;
//            }
//        });
//        iv1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d(TAG, "onTouch: View v id"+v.getId());
//                Log.d(TAG, "onTouch: R id"+iv1.getId());
////                if(event.getAction()==MotionEvent.ACTION_DOWN) {
////                    Log.d(TAG, "onTouch: IMAGE VIEW 1 ENTERED");
////                }
//
////                Log.d(TAG, "onTouch: IV1 STATE "+event.getButtonState());
////                if(event.getButtonState()!=0)
////                    Log.d(TAG, "onTouch: 1 exited");
////                if(event.isButtonPressed(R.id.iv1))
//                return true;
//            }
//        });
//        iv2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//
////                if(event.getAction()==MotionEvent.ACTION_DOWN) {
////                    Log.d(TAG, "onTouch: IMAGE VIEW 2 ENTERED");
////                }
//                if(event.getAction()==MotionEvent.ACTION_POINTER_UP) {
//                    Log.d(TAG, "onTouch: IMAGE VIEW 2 EXITED");
//                    Log.d(TAG, "onTouch: ");
//                }
////                Log.d(TAG, "onTouch: IV2 STATE "+event.getButtonState());
////                if(event.getButtonState()!=0)
////                    Log.d(TAG, "onTouch: 2 exited");
//                return true;
//            }
//        });
//        iv3.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
////                if(event.getButtonState()!=0)
////                    Log.d(TAG, "onTouch: 3 exited");
//
////                Log.d(TAG, "onTouch: IV3 STATE "+event.getButtonState());
//                if(event.getAction()==MotionEvent.ACTION_POINTER_UP&&v.getId()==iv3.getId()) {
//                    Log.d(TAG, "onTouch: IMAGE VIEW 3 EXITED");
//                    Log.d(TAG, "onTouch: ");
//                }
//                return true;
//            }
//        });
//        iv4.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
////                if(event.getButtonState()!=0)
////                    Log.d(TAG, "onTouch: 4 exited");
////                if(event.getAction()==MotionEvent.ACTION_DOWN) {
////                    Log.d(TAG, "onTouch: IMAGE VIEW 4 ENTERED");
////                }
////                if(event.getAction()==MotionEvent.ACTION_UP) {
////                    Log.d(TAG, "onTouch: IMAGE VIEW 4 EXITED");
//////                }
////                Log.d(TAG, "onTouch: IV4 STATE "+event.getButtonState());
//                if(event.getAction()==MotionEvent.ACTION_POINTER_UP&&v.getId()==iv4.getId()) {
//                    Log.d(TAG, "onTouch: IMAGE VIEW 4 EXITED");
//                    Log.d(TAG, "onTouch: ");
//                }
//                return true;
//            }
//        });

    }
}
