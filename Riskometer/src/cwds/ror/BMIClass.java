package cwds.ror;

import com.example.riskometer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BMIClass extends Activity {
	
	static String userSelectedBMI="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bmi_screen);
		 final EditText BMI =(EditText) findViewById(R.id.enterdBMI);
		 final Button nextButton= (Button) findViewById(R.id.nextButtonBMIScreen);
		 
		 BMI.setOnEditorActionListener(new OnEditorActionListener() {
				
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				
					nextButton.setVisibility(View.VISIBLE);
					nextButton.setEnabled(true);
					userSelectedBMI=BMI.getText().toString();	
					Log.i("BMI", userSelectedBMI);
					startActivity(new Intent(BMIClass.this, EFVClass.class));
					return false;
				}
			});
		 
		 
		 
	        nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				
				startActivity(new Intent(BMIClass.this,EFVClass.class));
					
				}
			});
	}

}
