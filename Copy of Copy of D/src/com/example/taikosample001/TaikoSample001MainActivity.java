package com.example.taikosample001;

import java.util.ArrayList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TaikoSample001MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//描画クラスのインスタンスを生成
		MyView mView = new MyView(this);
		setContentView(mView);
		
			// LogCatで表示する		
			String message_log = "TEST LOG";		
			Log.i( "TEST", message_log );
			//Dialogで表示する
			String message_dialog = "痩せたい重さをタッチしてね★";
			showDialog( message_dialog );
		}
		
		/**
		 * ダイヤログで文字列を表示する。
		 * @param message　表示したい文字列
		 */
		private void showDialog( String message ){
			new AlertDialog.Builder(this)
			.setMessage(message)
			.setNeutralButton("YES",new DialogInterface.OnClickListener(){
				//この中に"YES"時の処理をいれる
				public void onClick( DialogInterface dialog,int whichButton){
				}
			}).show();
				
		}
	}



class MyView extends View{
	private Bitmap girl00Image;
	private int kenbanX1 = 20;
	private int kenbanY1 = 50;
	private int kenbanX2 = 170;
	private int kenbanY2 = 50;
	private int kenbanX3 = 320;
	private int kenbanY3 = 50;
	
	private Bitmap girl01Image;
	private int kenbanX4 = 20;
	private int kenbanY4 = 220;
	private int kenbanX5 = 170;
	private int kenbanY5 = 220;
	private int kenbanX6 = 320;
	private int kenbanY6 = 220;
	
	private Bitmap girl02Image;
	private int kenbanX7 = 20;
	private int kenbanY7 = 400;
	private int kenbanX8 = 170;
	private int kenbanY8 = 400;
	private int kenbanX9 = 320;
	private int kenbanY9 = 400;
	
	private Bitmap girl03Image;
	private int kenbanX10 = 20;
	private int kenbanY10 = 580;
	private int kenbanX11 = 170;
	private int kenbanY11 = 580;
	private int kenbanX12 = 320;
	private int kenbanY12 = 580;

	
	/**白鍵盤サウンド再生データを保持する。*/
	private MediaPlayer so01;
	private MediaPlayer so02;
	private MediaPlayer so03;
	private MediaPlayer so31;
	private MediaPlayer so32;
	private MediaPlayer so33;
	private MediaPlayer so51;
	private MediaPlayer so52;
	private MediaPlayer so53;
	private MediaPlayer so101;
	private MediaPlayer so102;
	private MediaPlayer so103;
	private MediaPlayer so001;
	
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
		girl00Image = BitmapFactory.decodeResource(res,R.drawable.girl00);
		girl01Image = BitmapFactory.decodeResource(res,R.drawable.girl01);
		girl02Image = BitmapFactory.decodeResource(res,R.drawable.girl02);
		girl03Image = BitmapFactory.decodeResource(res,R.drawable.girl03);
		
