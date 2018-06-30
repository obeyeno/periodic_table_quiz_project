package com.example.steelatrakts.periodictablequizproject;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class periodictableQuestions extends Activity {
	Button next;
	Button back;
	Button finish;
	RadioGroup radioGroup;
	RadioButton radiobutton1,radiobutton2,radiobutton3,radiobutton4;
	TextView setquestion;
	int index=0;
	String MyJavaAnswer,UserAnswer="";
	int totalCorrect,totalQues=6,totalSkipped,totalWrong;


	ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.periodic_table_layout);
    
    back=(Button)findViewById(R.id.button1);
    next=(Button)findViewById(R.id.button2);
    finish=(Button)findViewById(R.id.button3);


		radioGroup=(RadioGroup)findViewById(R.id.radioGroup1);
		radiobutton1=(RadioButton)findViewById(R.id.radio0);
		radiobutton2=(RadioButton)findViewById(R.id.radio1);
		radiobutton3=(RadioButton)findViewById(R.id.radio2);
		radiobutton4=(RadioButton)findViewById(R.id.radio3);



		radiobutton1.setChecked(false);
		radiobutton2.setChecked(false);
		radiobutton3.setChecked(false);
		radiobutton4.setChecked(false);

		setquestion=(TextView)findViewById(R.id.textView1);
    back.setVisibility(View.GONE);
    finish.setVisibility(View.GONE);

    set_Your_Ques();
    set_Ques_One();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
	    RadioButton rb=(RadioButton)findViewById(checkedId)	;
			UserAnswer=rb.getText().toString().trim();
		}
	});
    
    back.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
		if(UserAnswer.equals("")){
   			totalSkipped++;
   		}else if(UserAnswer.equals(MyJavaAnswer)){
   			totalCorrect++;
   		}else{
   			totalWrong++;
   		}
		UserAnswer="";
		radiobutton1.setChecked(false);
		radiobutton2.setChecked(false);
		radiobutton3.setChecked(false);
		radiobutton4.setChecked(false);
        back();
    }
    });  
   
    next.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
		// hide back button
	back.setVisibility(View.VISIBLE);
	// check if user anser is empty
    if(UserAnswer.equals("")){
    	// increment total skipped
		totalSkipped++;
	}else if(UserAnswer.equals(MyJavaAnswer)){
		totalCorrect++;
	}else{
		totalWrong++;
	}
		UserAnswer="";
		radiobutton1.setChecked(false);
		radiobutton2.setChecked(false);
		radiobutton3.setChecked(false);
		radiobutton4.setChecked(false);
   	next();
	}
    });

    // setonclicklistener on the finish button
		// pass the values gotten at the end of quiz to an intent using key value pair
    finish.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
	Intent intent=new Intent(periodictableQuestions.this,submitQuizAnswers.class);
	intent.putExtra("totalquestion", "All Question : "+totalQues);
	intent.putExtra("totalcorrect", "Total Currect Question: "+totalCorrect);
	intent.putExtra("totalSkipped", "Total Questions Not answered : "+totalSkipped);
	intent.putExtra("totalWrongAnswer", "Total Wrong Answers : "+totalWrong);
	startActivity(intent);
	finish();
		
	}
    });
}
    // map the questions
    private void set_Ques_One() {
		map=MyArrList.get(index);
		setquestion.setText(map.get("Ques").toString().trim());
		radiobutton1.setText(map.get("A1").toString().trim());
		radiobutton2.setText(map.get("A2").toString().trim());
		radiobutton3.setText(map.get("A3").toString().trim());
		radiobutton4.setText(map.get("A4").toString().trim());
		MyJavaAnswer=map.get("CA1").toString().trim();
		//Toast.makeText(getApplicationContext(),"1"+index,2000).show();
	}

	// method for the next button
	public void next() {
	    if(index==5){
		back.setVisibility(View.GONE);
		next.setVisibility(View.GONE);
		finish.setVisibility(View.VISIBLE);
		}else{
		index++;
		//Toast.makeText(getApplicationContext(),""+index,2000).show();	
		map=MyArrList.get(index);
			setquestion.setText(map.get("Ques").toString().trim());
			radiobutton1.setText(map.get("A1").toString().trim());
			radiobutton2.setText(map.get("A2").toString().trim());
			radiobutton3.setText(map.get("A3").toString().trim());
			radiobutton4.setText(map.get("A4").toString().trim());
			MyJavaAnswer=map.get("CA1").toString().trim();
		}
		
	}
	// method for the back or previous button
    public void back() {
    	if(index==0){
		back.setVisibility(View.GONE);
		finish.setVisibility(View.GONE);
    	}else{
    	index--;
    	map=MyArrList.get(index);
			setquestion.setText(map.get("Ques").toString().trim());
			radiobutton1.setText(map.get("A1").toString().trim());
			radiobutton2.setText(map.get("A2").toString().trim());
			radiobutton3.setText(map.get("A3").toString().trim());
			radiobutton4.setText(map.get("A4").toString().trim());
			MyJavaAnswer=map.get("CA1").toString().trim();
    	}
		
		
	}

	// set the answers based on each question by checking if user answer equals mapped answer (do this for questions 1 -6)
    public void set_Your_Ques() {
    	//Q 1
    	map=new HashMap<String, String>();
		map.put("Ques", "Q1. The first element in the periodic table is ?");
		map.put("A1", "Lithium");
		map.put("A2", "Hydrogen");
		map.put("A3", "Helium");
		map.put("A4", "Oxygen");
		map.put("CA1","Hydrogen");
		MyArrList.add(map);
		//Q 2
    	map=new HashMap<String, String>();
		map.put("Ques", "Q2. The smallest indivisible particle of an element which can take part in a chemical reaction is ?");
		map.put("A1", "Molecule");
		map.put("A2", "Element");
		map.put("A3", "Compound");
		map.put("A4", "Atom");
		map.put("CA1","Atom");
		MyArrList.add(map);
		//Q 1
    	map=new HashMap<String, String>();
		map.put("Ques", "Q3. The symbol for Calcium is ?");
		map.put("A1", "Pa");
		map.put("A2", "Ca");
		map.put("A3", "Cal");
		map.put("A4", "O");
		map.put("CA1","Cal");
		MyArrList.add(map);
		//Q 1
    	map=new HashMap<String, String>();
		map.put("Ques", "Q4. What is the Atomic number of Scandium ?");
		map.put("A1", "19");
		map.put("A2", "12");
		map.put("A3", "21");
		map.put("A4", "8");
		map.put("CA1","21");
		MyArrList.add(map);
		//Q 1
    	map=new HashMap<String, String>();
		map.put("Ques", "Q5. The third element in the periodic table is ?");
		map.put("A1", "Hydrogen");
		map.put("A2", "Sodium");
		map.put("A3", "Lithium");
		map.put("A4", "Fluorine");
		map.put("CA1","Lithium");
		MyArrList.add(map);
		//Q 1
    	map=new HashMap<String, String>();
		map.put("Ques", "Q6. What is the symbol of Manganese ?");
		map.put("A1", "ma");
		map.put("A2", "mg");
		map.put("A3", "Ca");
		map.put("A4", "Ne");
		map.put("CA1","mg");
		MyArrList.add(map);
	}
    
}