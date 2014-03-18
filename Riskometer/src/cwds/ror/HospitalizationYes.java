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


public class HospitalizationYes extends Activity{
	static String lengthOfStay="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.length_of_stay_screen);
			final EditText length=(EditText) findViewById(R.id.lengthofstay);
			/*Button start_Button= (Button) findViewById(R.id.nextButtonHospitalStay);
	        start_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				lengthOfStay=length.getText().toString();
				startActivity(new Intent(HospitalizationYes.this,Diabetes.class));
					
				}
			});*/
	        
	        length.setOnEditorActionListener(new OnEditorActionListener() {
				
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				
					lengthOfStay=length.getText().toString();
					startActivity(new Intent(HospitalizationYes.this,Diabetes.class));
					return false;
				}
			});
	}

}
