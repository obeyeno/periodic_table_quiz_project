package com.example.steelatrakts.periodictablequizproject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class submitQuizAnswers extends Activity {

    // initialize the view

    TextView totalQuestionTextview;
    TextView totalCurrentTextview;
    TextView totalSkippedTextview;
    TextView totalWrongAnswerTextview;
	Button submit;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the view
        setContentView(R.layout.submit_quiz);

        totalQuestionTextview=(TextView)findViewById(R.id.textView1);
        totalCurrentTextview=(TextView)findViewById(R.id.textView2);
        totalSkippedTextview=(TextView)findViewById(R.id.textView3);
        totalWrongAnswerTextview=(TextView)findViewById(R.id.textView4);

        //button to submit all the quiz answers (this could be saved to a
        // database and shown to the user the next time he or she uses the app)
        submit=(Button)findViewById(R.id.button1);

        // get the keys from the intent and assign the values to appropriate textviews
        totalQuestionTextview.setText(getIntent().getExtras().getString("totalquestion"));
        totalCurrentTextview.setText(getIntent().getExtras().getString("totalcorrect"));
        totalSkippedTextview.setText(getIntent().getExtras().getString("totalSkipped"));
        totalWrongAnswerTextview.setText(getIntent().getExtras().getString("totalWrongAnswer"));

        // submit the quiz result and redirect back to main activity
        submit.setOnClickListener(new OnClickListener() {
			@Override
		   public void onClick(View v) {
           Intent intent=new Intent(submitQuizAnswers.this,mainActivity.class);
           startActivity(intent);	
           finish();
		}
		});
    }
}