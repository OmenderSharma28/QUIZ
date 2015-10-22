package dao;

import java.util.Random;

import model.EnterData;

public class GetQuestionForQuiz {
	int i=1;
	EnterData data=null;
	GetData gt=null;
	public EnterData getQuestion(int i){
	
		
		
		if (i==1||i==6)
		{
		data=new EnterData();
		gt=new GetData();
		data=gt.getDataForIndia();
	
	    }
		else if(i==2 ||i==7)
		{
			data=new EnterData();
			gt=new GetData();
			data=gt.getDataForScience();
			
		}
		else if(i==3 ||i==8)
		{
			data=new EnterData();
			gt=new GetData();
			data=gt.getData();
			
		}
		else if(i==4 ||i==9)
		{
			data=new EnterData();
			gt=new GetData();
			data=gt.getDataForCurrentAffairs();
			
		}
		else if(i==5 )
		{
			data=new EnterData();
			gt=new GetData();
			data=gt.getData();
			
		}
		else if(i==10 )
		{
			data=new EnterData();
			gt=new GetData();
			data=gt.getData();
			i=1;
		}
		
	
		return data;
		
	}
	

}
