package com.quiz;



import java.util.Random;

import model.EnterData;
import dao.GetData;
import dao.GetQuestionForQuiz;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizStartActivity extends Activity implements OnClickListener   {
	
	private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private TextView question;
    private TextView toasttext ;
    private RadioGroup rgroup;
    private Button next;
    ProgressBar bar1;
    TextView timer;
    GetData gt;
    Dialog myDialog;
    GetQuestionForQuiz getQuestionForQuiz=null;
    EnterData data=null;
	int i=0;
	boolean isRunning = false;
	final int MAX_SEC =  30;
	String ans,answer;
	int intTest = 0;
	
	// -----------------------------------------------------------------------
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			String returnedValue = (String)msg.obj;
			//do something with the value sent by the background thread here
			//....
			
			
			bar1.incrementProgressBy(2);

			//testing early termination
			if (bar1.getProgress() == MAX_SEC){		
				
				isRunning = false;
			}
			
			if (bar1.getProgress() == bar1.getMax()){
				timer.setText("Done");
				finish();
				bar1.setVisibility(View.INVISIBLE);
				
				
			}
			else {
				timer.setText("Time.." +
						bar1.getProgress() );
			}
					
		}
	}; //handler
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizstart);
        radioButton1  = (RadioButton)findViewById(R.id.option1);
        radioButton2 =(RadioButton)findViewById(R.id.option2);
        radioButton3  = (RadioButton)findViewById(R.id.option3);
        radioButton4 =(RadioButton)findViewById(R.id.option4);
        question=(TextView)findViewById(R.id.question);
        rgroup=(RadioGroup)findViewById(R.id.rgroup);
        bar1 = (ProgressBar) findViewById(R.id.progress);
        timer=(TextView)findViewById(R.id.timer);
        bar1.setMax(MAX_SEC);
		bar1.setProgress(0);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(this);
       }
    
    
    public void onStart() {
		super.onStart();
		
		//bar1.setProgress(0);
		Thread background = new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < MAX_SEC && isRunning; i++) {		
						//try a Toast method here (will not work!)
						//fake busy busy work here
						Thread.sleep(1000);  //one second at a time
						Random rnd = new Random();
						
						// this is a locally generated value
						String data = "Thread Value: " + (int) rnd.nextInt(101);
					
						//we can see and change (global) class variables
						data += "\n " + intTest;
						intTest++;
						
						//request a message token and put some data in it 
						Message msg = handler.obtainMessage(1, (String)data);
						
						// if thread is still alive send the message					
						if (isRunning) {
							handler.sendMessage(msg);
						}
					}
				} catch (Throwable t) {
					// just end the background thread
				}
			}
		});
		isRunning = true;
		background.start();
	}//onStart

	
    
    
    
	public void onRadioButtonClicked(View v) {
		i++;
		if((v.getId()==R.id.option1 ))
		{
		
			if(radioButton1.isChecked()){
				
				myDialog = new Dialog(QuizStartActivity.this);
			       myDialog.setContentView(R.layout.mydialog);
		           myDialog.setTitle("Your Answer");
		           myDialog.setCancelable(true);
		           Button button1 = (Button) myDialog.findViewById(R.id.Btn1);
		           Button button2 = (Button) myDialog.findViewById(R.id.Btn2);
		           button1.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							getQuestionForQuiz=new GetQuestionForQuiz();
							data=getQuestionForQuiz.getQuestion(i);
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
							
							 myDialog.dismiss();
						
					        
					}
					});
		           button2.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           myDialog.show();
//				ans=radioButton1.getText().toString() ;
//				Toast t = Toast.makeText(this, "You Tick Worng Answere. The Right Answer is Riset -1", Toast.LENGTH_SHORT);
//				t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
//			  	 t.show();
		    	 
		     }
			
		} 
		if(v.getId()==R.id.option2)
		{
			 if(radioButton2.isChecked()){
				 
				 myDialog = new Dialog(QuizStartActivity.this);
			       myDialog.setContentView(R.layout.mydialog);
		           myDialog.setTitle("Your Answer");
		           myDialog.setCancelable(true);
		           Button button1 = (Button) myDialog.findViewById(R.id.Btn1);
		           Button button2 = (Button) myDialog.findViewById(R.id.Btn2);
		           button1.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           button2.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           myDialog.show();
		    	 ans=radioButton2.getText().toString() ;
		    	 Toast.makeText(this, "You Tick Worng Answere. The Right Answer is Riset -1", 2).show();
		     }
		}
		if(v.getId()==R.id.option3)
		{
			 if(radioButton3.isChecked()){
				 myDialog = new Dialog(QuizStartActivity.this);
			       myDialog.setContentView(R.layout.mydialog);
		           myDialog.setTitle("Your Answer");
		           myDialog.setCancelable(true);
		           Button button1 = (Button) myDialog.findViewById(R.id.Btn1);
		           Button button2 = (Button) myDialog.findViewById(R.id.Btn2);
		           button1.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           button2.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           myDialog.show();
				ans=radioButton3.getText().toString() ;
				Toast.makeText(this, "You Tick Worng Answere. The Right Answer is Riset -1", 2).show();
		   }
		}
		if(v.getId()==R.id.option4)
		{
			 if(radioButton4.isChecked()){
				 myDialog = new Dialog(QuizStartActivity.this);
			       myDialog.setContentView(R.layout.mydialog);
		           myDialog.setTitle("Your Answer");
		           myDialog.setCancelable(true);
		           Button button1 = (Button) myDialog.findViewById(R.id.Btn1);
		           Button button2 = (Button) myDialog.findViewById(R.id.Btn2);
		           button1.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
						
							 myDialog.dismiss();
					        
					}

						
					});
		           button2.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							
							
							 myDialog.dismiss();
					        
					}
					});
		           myDialog.show();
		           
		    	 ans= radioButton4.getText().toString() ;
		    	 Toast.makeText(this, " You Tick Right Answere :"+ans, 2).show();
		    	 
			 	}
		 }
		
	
		
		
	}




	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
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
			data=gt.getDataForIndia();
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
		
	}

	public void onStop() {
		super.onStop();
		isRunning = false;
	}
         
    


}
