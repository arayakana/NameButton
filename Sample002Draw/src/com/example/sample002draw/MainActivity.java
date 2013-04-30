package com.example.sample002draw;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

//	private static final Context This = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//クラスのインスタンスを生成
			MyView mView = new MyView(this);
		
		//Viewに設定
		setContentView(mView);
	}
}
	
/*
* 描画用のクラス。
*
*/
class MyView extends View {

/*
 * 画像を格納する変数。 */
private Bitmap myBitmap;

/*
 * コンストラクタ。
 * @param contextコンテキスト
 */
	public MyView( Context context) {
	super( context );
		setFocusable( true );
	
	// Resourceインスタンスの生成
	Resources res = this.getContext().getResources();
	// 画像の読み込み(res/drawable/gclue_logo.gif)		
	myBitmap = BitmapFactory.decodeResource( res, R.drawable.gclue_logo );
	}
/** 
 *  描画処理を行う。	 
 */	
@Override	
    protected void onDraw( Canvas canvas ) {
	super.onDraw( canvas );
	
	//背景色を設定
	canvas.drawColor(Color.BLUE); 
	
	//描画するための線の色を設定
	Paint mPaint = new Paint();
	mPaint.setStyle(Paint.Style.FILL);
	mPaint.setARGB(255,255,255,100);
	
	// Bitmapイメージの描画		
	canvas.drawBitmap(myBitmap,0,0,mPaint);
	｝
｝
	
	
	

