package com.example.sanchit.chidiyaudd;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class SinglePlayer extends AppCompatActivity {
    public static final String TAG="SinglePlayer";
ImageView finger;
    int score=0,ques=0;
    boolean gameStart=false;
    boolean firstTouchDown=true;
    boolean touchUp=false;
    boolean ansCorrect=false;
    TextView countdown_tv,display_tv;
    ImageView ques_iv,retry_iv;
    SinglePlayerTask singlePlayerTask;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        finger= (ImageView) findViewById(R.id.finger_iv);
        countdown_tv= (TextView) findViewById(R.id.countdown_tv)    ;
         singlePlayerTask=new SinglePlayerTask();
        ques_iv= (ImageView) findViewById(R.id.ques_iv);
        display_tv= (TextView) findViewById(R.id.displaytv);
        retry_iv= (ImageView) findViewById(R.id.retry_iv);
        finger.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.fingerprint));
        finger.setEnabled(true);
        retry_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SinglePlayer.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        finger.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if((event.getAction()==MotionEvent.ACTION_DOWN)) {
                    Log.d(TAG, "onTouch: ENTERED IV1");

                    if(firstTouchDown){
                        SinglePlayerTask singlePlayerTask=new SinglePlayerTask();
                        singlePlayerTask.execute(5);
                    }
                        firstTouchDown=false;
//                    if(firstTouchDown&&!gameStart)
//                    if(!gameStart)
//                    {
//                        if(singlePlayerTask!=null&&!singlePlayerTask.isCancelled())
//                            singlePlayerTask.cancel(true);
//                        countdown_tv.setText(String.valueOf(5));
//                        singlePlayerTask=new SinglePlayerTask();
//                        singlePlayerTask.execute(5-ques);
//                    }
                }

                if((event.getAction()==MotionEvent.ACTION_UP))
                {
                    Log.d(TAG, "onTouch: EXITED IV1");
                   if(!gameStart){

                   }
                   else{
                       touchUp=true;
                   }


//                       singlePlayerTask.cancel(true);



                }
                else{
                    touchUp=false;
                }



                return true;
            }
        });
//        SinglePlayerTask singlePlayer=new SinglePlayerTask();
//        singlePlayer.execute(5);
    }
    public void nextCall(){
        Log.d(TAG, "nextCall: NextCall Ans Correct "+ansCorrect);
        if(ansCorrect){
            ques++;
            score++;
            touchUp=false;
            gameStart=false;
            display_tv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            display_tv.setText("NICE JOB..!");
            oneloopsec();
            display_tv.setText("READY TO GO IN:");
            SinglePlayerTask singlePlayerTask=new SinglePlayerTask();
            singlePlayerTask.execute(5-ques);
            ansCorrect=false;

        }
        else{
            ques=0;
            score=0;
            gameStart=false;
            display_tv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            display_tv.setText("You Lose..!");
            retry_iv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            finger.setEnabled(false);
            touchUp=false;

        }
    }
    class SinglePlayerTask extends AsyncTask<Integer,Integer,Boolean> {
        @Override
        protected Boolean doInBackground(Integer... params) {
            int counter=params[0];
            while (counter>=1){
                oneloopsec();
                publishProgress(counter);
                counter--;

            }
            Log.d(TAG, "doInBackground: CountDown Ends returned True");
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            countdown_tv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
            countdown_tv.setText(String.valueOf(values[0]));

            Log.d(TAG, "doInBackground: COuntDown gameStart "+gameStart);
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            countdown_tv.setLayoutParams(new RelativeLayout.LayoutParams(0,0));
            Log.d(TAG, "onPostExecute: Got True After countdown ");
            if(aBoolean){
                gameStart=true;

//                Random random=new Random();
//                 x=random.nextInt()%10;
                x=1;
                display_tv.setLayoutParams(new RelativeLayout.LayoutParams(0,0));
                retry_iv.setLayoutParams(new RelativeLayout.LayoutParams(0,0));
                switch (x){

                    case 1: {
                        ques_iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.image_1));
                        AudioTask audioTask=new AudioTask();
                        audioTask.execute(x);


                    }
                    break;

                }


            }

        }
    }
    public static void oneloopsec()
    {
        long x= System.currentTimeMillis();
        while(System.currentTimeMillis()-x<1000);
    }
    class AudioTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... params) {
            switch (params[0])
            {
                case 1:MediaPlayer mediaPlayer=MediaPlayer.create(getBaseContext(),R.raw.sound_1);

                    mediaPlayer.start();
                    while (mediaPlayer.isPlaying());
                    mediaPlayer.start();
                    while (mediaPlayer.isPlaying());
                    mediaPlayer.release();
                    break;

            }


            return x;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            switch (x) {
                case 1:
                    if (!touchUp){
                        Log.d(TAG, "onTouch: bbugger of you lose ");

                        ansCorrect=false;
                    }
                    else {
                        Log.d(TAG, "onPostExecute: Win");

                        ansCorrect=true;
                    }

            }
            nextCall();
        }
    }

}


