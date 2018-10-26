package com.uniquestudio.lowpolyandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.uniquestudio.lowpoly.LowPoly;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gg, options);
                imageView.setImageBitmap(bitmap);
                Bitmap out = LowPoly.generate(bitmap, 40);
                if(bitmap!=null && !bitmap.isRecycled()){
                    bitmap.recycle();
                }
                imageView.setImageBitmap(out);
            }
        });

    }
}
