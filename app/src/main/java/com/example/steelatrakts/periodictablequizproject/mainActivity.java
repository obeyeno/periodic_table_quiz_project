package com.example.steelatrakts.periodictablequizproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class mainActivity extends Activity {
	Button startQuizButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        // button to start quiz and change to periodic table questions layout
		startQuizButton=(Button)findViewById(R.id.button1);

		// setonclicklistener for the button and start activity for  periodic_table_layout
		startQuizButton.setOnClickListener(new OnClickListener() {
			@Override 
			public void onClick(View v) {
	        Intent intent=new Intent(mainActivity.this,periodictableQuestions.class);
	        startActivity(intent);
	        finish();
			}
		});

    }
}