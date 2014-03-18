package cwds.ror;

import com.example.riskometer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Gender extends Activity{
	
	static String userSelectedGender="";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gender_screen);
		
		final Button buttonMale= (Button) findViewById(R.id.maleButtonGenderScreen);
		buttonMale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			userSelectedGender=buttonMale.getText().toString();
			Age.userValues.append("&gender=");
			Age.userValues.append(userSelectedGender);
			Log.i("SB updated",Age.userValues.toString());
			startActivity(new Intent(Gender.this,Race.class));
				
			}
		});

        final Button buttonFemale= (Button) findViewById(R.id.femaleButtonGenderScreen);
        buttonFemale.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		userSelectedGender=buttonFemale.getText().toString();
		Age.userValues.append("&gender=");
		Age.userValues.append(userSelectedGender);
		Log.i("SB updated",Age.userValues.toString());
		startActivity(new Intent(Gender.this,Race.class));
			
		}
	});
	}

}
