package com.example.drawingobject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView ourView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        draw();
        setContentView(ourView);
    }

    public void draw(){
        Bitmap blankBitmap;
        blankBitmap = Bitmap.createBitmap(600,600,Bitmap.Config.ARGB_8888);
        Canvas canvas;
        canvas = new Canvas(blankBitmap);

        ourView = new ImageView(this);
        ourView.setImageBitmap(blankBitmap);

        Paint paint =  new Paint();

        //Make a red canvas
        canvas.drawColor(Color.argb(255, 255, 0, 0));

        //Make an Orange Box
        paint.setColor(Color.argb(255,  249, 129, 0));
        canvas.drawRect(50,50,550,550,paint);

        //Draw banana
        Bitmap bitmapBanana;
        bitmapBanana = BitmapFactory.decodeResource(this.getResources(), R.drawable.banana_100x100);
        Matrix theMatrix = new Matrix();
        theMatrix.setRotate(30,-350,600);
        canvas.drawBitmap(bitmapBanana, theMatrix, paint);

        //Make title
        paint.setColor(Color.argb(255,  255, 255, 0));
        paint.setTextSize(30);
        canvas.drawText("This Is Banana Face", 120, 40, paint);

        //Draw Left eye
        paint.setColor(Color.argb(255,  255, 255, 255));
        canvas.drawCircle(175,185,100,paint);
        paint.setColor(Color.argb(255,  0, 0, 0));
        canvas.drawCircle(190,170,50,paint);

        //Draw Right eye
        paint.setColor(Color.argb(255,  255, 255, 255));
        canvas.drawCircle(400,160,80,paint);
        paint.setColor(Color.argb(255,  0, 0, 0));
        canvas.drawCircle(425,145,40,paint);

        //Draw Nose
        paint.setColor(Color.argb(255,  0, 0, 0));
        paint.setStrokeWidth(8);
        canvas.drawLine(300,250,425,330, paint);
        canvas.drawLine(425,330,300,400, paint);
    }
}