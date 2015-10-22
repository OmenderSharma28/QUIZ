package com.quiz;

import dao.CreateTable;
import dbconnection.DbConnection;
import model.EnterData;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterDataActivity extends Activity implements OnClickListener{
	
	private Button submit;
	private EditText question;
	private EditText option1;
	private EditText option2;
	private EditText option3;
	private EditText option4;
	private EditText answer;
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterdata);
        submit=(Button)findViewById(R.id.submit);
        question=(EditText)findViewById(R.id.question);
        option1=(EditText)findViewById(R.id.option1);
        option2=(EditText)findViewById(R.id.option2);
        option3=(EditText)findViewById(R.id.option3);
        option4=(EditText)findViewById(R.id.option4);
        answer=(EditText)findViewById(R.id.answer);
     
        
        
        submit.setOnClickListener(this);
        
        
       
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.submit)
		{
			try {        	
	        	
	        	
	        	

				 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
				 //create table
					/*db.execSQL("create table currentaffairs  ("
						+ " sno integer PRIMARY KEY autoincrement, " 
				        + " question  text, " 
				        + " option1  text, " 
				        + " option2  text, "
				        + " option3  text, "
				        + " option4  text, "
				        + " answer  text);  ");
		    	db.setTransactionSuccessful();*/
		    	Toast.makeText(this, "  Table were inserted",1).show();
					db.beginTransaction();
				
				
				
		    	try {

		    		//insert rows
		    		EnterData data=new EnterData();
		    		data.setQuestion(question.getText().toString().trim());
		    		data.setOption1(option1.getText().toString().trim());
		    		data.setOption2(option2.getText().toString().trim());
		    		data.setOption3(option3.getText().toString().trim());
		    		data.setOption4(option4.getText().toString().trim());
		    		data.setAnswer(answer.getText().toString().trim());
		    	
		    		
		    		
		    		String question=data.getQuestion();
		    		String option1=data.getOption1();
		    		String option2=data.getOption2();
		    		String option3=data.getOption3();
		    		String option4=data.getOption4();
		    		String answer=data.getAnswer();
		    		

		    		//insert rows
		    	db.execSQL( "insert into currentaffairs(question, option1,option2,option3,option4,answer) "
	    					         + " values ('"+question+"', '"+option1+"','"+option2+"','"+option3+"','"+option4+"','"+answer+"' );" );	    		
//		    	db.execSQL("drop table android_metadata ;");	
//		    	db.execSQL("drop table myquiz; ");
//	    		db.execSQL("drop table sqlite_sequence; ");
//	    		db.execSQL("drop table currentaffairs ;");
	    		
		    		//commit your changes
		    		db.setTransactionSuccessful();
		    		Toast.makeText(this, " 1 records were inserted",1).show();
		    	}
		    	catch (SQLiteException e2) {
		    		//report problem 
		    		Toast.makeText(this, e2.getMessage(),1).show();
		    	}
		    	
		    	
		    	
		    	
		    	
		    	
		    	try {
		    		//hard-coded SQL select with no arguments
					/*String mySQL ="select * from MyTable";
					Cursor c1 = db.rawQuery(mySQL, null);
					int index = c1.getColumnIndex("sno");
					int nameCol = c1.getColumnIndex("name");

					//advance to the next record (first rec. if necessary)
					while (c1.moveToNext()) {
					int theTotal = c1.getInt(index);
					String name=c1.getString(nameCol);
					Toast.makeText(this, "My-Sno: " + theTotal, 1).show();
					Toast.makeText(this, "MyName is " + name, 1).show();
					}*/
				} catch (Exception e) {
					Toast.makeText(this, e.getMessage(), 1).show();
				}    	

		    	
		    	
		    	
		    	
		    	
		    	
		    	finally {
		    		db.endTransaction();
		    	}

	        	
	        	// here you do something with your database
	        	// ... ... ...
	        	db.close();
	        	Toast.makeText(this, "All done!", 1).show();
	        }
	        catch (SQLiteException e) {
	        	 Toast.makeText(this, e.getMessage(), 1).show();        	
	        }
			
		}
	}

}
