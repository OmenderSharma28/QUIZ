package dao;

import java.util.Random;

import model.EnterData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class GetData {
	SQLiteDatabase db=null;
	EnterData data=null;
	Cursor cur=null;
	
	
	public EnterData getData()
	{
		try {    
			 
			 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
			 
				db.beginTransaction();	
		    	try {
		    		//hard-coded SQL select with no arguments
		    		//String [] columns ={"sno","question", "option1", "option2","option3","option4","answer"};
		    		Random rand = new Random();
		    		  int num = rand.nextInt(124);
					String mySQL ="select question,option1,option2,option3,option4,answer from Sports where sno="+num+" ";
					Cursor cur = db.rawQuery(mySQL, null);
		    		
					
			 //cur=db.query("currentaffairs", columns,null, null, null, null, "sno");
					
					int index = cur.getColumnIndex("sno");
					int option2=cur.getColumnIndex("option2"); 
					int option3=cur.getColumnIndex("option3"); 
					int option4=cur.getColumnIndex("option4");
					int question = cur.getColumnIndex("question");
					int option1=cur.getColumnIndex("option1"); 
					int answer=cur.getColumnIndex("answer");
					

					//advance to the next record (first rec. if necessary)
					if(cur.moveToNext())
					{
						
						data=new EnterData();
						
					data.setQuestion(cur.getString(question));
					data.setOption1(cur.getString(option1));
					data.setOption2(cur.getString(option2));
					data.setOption3(cur.getString(option3));
					data.setOption4(cur.getString(option4));
					data.setAnswer(cur.getString(answer));
					}
					
					
				} catch (Exception e) {
					
				}    	
				finally {
		    		db.endTransaction();
		    	}

	        	
	        	// here you do something with your database
	        	// ... ... ...
	        	db.close();
	        	
	        }
	        catch (SQLiteException e) {
	        	         	
	        }
		return data;
		}

	public EnterData getDataForIndia()
	{
		try {    
			 
			 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
			 
				db.beginTransaction();	
		    	try {
		    		//hard-coded SQL select with no arguments
		    		//String [] columns ={"sno","question", "option1", "option2","option3","option4","answer"};
		    		Random rand = new Random();
		    		  int num = rand.nextInt(274);
					String mySQL ="select question,option1,option2,option3,option4,answer from Indian where sno="+num+" ";
					Cursor cur = db.rawQuery(mySQL, null);
		    		
					
			 //cur=db.query("currentaffairs", columns,null, null, null, null, "sno");
					
					int index = cur.getColumnIndex("sno");
					int option2=cur.getColumnIndex("option2"); 
					int option3=cur.getColumnIndex("option3"); 
					int option4=cur.getColumnIndex("option4");
					int question = cur.getColumnIndex("question");
					int option1=cur.getColumnIndex("option1"); 
					int answer=cur.getColumnIndex("answer");
					

					//advance to the next record (first rec. if necessary)
					if(cur.moveToNext())
					{data=new EnterData();
					data.setQuestion(cur.getString(question));
					data.setOption1(cur.getString(option1));
					data.setOption2(cur.getString(option2));
					data.setOption3(cur.getString(option3));
					data.setOption4(cur.getString(option4));
					data.setAnswer(cur.getString(answer));
					}
					
					
				} catch (Exception e) {
					
				}    	

		    	finally {
		    		db.endTransaction();
		    	}

	        	
	        	// here you do something with your database
	        	// ... ... ...
	        	db.close();
	        	
	        }
	        catch (SQLiteException e) {
	        	         	
	        }
		return data;
		}
	
	
	
	public EnterData getDataForScience()
	{
		try {    
			 
			 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
			 
				db.beginTransaction();	
		    	try {
		    		//hard-coded SQL select with no arguments
		    		//String [] columns ={"sno","question", "option1", "option2","option3","option4","answer"};
		    		Random rand = new Random();
		    		  int num = rand.nextInt(3);
					String mySQL ="select question,option1,option2,option3,option4,answer from Science where sno="+num+" ";
					Cursor cur = db.rawQuery(mySQL, null);
		    		
					
			 //cur=db.query("currentaffairs", columns,null, null, null, null, "sno");
					
					int index = cur.getColumnIndex("sno");
					int option2=cur.getColumnIndex("option2"); 
					int option3=cur.getColumnIndex("option3"); 
					int option4=cur.getColumnIndex("option4");
					int question = cur.getColumnIndex("question");
					int option1=cur.getColumnIndex("option1"); 
					int answer=cur.getColumnIndex("answer");
					

					//advance to the next record (first rec. if necessary)
					if(cur.moveToNext())
					{data=new EnterData();
					data.setQuestion(cur.getString(question));
					data.setOption1(cur.getString(option1));
					data.setOption2(cur.getString(option2));
					data.setOption3(cur.getString(option3));
					data.setOption4(cur.getString(option4));
					data.setAnswer(cur.getString(answer));
					}
					
					
				} catch (Exception e) {
					
				}    	

		    	finally {
		    		db.endTransaction();
		    	}

	        	
	        	// here you do something with your database
	        	// ... ... ...
	        	db.close();
	        	
	        }
	        catch (SQLiteException e) {
	        	         	
	        }
		return data;
		}
	
	
	
	
	public EnterData getDataForCurrentAffairs()
	{
		try {    
			 
			 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
			 
				db.beginTransaction();	
		    	try {
		    		//hard-coded SQL select with no arguments
		    		//String [] columns ={"sno","question", "option1", "option2","option3","option4","answer"};
		    		Random rand = new Random();
		    		  int num = rand.nextInt(7);
					String mySQL ="select question,option1,option2,option3,option4,answer from currentaffairs where sno="+num+" ";
					Cursor cur = db.rawQuery(mySQL, null);
		    		
					
			 //cur=db.query("currentaffairs", columns,null, null, null, null, "sno");
					
					int index = cur.getColumnIndex("sno");
					int option2=cur.getColumnIndex("option2"); 
					int option3=cur.getColumnIndex("option3"); 
					int option4=cur.getColumnIndex("option4");
					int question = cur.getColumnIndex("question");
					int option1=cur.getColumnIndex("option1"); 
					int answer=cur.getColumnIndex("answer");
					

					//advance to the next record (first rec. if necessary)
					if(cur.moveToNext())
					{data=new EnterData();
					data.setQuestion(cur.getString(question));
					data.setOption1(cur.getString(option1));
					data.setOption2(cur.getString(option2));
					data.setOption3(cur.getString(option3));
					data.setOption4(cur.getString(option4));
					data.setAnswer(cur.getString(answer));
					}
					} catch (Exception e) {
					
				}    	
				finally {
		    		db.endTransaction();
		    	}

	        	
	        	// here you do something with your database
	        	// ... ... ...
	        	db.close();
	        	
	        }
	        catch (SQLiteException e) {
	        	         	
	        }
		return data;
		}
	
	
	
	}


