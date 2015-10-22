package com.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class LevelActivity extends Activity  {
	
	private RadioButton level1;
    private RadioButton level2;
    private RadioButton level3;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        
        level1  = (RadioButton)findViewById(R.id.level1);
        level2 =(RadioButton)findViewById(R.id.level2);
        level3  = (RadioButton)findViewById(R.id.level3);
        
	}
	
	public void onRadioButtonClicked(View v) {
		if((v.getId()==R.id.level1 )||(v.getId()==R.id.level2)||(v.getId()==R.id.level3))
		{
		
			Intent intent=new Intent();
			intent.setClass(this,QuizStartActivity.class );
			Toast.makeText(this,"Start Quiz activity", 2).show();
			startActivity(intent);
		}    
	}
}
