package cwds.ror;

import com.example.riskometer.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class Age extends Activity  {
	static StringBuilder userValues=new StringBuilder();
	static String ageInString="";
	int ageInInt;
	AlertDialog ageOutofBounds;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.age_screen);
		final EditText age = (EditText) findViewById(R.id.ageInput);
		final Button nextButton = (Button) findViewById(R.id.nextButtonGenderScreen);
		
		age.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				nextButton.setEnabled(true);
				nextButton.setVisibility(View.VISIBLE);
				ageInString = age.getText().toString();
				Log.i("AGE", ageInString);
				userValues.append("age=");
				userValues.append(ageInString);
				Log.i("SB", userValues.toString());
				startActivity(new Intent(Age.this, Gender.class));
				return false;
			}
		});
	
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(Age.this, Gender.class));

			}
		});

	}
	
	
}
