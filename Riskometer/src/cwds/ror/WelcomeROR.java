package cwds.ror;

import com.example.riskometer.R;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeROR extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		/*Boolean bool = isConnected();
		Log.i("Network State", bool.toString());
		if (!bool) {
			
			Toast.makeText(this, "Your Device is not Connected to the Internet",
					Toast.LENGTH_LONG).show();
			Intent i=new Intent(WelcomeROR.this,OhSnap.class);
			startActivity(i);
			finish();
			}
		*/ Button start_Button= (Button) findViewById(R.id.startButtonMainPage);
	        start_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
				startActivity(new Intent(WelcomeROR.this,Age.class));
					
				}
			});
	}

	
	private Boolean isConnected() {
		// TODO Auto-generated method stub
		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo currentNetworkInfo = connectivity.getActiveNetworkInfo();
		return currentNetworkInfo != null && currentNetworkInfo.isConnected();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
