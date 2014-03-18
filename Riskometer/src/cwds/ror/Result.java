/*package cwds.ror;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import com.example.riskometer.R;

import cwds.ror.Age;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Result extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.result_screen);
		
		 * genderResultPage.setText("Selected Gender"+Gender.userSelectedGender);
		 * raceResultPage.setText("selected race:"+race.userSelectedRace);
		 * ageResultPage.setText("Selected Age:"+secondActivity.ageInString);
		 * priviousHospitalization
		 * .setText("previous hospitalization:"+hospitalization
		 * .priviousHospitalization);
		 * if(hospitalization.priviousHospitalization.toString().equals("Yes"))
		 * { priviousHosptalizationYes.setText("number of days in hospital:"
		 * +hospitalHistoryYes.lengthOfStay); } else {
		 * priviousHosptalizationYes.setText(""); }
		 * 
		 * strokeResultPage.setText("selected stoke value:"+stroke.
		 * userSelectedStrokeValue);
		 
		String output = "";

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			if (android.os.Build.VERSION.SDK_INT > 9) {
				Log.i("BUILD VERSION",
						String.valueOf(android.os.Build.VERSION.SDK_INT));
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
						.permitAll().build();
				StrictMode.setThreadPolicy(policy);
			}
			String getURL = "http://charuch-ror.cloudapp.net/RoR?age="
					+ Age.ageInString
					+ "&gender="
					+ Gender.userSelectedGender.trim()
					+ "&ethnicGroup="
					+ Race.userSelectedRace.trim().replace(" ","")
					+ "&inpatientBMI="
					+ BMIClass.userSelectedBMI
					+ "&diabetes="
					+ Diabetes.userSelectedDiabetesValue
					+ "&stroke="
					+ Stroke.userSelectedStrokeValue
					+ "&priorHospitalization="
					+ Hospitalization.previousHospitalization
					+ "&ejectionFraction="
					+ EFVClass.userSelectedEFV
					+ "&bloodPressureCategory="
					+ BloodPressure.userSelectedBP.trim().replace("<", "%3C").replace(">", "%3E");

			Log.i("URL", getURL);
			HttpGet get = new HttpGet(getURL);
			Log.i("HERE GET", "HERE");
			get.addHeader("accept", "application/json");
			HttpResponse responseGet = client.execute(get);
			Log.i("RESPONSE CODE",
					String.valueOf(responseGet.getStatusLine().getStatusCode()));
			if (responseGet.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("HTTP Code :"
						+ responseGet.getStatusLine().getStatusCode());
			}

			// responseGet.toString();
			HttpEntity resEntityGet = responseGet.getEntity();
			BufferedReader rdr = new BufferedReader(new InputStreamReader(
					resEntityGet.getContent()));
			String line = "";

			while ((line = rdr.readLine()) != null) {
				output += line;
			}
			// outputRP.setText(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject outputFormat;
		try {
			outputFormat = new JSONObject(output);
			double probability = outputFormat.getDouble("probability");
			TextView outputRP = new TextView(this);
			outputRP.setText("Probability of Readmission in next 30 days: "
					+ String.valueOf(probability) + "%");
	//		ViewGroup outputLayout = (ViewGroup) findViewById(R.id.resultLayout);
			outputLayout.addView(outputRP);
			JSONObject risks = outputFormat.getJSONObject("riskFactors");
			JSONArray array = risks.getJSONArray("name");
			Log.i("array length", String.valueOf(array.length()));
			TextView riskFacetorRP = new TextView(this);
			riskFacetorRP.setText("Top Readmission Contributors are:");
			outputLayout.addView(riskFacetorRP);
			
			for (int i = 0; i < array.length(); i++) {
			TextView riskView = new TextView(this);
				Log.i("riskFactors : name " + String.valueOf(i),
						array.getString(i));
				riskView.setText(array.getString(i));
				outputLayout.addView(riskView);
			}
			
			JSONObject readmissionContributors = outputFormat
					.getJSONObject("readmissionContributors");
			JSONArray array2 = readmissionContributors.getJSONArray("name");
			Log.i("array length", String.valueOf(array2.length()));
			TextView riskContributorsRP = new TextView(this);
			riskContributorsRP.setText("Risk Fators Are:");
			outputLayout.addView(riskContributorsRP);
			// ViewGroup RCLayout=(ViewGroup) findViewById(R.id.resultLayout);
			for (int i = 0; i < array2.length(); i++) {
			TextView RCView = new TextView(this);
				RCView.setText(array2.getString(i));
				outputLayout.addView(RCView);
				Log.i("ReadmissionContributors : name " + String.valueOf(i),
						array2.getString(i));
			
			}
		
		} catch (JSONException e1) {
			
			e1.printStackTrace();
		}
	}

}
*/