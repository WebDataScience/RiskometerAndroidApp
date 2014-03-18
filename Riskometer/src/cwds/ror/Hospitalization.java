package cwds.ror;

import com.example.riskometer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hospitalization extends Activity {
	static String previousHospitalization="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.heart_failure_history);
		
		 final Button yesButton= (Button) findViewById(R.id.yesButtonHospitalScreen);
		 
	        yesButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				previousHospitalization=yesButton.getText().toString();
				startActivity(new Intent(Hospitalization.this,HospitalizationYes.class));
					
				}
			});
	        final Button noButton= (Button) findViewById(R.id.noButtonHospitalScreen);
	        noButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.i("race",Race.userSelectedRace.trim());
				previousHospitalization=noButton.getText().toString();
				startActivity(new Intent(Hospitalization.this,Diabetes.class));
					
				}
			});
	}
	      
}

