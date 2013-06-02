package com.example.taikosample001;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TaikoSample001MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//描画クラスのインスタンスを生成
		MyView mView = new MyView(this);
		setContentView(mView);
	}
}


class MyView extends View{
	/**白鍵盤画像データを保持する。*/
	private Bitmap piano001Image;
	private int kenbanX1 = 100*0;
	private int kenbanX2 = 100*1;
	private int kenbanX3 = 100*2;
	private int kenbanX4 = 100*3;
	private int kenbanX5 = 100*4;
	private int kenbanX6 = 100*5;
	private int kenbanX7 = 100*6;
	private int kenbanX8 = 100*7;

	private int kenbanY1 = 0;
	private int kenbanY2 = 0;
	private int kenbanY3 = 0;
	private int kenbanY4 = 0;
	private int kenbanY5 = 0;
	private int kenbanY6 = 0;
	private int kenbanY7 = 0;
	private int kenbanY8 = 0;
	
	/**黒鍵盤画像データを保持する。*/
	private Bitmap piano002Image;
	private int kenbanKuroX1 = 100*1-40;
	private int kenbanKuroX2 = 100*2-40;
	private int kenbanKuroX3 = 100*4-40;
	private int kenbanKuroX4 = 100*5-40;
	private int kenbanKuroX5 = 100*6-40;

	private int kenbanKuroY1 = 0;
	private int kenbanKuroY2 = 0;
	private int kenbanKuroY3 = 0;
	private int kenbanKuroY4 = 0;
	private int kenbanKuroY5 = 0;
	
	/**白鍵盤サウンド再生データを保持する。*/
	private MediaPlayer sound01;
	private MediaPlayer sound02;
	private MediaPlayer sound03;
	private MediaPlayer sound04;
	private MediaPlayer sound05;
	private MediaPlayer sound06;
	private MediaPlayer sound07;
	private MediaPlayer sound08;
	
	/**黒鍵盤サウンド再生データを保持する。*/
	private MediaPlayer kuro0001;
	private MediaPlayer kuro0002;
	private MediaPlayer kuro0003;
	private MediaPlayer kuro0004;
	private MediaPlayer kuro0005;
	
	/**指の座標を取得する*/
	Point[] points = new Point[5];			
	
	/**
	 * コンストラクタ。
	 * @param context コンテキスト
	 */
	public MyView(Context context){
		super(context);
		
		//イベント取得できるようにFocusを有効する
		setFocusable(true);
		//Resoureインスタンスの生成
		Resources res = this.getContext().getResources();
		//画像の読み込み(/res/drawable-hdp/taiko.png)
		piano001Image = BitmapFactory.decodeResource(res,R.drawable.piano001);
		piano002Image = BitmapFactory.decodeResource(res,R.drawable.piano002);
		
		{
		//白鍵盤サウンドデータを読み込む(/res/raw/pon.mp3)
		sound01 = MediaPlayer.create( context,R.raw.sound01);
		sound02 = MediaPlayer.create( context,R.raw.sound02);
		sound03 = MediaPlayer.create( context,R.raw.sound03);
		sound04 = MediaPlayer.create( context,R.raw.sound04);
		sound05 = MediaPlayer.create( context,R.raw.sound05);
		sound06 = MediaPlayer.create( context,R.raw.sound06);
		sound07 = MediaPlayer.create( context,R.raw.sound07);
		sound08 = MediaPlayer.create( context,R.raw.sound08);
		
		//黒鍵盤サウンドデータを読み込む(/res/raw/pon.mp3)
		kuro0001 = MediaPlayer.create( context,R.raw.kuro001);
		kuro0002 = MediaPlayer.create( context,R.raw.kuro002);
		kuro0003 = MediaPlayer.create( context,R.raw.kuro003);
		kuro0004 = MediaPlayer.create( context,R.raw.kuro004);
		kuro0005 = MediaPlayer.create( context,R.raw.kuro005);
		
		for(int i = 0;i<5;i++){
			points[i] = new Point();
		}
		}	
	}
	
	
	/**
	 * 描画処理。
	 */

