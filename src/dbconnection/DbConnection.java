package dbconnection;

import android.database.sqlite.SQLiteDatabase;

public class DbConnection {
	SQLiteDatabase db;
	
	public void connection()
	{	
		try {    
			 
			 db= SQLiteDatabase.openDatabase("/data/data/com.quiz/databases/myquizDB",null,SQLiteDatabase.CREATE_IF_NECESSARY);
			 //create table
				/*db.execSQL("create table myquiz ("
					+ " sno integer PRIMARY KEY autoincrement, " 
			        + " question  text, " 
			        + " option1  text, " 
			        + " option2  text, "
			        + " option3  text, "
			        + " option4  text, "
			        + " answer  text);  ");
	    	db.setTransactionSuccessful();*/
				db.beginTransaction();
		}
		catch(Exception e)
		{
		
		}
	}

}
