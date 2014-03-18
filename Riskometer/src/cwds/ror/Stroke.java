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

public class Stroke extends Activity {

	
/*	RadioButton rb0;	
	RadioButton rb1;
	*/
	static String userSelectedStrokeValue="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stroke_screen);
		final Button strokeYes= (Button) findViewById(R.id.strokeYesButton);
		final Button strokeNo=(Button) findViewById(R.id.strokeNoButton);
		
		strokeYes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userSelectedStrokeValue=strokeYes.getText().toString();			
				startActivity(new Intent(Stroke.this,BloodPressure.class));
			}
		});
		strokeNo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userSelectedStrokeValue=strokeNo.getText().toString();			
				startActivity(new Intent(Stroke.this,BloodPressure.class));
			}
		});
		/*RadioGroup strokeRadio=(RadioGroup) findViewById(R.id.strokeRadioGroup);
		
		rb0 = (RadioButton) findViewById(R.id.strokeRadioButtonYes);	
		rb1 = (RadioButton) findViewById(R.id.strokeRadioButtonNo);	
		
		strokeRadio.setOnCheckedChangeListener(this);
		/* Button start_Button= (Button) findViewById(R.id.NextButtonStrokeScreen);
	        start_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				startActivity(new Intent(Stroke.this,BloodPressure.class));
					
				}
			});
	}
	@Override
	public void onCheckedChanged(RadioGroup strokeRadio, int j) {
		Log.i("hello","i'm here");
		if(j==rb0.getId())
		{
		userSelectedStrokeValue = rb0.getText().toString();
		Log.i("Stroke", userSelectedStrokeValue);
		startActivity(new Intent(Stroke.this,BloodPressure.class));
		}
		else if(j==rb1.getId())
		{
		userSelectedStrokeValue=rb1.getText().toString();
		Log.i("Stroke", userSelectedStrokeValue);
		startActivity(new Intent(Stroke.this,BloodPressure.class));
		}
		
	}*/
	}	
	
}