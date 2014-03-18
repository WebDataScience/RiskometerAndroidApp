package cwds.ror;

import com.example.riskometer.R;


import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class OhSnap extends Activity {
	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.oh_snap_screen);
			Button retry=(Button) findViewById(R.id.retryButton);
			retry.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				Intent i=new Intent(OhSnap.this,WelcomeROR.class);
				startActivity(i);
				finish();
				}
				
			});
		}
}
				
	


