package cwds.ror;


import com.example.riskometer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Diabetes extends Activity {
	/*RadioButton rb0;
	RadioButton rb1;	
	*/
	static String userSelectedDiabetesValue="";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diabetes_screen);
		final Button diabetesYes=(Button) findViewById(R.id.diabetesYesButton);
		final Button diabetesNo=(Button) findViewById(R.id.diabetesNoButton);
		
		diabetesYes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userSelectedDiabetesValue=diabetesYes.getText().toString();
				startActivity(new Intent(Diabetes.this,Stroke.class));
			}
		});
		
		diabetesNo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userSelectedDiabetesValue=diabetesNo.getText().toString();
				startActivity(new Intent(Diabetes.this,Stroke.class));
			}
		});
		/*RadioGroup diabetesRadio=(RadioGroup) findViewById(R.id.diabetesRadioGroup);
	
		rb0 = (RadioButton) findViewById(R.id.diabetesRadioButtonYes);	
		rb1 = (RadioButton) findViewById(R.id.diabetesRadioButtonNo);	
	
		
		diabetesRadio.setOnCheckedChangeListener(this);
		Button start_Button= (Button) findViewById(R.id.NextButtonDiabetesScreen);
	        start_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				startActivity(new Intent(Diabetes.this,Stroke.class));
					
				}
			});
	}
	@Override
	public void onCheckedChanged(RadioGroup diabetesRadio, int i) {
		if(i==rb0.getId())
		{
		userSelectedDiabetesValue=rb0.getText().toString();
		Log.i("diabetes", userSelectedDiabetesValue);
		startActivity(new Intent(Diabetes.this,Stroke.class));
		}
		else if(i==rb1.getId())
		{
		userSelectedDiabetesValue=rb1.getText().toString();
		Log.i("diabetes", userSelectedDiabetesValue);
		startActivity(new Intent(Diabetes.this,Stroke.class));
		}
		*/
	}

}