	@Override
	public void onDraw(Canvas canvas) {
		//背景色を設定する
		canvas.drawColor(Color.BLACK);
		
		//白Bitmapイメージの描画
		Paint mPaint = new Paint();
		canvas.drawBitmap(piano001Image, kenbanX1, kenbanY1,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX2, kenbanY2,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX3, kenbanY3,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX4, kenbanY4,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX5, kenbanY5,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX6, kenbanY6,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX7, kenbanY7,mPaint);
		canvas.drawBitmap(piano001Image, kenbanX8, kenbanY8,mPaint);
		//黒Bitmapイメージの描画
		canvas.drawBitmap(piano002Image, kenbanKuroX1, kenbanKuroY1,mPaint);
		canvas.drawBitmap(piano002Image, kenbanKuroX2, kenbanKuroY2,mPaint);
		canvas.drawBitmap(piano002Image, kenbanKuroX3, kenbanKuroY3,mPaint);
		canvas.drawBitmap(piano002Image, kenbanKuroX4, kenbanKuroY4,mPaint);
		canvas.drawBitmap(piano002Image, kenbanKuroX5, kenbanKuroY5,mPaint);
		
		
			
		}
	/**
	 * タッチイベント
	 */
	@Override
	public boolean onTouchEvent( MotionEvent event ){
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			//指がタッチされたx,y座標の取得
			int count = event.getPointerCount();
			for(int i = 0;i<count;i++){
				int id = event.getPointerId(i);
//				int touchX = (int)event.getX();
//				int touchY = (int)event.getY();
				points[id].x=(int)event.getX(i);
				points[id].y=(int)event.getY(i);
				
			
			
		if(((kenbanKuroX1 <points[id].x ) && (points[id].x < kenbanKuroX1 + piano002Image.getWidth()))
		&& ((kenbanKuroY1 < points[id].y) && (points[id].y < kenbanKuroY1 + piano002Image.getHeight()))){
			//あたり処理
						
				//サウンド再生
				kuro0001.start();
		}
		else if(((kenbanKuroX2 < points[id].x) && (points[id].x < kenbanKuroX2 + piano002Image.getWidth()))
		&& ((kenbanKuroY2 < points[id].y) && (points[id].y < kenbanKuroY2 + piano002Image.getHeight()))){
			//あたり処理
								
			//サウンド再生
			kuro0002.start();
		}
		else if(((kenbanKuroX3 < points[id].x) && (points[id].x < kenbanKuroX3 + piano002Image.getWidth()))
		&& ((kenbanKuroY3 < points[id].y) && (points[id].y < kenbanKuroY3 + piano002Image.getHeight()))){
			//あたり処理
										
			//サウンド再生
			kuro0003.start();
		}
		else if(((kenbanKuroX4 < points[id].x) && (points[id].x < kenbanKuroX4 + piano002Image.getWidth()))
		&& ((kenbanKuroY4 < points[id].y) && (points[id].y < kenbanKuroY4 + piano002Image.getHeight()))){
			//あたり処理
										
			//サウンド再生
			kuro0004.start();
		}
		else if(((kenbanKuroX5 < points[id].x) && (points[id].x < kenbanKuroX5 + piano002Image.getWidth()))
		&& ((kenbanKuroY5 < points[id].y) && (points[id].y < kenbanKuroY5 + piano002Image.getHeight()))){
			//あたり処理
										
			//サウンド再生
			kuro0005.start();
		}
			
		else if(((kenbanX1 < points[id].x) && (points[id].x < kenbanX1 + piano001Image.getWidth()))
		&& ((kenbanY1 < points[id].y) && (points[id].y < kenbanY2 + piano001Image.getHeight()))){
			//あたり処理
			
				//サウンド再生
				sound01.start();
			}
		else if (((kenbanX2 < points[id].x) && (points[id].x < kenbanX2 + piano001Image.getWidth()))
		&& ((kenbanY2 < points[id].y) && (points[id].y < kenbanY2 + piano001Image.getHeight()))){
			//あたりの処理
			
			//サウンド再生
			sound02.start();
		}
		else if (((kenbanX3 < points[id].x) && (points[id].x < kenbanX3 + piano001Image.getWidth()))
				&& ((kenbanY3 < points[id].y) && (points[id].y < kenbanY3 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound03.start();
				}
		else if (((kenbanX4 < points[id].x) && (points[id].x < kenbanX4 + piano001Image.getWidth()))
				&& ((kenbanY4 < points[id].y) && (points[id].y < kenbanY4 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound04.start();
				}
		else if (((kenbanX5 < points[id].x) && (points[id].x < kenbanX5 + piano001Image.getWidth()))
				&& ((kenbanY5 < points[id].y) && (points[id].y < kenbanY5 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound05.start();
				}
		else if (((kenbanX6 < points[id].x) && (points[id].x < kenbanX6 + piano001Image.getWidth()))
				&& ((kenbanY6 < points[id].y) && (points[id].y < kenbanY6 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound06.start();
				}
		else if (((kenbanX7 < points[id].x) && (points[id].x < kenbanX7 + piano001Image.getWidth()))
				&& ((kenbanY7 < points[id].y) && (points[id].y < kenbanY7 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound07.start();
				}
		else if (((kenbanX8 < points[id].x) && (points[id].x < kenbanX8 + piano001Image.getWidth()))
				&& ((kenbanY8 < points[id].y) && (points[id].y < kenbanY8 + piano001Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					sound08.start();
				}
			}
			invalidate();
		}
		return true;
	}
}
			
