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


public class Race extends Activity implements RadioGroup.OnCheckedChangeListener{
	RadioButton rb0;
	RadioButton rb1;	
	RadioButton rb2;	
	RadioButton rb3;	
	RadioButton rb4;	
	RadioButton rb5;	
	RadioButton rb6;	
	RadioButton rb7;
	static String userSelectedRace="";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.race_screen);
		
			final RadioGroup raceRadio = (RadioGroup) findViewById(R.id.racePageRadioGroup);
		// 	Button nextButton= (Button) findViewById(R.id.nextButtonRaceScreen);
		 	rb0 = (RadioButton) findViewById(R.id.radio0);	
			rb1 = (RadioButton) findViewById(R.id.radio1);	
			rb2 = (RadioButton) findViewById(R.id.radio2);	
			rb3 = (RadioButton) findViewById(R.id.radio3);	
			rb4 = (RadioButton) findViewById(R.id.radio4);	
			rb5 = (RadioButton) findViewById(R.id.radio5);	
			rb6 = (RadioButton) findViewById(R.id.radio6);	
			rb7 = (RadioButton) findViewById(R.id.radio7);
		 	raceRadio.setOnCheckedChangeListener(this);
		 	
		 	
		 /*	nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				String rad = String.valueOf(raceRadio.getCheckedRadioButtonId());
				Log.i("after trim",userSelectedRace.trim().replace(" ","%20"));
				startActivity(new Intent(Race.this,Hospitalization.class));
				
					
				}
			});*/
	}

	@Override
	public void onCheckedChanged(RadioGroup raceRadio, int i) {
		if(i==rb0.getId())
		{
		userSelectedRace=rb0.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb1.getId())
		{
		userSelectedRace=rb1.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb2.getId())
		{
		userSelectedRace=rb2.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb3.getId())
		{
		userSelectedRace=rb3.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb4.getId())
		{
		userSelectedRace=rb4.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb5.getId())
		{
		userSelectedRace=rb5.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb6.getId())
		{
		userSelectedRace=rb6.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		setButtonVisibility();
		}
		if(i==rb7.getId())
		{
		userSelectedRace=rb7.getText().toString();
		Log.i("race", userSelectedRace);
		startActivity(new Intent(Race.this,Hospitalization.class));
		
		setButtonVisibility();
		}
	
	}
	private void setButtonVisibility() {
		Button nextButton =(Button) findViewById(R.id.nextButtonRaceScreen);
		 nextButton.setVisibility(View.VISIBLE);
		 nextButton.setEnabled(true);
		 nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				startActivity(new Intent(Race.this,Hospitalization.class));
					
				}
			});
		
	}
	
}