		{
		//白鍵盤サウンドデータを読み込む(/res/raw/pon.mp3)
		so01 = MediaPlayer.create( context,R.raw.so01);
		so02 = MediaPlayer.create( context,R.raw.so02);
		so03 = MediaPlayer.create( context,R.raw.so03);
		so31 = MediaPlayer.create( context,R.raw.so31);
		so32 = MediaPlayer.create( context,R.raw.so32);
		so33 = MediaPlayer.create( context,R.raw.so33);
		so51 = MediaPlayer.create( context,R.raw.so51);
		so52 = MediaPlayer.create( context,R.raw.so52);
		so53 = MediaPlayer.create( context,R.raw.so53);
		so101 = MediaPlayer.create( context,R.raw.so101);
		so102 = MediaPlayer.create( context,R.raw.so102);
		so103 = MediaPlayer.create( context,R.raw.so103);
		
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
		canvas.drawColor(0xffffe0e0);
		// 描画するための線の色を設定
				Paint mPaint = new Paint();
				mPaint.setStyle( Paint.Style.FILL);
				mPaint.setColor(0xfffcffc0);
//				mPaint.setAntiAlias( true );
		 
				// 円を描画
				canvas.drawCircle( 47, 50, 18, mPaint );
				canvas.drawCircle( 97, 100, 18, mPaint );
				canvas.drawCircle( 147, 50, 18, mPaint );
				canvas.drawCircle( 197, 100, 18, mPaint );
				canvas.drawCircle( 247, 50, 18, mPaint );
				canvas.drawCircle( 297, 100, 18, mPaint );
				canvas.drawCircle( 347, 50, 18, mPaint );
				canvas.drawCircle( 397, 100, 18, mPaint );
				canvas.drawCircle( 447, 50, 18, mPaint );
				
				canvas.drawCircle( 47, 150, 18, mPaint );
				canvas.drawCircle( 97, 200, 18, mPaint );
				canvas.drawCircle( 147, 150, 18, mPaint );
				canvas.drawCircle( 197, 200, 18, mPaint );
				canvas.drawCircle( 247, 150, 18, mPaint );
				canvas.drawCircle( 297, 200, 18, mPaint );
				canvas.drawCircle( 347, 150, 18, mPaint );
				canvas.drawCircle( 397, 200, 18, mPaint );
				canvas.drawCircle( 447, 150, 18, mPaint );
				
				canvas.drawCircle( 47, 250, 18, mPaint );
				canvas.drawCircle( 97, 300, 18, mPaint );
				canvas.drawCircle( 147, 250, 18, mPaint );
				canvas.drawCircle( 197, 300, 18, mPaint );
				canvas.drawCircle( 247, 250, 18, mPaint );
				canvas.drawCircle( 297, 300, 18, mPaint );
				canvas.drawCircle( 347, 250, 18, mPaint );
				canvas.drawCircle( 397, 300, 18, mPaint );
				canvas.drawCircle( 447, 250, 18, mPaint );
				
				canvas.drawCircle( 47, 350, 18, mPaint );
				canvas.drawCircle( 97, 400, 18, mPaint );
				canvas.drawCircle( 147, 350, 18, mPaint );
				canvas.drawCircle( 197, 400, 18, mPaint );
				canvas.drawCircle( 247, 350, 18, mPaint );
				canvas.drawCircle( 297, 400, 18, mPaint );
				canvas.drawCircle( 347, 350, 18, mPaint );
				canvas.drawCircle( 397, 400, 18, mPaint );
				canvas.drawCircle( 447, 350, 18, mPaint );

				canvas.drawCircle( 47, 450, 18, mPaint );
				canvas.drawCircle( 97, 500, 18, mPaint );
				canvas.drawCircle( 147, 450, 18, mPaint );
				canvas.drawCircle( 197, 500, 18, mPaint );
				canvas.drawCircle( 247, 450, 18, mPaint );
				canvas.drawCircle( 297, 500, 18, mPaint );
				canvas.drawCircle( 347, 450, 18, mPaint );
				canvas.drawCircle( 397, 500, 18, mPaint );
				canvas.drawCircle( 447, 450, 18, mPaint );
				
				canvas.drawCircle( 47, 550, 18, mPaint );
				canvas.drawCircle( 97, 600, 18, mPaint );
				canvas.drawCircle( 147, 550, 18, mPaint );
				canvas.drawCircle( 197, 600, 18, mPaint );
				canvas.drawCircle( 247, 550, 18, mPaint );
				canvas.drawCircle( 297, 600, 18, mPaint );
				canvas.drawCircle( 347, 550, 18, mPaint );
				canvas.drawCircle( 397, 600, 18, mPaint );
				canvas.drawCircle( 447, 550, 18, mPaint );
				
				canvas.drawCircle( 47, 650, 18, mPaint );
				canvas.drawCircle( 97, 710, 18, mPaint );
				canvas.drawCircle( 147, 650, 18, mPaint );
				canvas.drawCircle( 197, 710, 18, mPaint );
				canvas.drawCircle( 247, 650, 18, mPaint );
				canvas.drawCircle( 297, 710, 18, mPaint );
				canvas.drawCircle( 347, 650, 18, mPaint );
				canvas.drawCircle( 397, 710, 18, mPaint );
				canvas.drawCircle( 447, 650, 18, mPaint );
			
		
		//Bitmapイメージの描画
//		Paint mPaint = new Paint();
		canvas.drawBitmap(girl00Image, kenbanX1, kenbanY1,mPaint);
		canvas.drawBitmap(girl00Image, kenbanX2, kenbanY2,mPaint);
		canvas.drawBitmap(girl00Image, kenbanX3, kenbanY3,mPaint);
		canvas.drawBitmap(girl01Image, kenbanX4, kenbanY4,mPaint);
		canvas.drawBitmap(girl01Image, kenbanX5, kenbanY5,mPaint);
		canvas.drawBitmap(girl01Image, kenbanX6, kenbanY6,mPaint);
		canvas.drawBitmap(girl02Image, kenbanX7, kenbanY7,mPaint);
		canvas.drawBitmap(girl02Image, kenbanX8, kenbanY8,mPaint);
		canvas.drawBitmap(girl02Image, kenbanX9, kenbanY9,mPaint);
		canvas.drawBitmap(girl03Image, kenbanX10, kenbanY10,mPaint);
		canvas.drawBitmap(girl03Image, kenbanX11, kenbanY11,mPaint);
		canvas.drawBitmap(girl03Image, kenbanX12, kenbanY12,mPaint);
		
		
			
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
				
			
			
		if(((kenbanX1 <points[id].x ) && (points[id].x < kenbanX1 + girl01Image.getWidth()))
		&& ((kenbanY1 < points[id].y) && (points[id].y < kenbanY1 + girl01Image.getHeight()))){
			//あたり処理
						
				//サウンド再生
				so01.start();
		}

			
		else if(((kenbanX2 < points[id].x) && (points[id].x < kenbanX2 + girl01Image.getWidth()))
		&& ((kenbanY2 < points[id].y) && (points[id].y < kenbanY2 + girl01Image.getHeight()))){
			//あたり処理
			Log.v("ド", "OK");
				//サウンド再生
				so02.start();
			}
		else if (((kenbanX3 < points[id].x) && (points[id].x < kenbanX3 + girl01Image.getWidth()))
		&& ((kenbanY3 < points[id].y) && (points[id].y < kenbanY3 + girl01Image.getHeight()))){
			//あたりの処理
			Log.v("レ", "OK");
			//サウンド再生
			so03.start();
		}
		else if (((kenbanX4 < points[id].x) && (points[id].x < kenbanX4 + girl02Image.getWidth()))
				&& ((kenbanY4 < points[id].y) && (points[id].y < kenbanY4 + girl02Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so31.start();
				}
		else if (((kenbanX5 < points[id].x) && (points[id].x < kenbanX5 + girl02Image.getWidth()))
				&& ((kenbanY5 < points[id].y) && (points[id].y < kenbanY5 + girl02Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so32.start();
				}
		else if (((kenbanX6 < points[id].x) && (points[id].x < kenbanX6 + girl02Image.getWidth()))
				&& ((kenbanY6 < points[id].y) && (points[id].y < kenbanY6 + girl02Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so33.start();
				}
		else if (((kenbanX7 < points[id].x) && (points[id].x < kenbanX7 + girl03Image.getWidth()))
				&& ((kenbanY7 < points[id].y) && (points[id].y < kenbanY7 + girl03Image.getHeight()))){
					//あたりの処理
			
					//サウンド再生
					so51.start();
				}
		else if (((kenbanX8 < points[id].x) && (points[id].x < kenbanX8 + girl03Image.getWidth()))
				&& ((kenbanY8 < points[id].y) && (points[id].y < kenbanY8 + girl03Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so52.start();
				}
		else if (((kenbanX9 < points[id].x) && (points[id].x < kenbanX9 + girl03Image.getWidth()))
				&& ((kenbanY9 < points[id].y) && (points[id].y < kenbanY9 + girl03Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so53.start();
				}
		else if (((kenbanX10 < points[id].x) && (points[id].x < kenbanX10 + girl00Image.getWidth()))
				&& ((kenbanY10 < points[id].y) && (points[id].y < kenbanY10 + girl00Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so101.start();
				}
		else if (((kenbanX11 < points[id].x) && (points[id].x < kenbanX11 + girl00Image.getWidth()))
				&& ((kenbanY11 < points[id].y) && (points[id].y < kenbanY11 + girl00Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so102.start();
				}
		else if (((kenbanX12 < points[id].x) && (points[id].x < kenbanX12 + girl00Image.getWidth()))
				&& ((kenbanY12 < points[id].y) && (points[id].y < kenbanY12 + girl00Image.getHeight()))){
					//あたりの処理
					
					//サウンド再生
					so103.start();
				}
			}
			invalidate();
		}
		return true;
	}
}
			
