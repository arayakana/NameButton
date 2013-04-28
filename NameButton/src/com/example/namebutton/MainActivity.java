package com.example.namebutton;

import android.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int s = 0;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		Button button = (Button)findViewById(R.id.button1);
		TextView textView=(TextView)findViewById(R.id.textView1);
		
		textView.setText(String.valueOf(s));
		
		button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){//
				s++;
				TextView textView=(TextView)findViewById(R.id.textView1);
				textView.setText(String.valueOf(s));
				
				//
			}
		});
	}


}
