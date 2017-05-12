package com.example.lcy.siyifugame;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView iv;
    ImageView iv_bg;
    Bitmap bitmap;
    Bitmap bitmap2;
    Paint paint;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //用来显示操作后的图片
        iv=(ImageView) findViewById(R.id.iv);
        //用来显示背景图片
        iv_bg=(ImageView)findViewById(R.id.iv_bg);

        //设置默认背景图片
        iv_bg.setImageResource(R.drawable.b1);
        //获取要操作的原图
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a1);
        //创建原图的副本，相当于一张和原图大小相同的白纸
        bitmap2=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());

        //创建画笔
        paint=new Paint();
        //创建画板把白纸铺上去
        canvas=new Canvas(bitmap2);
        //在画板上作画，依据副本的图片用矩形的画法在白纸画图
        canvas.drawBitmap(bitmap,new Matrix(),paint);
        //把画好的图覆盖在背景图片上
        iv.setImageBitmap(bitmap2);

        //设置触摸监听器
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //触摸事件选项
                switch (motionEvent.getAction()){
                    //移动事件
                    case MotionEvent.ACTION_MOVE:{
                        for (int i=-30;i<30;i++){      //增加像素X轴的长
                            for (int j=-30;j<30;j++){    //增加像素Y轴的长
                                //撕成一个圆
                                if(Math.sqrt(i*i+j*j)<30)
                                    //设置图片的像素的颜色为透明，实现撕衣服的功能
                                    bitmap2.setPixel((int)motionEvent.getX()+i,(int)motionEvent.getY()+j, Color.TRANSPARENT);
                            }
                        }
                        //更新撕过衣服后的图片到iv
                        iv.setImageBitmap(bitmap2);
                        break;
                    }
                }
                return true;
            }
        });

    }

    //创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //菜单选项功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.meinv1:
                //菜单选项1事件
                //更新背景图片
                iv_bg.setImageResource(R.drawable.b1);
                //更新原图图片
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a1);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv2:
                //菜单选项2事件
                iv_bg.setImageResource(R.drawable.b2);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a2);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv3:
                //菜单选项3事件
                iv_bg.setImageResource(R.drawable.b3);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a3);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv4:
                //菜单选项4事件
                iv_bg.setImageResource(R.drawable.b4);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a4);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv5:
                //菜单选项5事件
                iv_bg.setImageResource(R.drawable.b5);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a5);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv6:
                //菜单选项6事件
                iv_bg.setImageResource(R.drawable.b6);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a6);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv7:
                //菜单选项7事件
                iv_bg.setImageResource(R.drawable.b7);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a7);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv8:
                //菜单选项8事件
                iv_bg.setImageResource(R.drawable.b8);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a8);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
            case R.id.meinv9:
                //菜单选项9事件
                iv_bg.setImageResource(R.drawable.b9);
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a9);
                canvas.drawBitmap(bitmap,new Matrix(),paint);
                iv.setImageBitmap(bitmap2);
                break;
        }
        return true;
    }
}
