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

public class BloodPressure extends Activity implements RadioGroup.OnCheckedChangeListener{
	RadioButton rb0;
	RadioButton rb1;	
	RadioButton rb2;	
	RadioButton rb3;	
	RadioButton rb4;	
	RadioButton rb5;	
	RadioButton rb6;	
	RadioButton rb7;
	RadioButton rb8;
	RadioButton rb9;
	static String userSelectedBP="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blood_pressure_screen);
		RadioGroup BPRadioGroup=(RadioGroup) findViewById(R.id.BPRadioGroup);
		rb0=(RadioButton) findViewById(R.id.radio0);
		rb1=(RadioButton) findViewById(R.id.radio1);
		rb2=(RadioButton) findViewById(R.id.radio2);
		rb3=(RadioButton) findViewById(R.id.radio3);
		rb4=(RadioButton) findViewById(R.id.radio4);
		rb5=(RadioButton) findViewById(R.id.radio5);
		rb6=(RadioButton) findViewById(R.id.radio6);
		rb7=(RadioButton) findViewById(R.id.radio7);
		rb8=(RadioButton) findViewById(R.id.radio8);
		rb9=(RadioButton) findViewById(R.id.radio9);
		BPRadioGroup.setOnCheckedChangeListener(this);
			
	       
	}

	@Override
	public void onCheckedChanged(RadioGroup BPRadioGroup, int i) {
		// TODO Auto-generated method stub
		
		if(i==rb0.getId())
		{
		userSelectedBP=rb0.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();
		}
		if(i==rb1.getId())
		{
		userSelectedBP=rb1.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();
		}
		if(i==rb2.getId())
		{
		userSelectedBP=rb2.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();
		}
		if(i==rb3.getId())
		{
		userSelectedBP=rb3.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		if(i==rb4.getId())
		{
		userSelectedBP=rb4.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		if(i==rb5.getId())
		{
		userSelectedBP=rb5.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		if(i==rb6.getId())
		{
		userSelectedBP=rb6.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		if(i==rb7.getId())
		{
		userSelectedBP=rb7.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		if(i==rb8.getId())
		{
		userSelectedBP=rb8.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		if(i==rb9.getId())
		{
		userSelectedBP=rb9.getText().toString();
		Log.i("BP", userSelectedBP);
		startActivity(new Intent(BloodPressure.this,BMIClass.class));
		setButtonVisibility();

		}
		
		
	}

	private void setButtonVisibility() {
		Button nextButton =(Button) findViewById(R.id.nextButtonBPScreen);
		 nextButton.setVisibility(View.VISIBLE);
		 nextButton.setEnabled(true);
		 nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				startActivity(new Intent(BloodPressure.this,BMIClass.class));
					
				}
			});
		
	}

}
