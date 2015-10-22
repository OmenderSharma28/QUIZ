package com.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener  {
	
	
	private Button current_Affair;
	private Button quiz;
	private Button histary;
	private Button science;
	private Button sports;
	private Button entertainment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        
        
        current_Affair=(Button)findViewById(R.id.current_Affairs);
        current_Affair.setOnClickListener(this);
        quiz=(Button)findViewById(R.id.quiz);
        quiz.setOnClickListener(this);
        
        histary=(Button)findViewById(R.id.histary);
        histary.setOnClickListener(this);
        
        science=(Button)findViewById(R.id.science);
        science.setOnClickListener(this);
        
        sports=(Button)findViewById(R.id.sports);
        sports.setOnClickListener(this);
        
        entertainment=(Button)findViewById(R.id.entertainment);
        entertainment.setOnClickListener(this);
        
    }
	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.current_Affairs)
		{
			Intent intent=new Intent();
			intent.setClass(this,CurrentAffairsActivity.class );
			Toast.makeText(this,"Start next activity", 2).show();
			startActivity(intent);
		}
		
			if(view.getId()==R.id.quiz)
			{
				Intent intent=new Intent();
				intent.setClass(this,LevelActivity.class );
				Toast.makeText(this,"Start Quiz activity", 2).show();
				startActivity(intent);
			}
			if(view.getId()==R.id.histary)
			{
				Intent intent=new Intent();
				intent.setClass(this,Histary.class );
				Toast.makeText(this,"Start Quiz activity", 2).show();
				startActivity(intent);
			}
			if(view.getId()==R.id.science)
			{
				Intent intent=new Intent();
				intent.setClass(this,Science.class );
				Toast.makeText(this,"Start Quiz activity", 2).show();
				startActivity(intent);
			}
			if(view.getId()==R.id.sports)
			{
				Intent intent=new Intent();
				intent.setClass(this,Sports.class );
				Toast.makeText(this,"Start Quiz activity", 2).show();
				startActivity(intent);
			}
			if(view.getId()==R.id.entertainment)
			{
				Intent intent=new Intent();
				intent.setClass(this,Entertainment.class );
				Toast.makeText(this,"Start  activity", 2).show();
				startActivity(intent);
			}
			
		
	}
}
