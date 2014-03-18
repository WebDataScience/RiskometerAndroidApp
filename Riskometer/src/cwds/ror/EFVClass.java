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

public class EFVClass extends Activity {
	static String userSelectedEFV="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.efv_screen);
		final EditText EFVValue=(EditText) findViewById(R.id.enteredEFV);
		
		
		/*EFVValue.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO Auto-generated method stub
				userSelectedEFV=EFVValue.getText().toString();
				Log.i("EFV", userSelectedEFV);
				startActivity(new Intent(EFVClass.this,Result.class));
				return false;
			}
		});
		
		*/
		Button calculate_risk_Button= (Button) findViewById(R.id.calculateRiskButton);
	        calculate_risk_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				userSelectedEFV=EFVValue.getText().toString();
				startActivity(new Intent(EFVClass.this,resultTest.class));
					
				}
			});
	}

}
