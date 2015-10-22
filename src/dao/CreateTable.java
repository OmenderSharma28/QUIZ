package dao;

import android.database.sqlite.SQLiteDatabase;

public class CreateTable {
	
	SQLiteDatabase db=null;
	public void currentTable()
	{
		try {    
			 
			
			 //create table
				db.execSQL("create table currentaffairs ("
					+ " sno integer PRIMARY KEY autoincrement, " 
			        + " question  text, " 
			        + " option1  text, " 
			        + " option2  text, "
			        + " option3  text, "
			        + " option4  text, "
			        + " answer  text);  ");
	    	db.setTransactionSuccessful();
				db.beginTransaction();
		}
		catch(Exception e)
		{
		
		}
		finally {
    		db.endTransaction();
    	}
	}

}
