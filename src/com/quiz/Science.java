package com.quiz;

import model.EnterData;
import dao.GetData;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Science extends Activity implements OnClickListener {
	
	private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private TextView question;
    private TextView toasttext ;
    private TextView result1;
    private RadioGroup rgroup;
    Dialog myDialog;
    EnterData data=null;
    GetData gt=null;
    SQLiteDatabase db;
    String answer;
	private Button next;
	private Button finish;
	int r=0,w=0,en=0;
	String ans;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science);
        radioButton1  = (RadioButton)findViewById(R.id.option1);
        radioButton2 =(RadioButton)findViewById(R.id.option2);
        radioButton3  = (RadioButton)findViewById(R.id.option3);
        radioButton4 =(RadioButton)findViewById(R.id.option4);
        toasttext=(TextView)findViewById(R.id.toasttext);
        question=(TextView)findViewById(R.id.question);
        rgroup=(RadioGroup)findViewById(R.id.rgroup);
        result1=(TextView)findViewById(R.id.result1);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(this);
        finish=(Button)findViewById(R.id.finish);
        finish.setOnClickListener(this);
       
		data=new EnterData();
		gt=new GetData();
		data=gt.getDataForScience();
		String option1=data.getOption1().toString();
		String option2=data.getOption2().toString();
		String option3=data.getOption3().toString();
		String option4=data.getOption4().toString();
		 answer=data.getAnswer().toString();
		
 		
 		question.setText(data.getQuestion().toString());
 		radioButton1.setText(option1);
 		radioButton2.setText(option2);
 		radioButton3.setText(option3);
 		radioButton4.setText(option4);
    }
	@Override
	public void onClick(View view) {
		
		
		if((view.getId()==R.id.next))
		{
			radioButton1.setEnabled(true);
			radioButton2.setEnabled(true);
			radioButton3.setEnabled(true);
			radioButton4.setEnabled(true);
			
			
			radioButton1.setChecked(false);
			radioButton2.setChecked(false);
			radioButton3.setChecked(false);
			radioButton4.setChecked(false);
			data=new EnterData();
			gt=new GetData();
			data=gt.getDataForScience();
			String option1=data.getOption1().toString();
			String option2=data.getOption2().toString();
			String option3=data.getOption3().toString();
			String option4=data.getOption4().toString();
			 answer=data.getAnswer().toString();
			
	 		
	 		question.setText(data.getQuestion().toString());
	 		radioButton1.setText(option1);
	 		radioButton2.setText(option2);
	 		radioButton3.setText(option3);
	 		radioButton4.setText(option4);
	 		//Toast.makeText(this, "Total Right Answer"+r+"Total Worng Answer"+w, 2).show();
			
		
		 }
		
		if(view.getId()==R.id.finish)
		{
			Intent intent=new Intent();
			intent.setClass(this,MainActivity.class );
			Toast.makeText(this,"Start next activity", 2).show();
			startActivity(intent);
		}
		
	}
	public void onRadioButtonClicked(View v) {
		 		
//	if(en==1)
//	{
//		rgroup.setEnabled(false);
//		radioButton1.setEnabled(false);
//		radioButton2.setEnabled(false);
//		radioButton3.setEnabled(false);
//		radioButton4.setEnabled(false);
//	}
		if((v.getId()==R.id.option1 ))
		{
			
		
			if(radioButton1.isChecked()){
				ans=radioButton1.getText().toString() ;
				if(ans.equals(answer))
				{
					Toast t = Toast.makeText(this, "You Tick Right Answere :"+ans, Toast.LENGTH_SHORT);
					t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
				  	 t.show();
				  	 r++;
				}
			else{
//				String str=("You Tick Worng Answere. The Right Answer is "+answer);
//				toasttext.setText(str);
				radioButton1.setBackgroundColor(2550000);
				Context context = getApplicationContext();
				LayoutInflater inflater = getLayoutInflater();
				 
				View toastRoot = inflater.inflate(R.layout.mytoast, null);
				
				Toast toast = new Toast(context);
				
				toast.setView(toastRoot);
				toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
			  	 w++;
				}
		     }
			String res1=("Your Talent :"+r+"/"+(r+w));
			result1.setText(res1);
			
		} 
		 if(v.getId()==R.id.option2)
		{
			ans=radioButton2.getText().toString() ;
			 if(radioButton2.isChecked()){
				 if(ans.equals(answer))
					{
						Toast t = Toast.makeText(this, "You Tick Right Answere :"+ans, Toast.LENGTH_SHORT);
						t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
					  	 t.show();
					  	 r++;
					}
				else{
					Toast t = Toast.makeText(this, "You Tick Worng Answere. The Right Answer is "+answer, Toast.LENGTH_SHORT);
					t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
				  	 t.show();
				  	 w++;
					} 
				 }
			 String res1=("Your Talent :"+r+"/"+(r+w));
				result1.setText(res1);
		}
	 if(v.getId()==R.id.option3)
		{
			ans=radioButton3.getText().toString() ;
			 if(radioButton3.isChecked()){
				 if(ans.equals(answer))
					{
						Toast t = Toast.makeText(this, "You Tick Right Answere :"+ans, Toast.LENGTH_SHORT);
						t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
					  	 t.show();
					  	 r++;
					}
				else{
					Toast t = Toast.makeText(this, "You Tick Worng Answere. The Right Answer is "+answer, Toast.LENGTH_SHORT);
					t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
				  	 t.show();
				  	 w++;
					}   }
			 String res1=("Your Talent :"+r+"/"+(r+w));
				result1.setText(res1);
		}
	 if(v.getId()==R.id.option4)
		{
			ans=radioButton4.getText().toString() ;
			 if(radioButton4.isChecked()){
				 
				 if(ans.equals(answer))
					{
						Toast t = Toast.makeText(this, "You Tick Right Answere :"+ans, Toast.LENGTH_SHORT);
						t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
					  	 t.show();
					  	 r++;
					}
				else{
					Toast t = Toast.makeText(this, "You Tick Worng Answere. The Right Answer is "+answer, Toast.LENGTH_SHORT);
					t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
				  	 t.show();
				  	 w++;
					} 
		    	 
				// en++;
			 	}
			 String res1=("Your Talent :"+r+"/"+(r+w));
				result1.setText(res1);
		 }
	
	}


}
