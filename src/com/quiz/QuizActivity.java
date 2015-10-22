package com.quiz;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class QuizActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button startbtn;
	private Button exit;
	private Button data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startbtn=(Button)findViewById(R.id.start);
        startbtn.setOnClickListener(this);
        exit=(Button)findViewById(R.id.exit);							
        exit.setOnClickListener(this);
        data=(Button)findViewById(R.id.data);							
        data.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.start)
		{
			Intent intent=new Intent();
			intent.setClass(this,MainActivity.class );
			Toast.makeText(this,"Start next activity", 2).show();
			startActivity(intent);
		}
		if(view.getId()==R.id.exit)
		{
			this.finish();
			
			Toast.makeText(this," activity finish", 2).show();
			
		}
		
		if(view.getId()==R.id.data)
		{
			Intent intent=new Intent();
			intent.setClass(this,EnterDataActivity.class );
			Toast.makeText(this,"Start next activity", 2).show();
			startActivity(intent);
		}
		
	}
}