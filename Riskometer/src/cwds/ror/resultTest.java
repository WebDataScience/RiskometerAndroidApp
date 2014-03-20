package cwds.ror;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import com.example.riskometer.R;

import cwds.ror.Age;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class resultTest extends Activity {
	private WebView webview;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		webview = (WebView) findViewById(R.id.webview);
	
		String output = "";
		Boolean bool = isConnected();
		Log.i("Network State", bool.toString());
		if (!bool) {
			
			Toast.makeText(this, "Your Device is not Connected to the Internet",
					Toast.LENGTH_LONG).show();
			Intent i=new Intent(resultTest.this,OhSnap.class);
			startActivity(i);
			finish();
			}
		else{
			try {

				DefaultHttpClient client = new DefaultHttpClient();
				if (android.os.Build.VERSION.SDK_INT > 9) {
					Log.i("BUILD VERSION",
							String.valueOf(android.os.Build.VERSION.SDK_INT));
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
							.permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}
				String test=Age.userValues.toString().trim().replace(" ", "");
				Log.i("SB",test);
				String getURL = "http://charuch-ror.cloudapp.net/RoR?age="
						+ Age.ageInString
						+ "&gender="
						+ Gender.userSelectedGender.trim()
						+ "&ethnicGroup="
						+ Race.userSelectedRace.trim().replace(" ", "")
						+ "&inpatientBMI="
						+ BMIClass.userSelectedBMI
						+ "&diabetes="
						+ Diabetes.userSelectedDiabetesValue
						+ "&stroke="
						+ Stroke.userSelectedStrokeValue
						+"&lengthOfStay="
						+ HospitalizationYes.lengthOfStay
						+ "&priorHospitalization="
						+ Hospitalization.previousHospitalization
						+ "&ejectionFraction="
						+ EFVClass.userSelectedEFV
						+ "&bloodPressureCategory="
						+ BloodPressure.userSelectedBP.trim()
								.replace("<", "%3C").replace(">", "%3E");

				Log.i("URL", getURL);
				HttpGet get = new HttpGet(getURL);
				Log.i("HERE GET", "HERE");
				get.addHeader("accept", "application/json");
				HttpResponse responseGet = client.execute(get);
				Log.i("RESPONSE CODE", String.valueOf(responseGet
						.getStatusLine().getStatusCode()));
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
				String data = "<html>"
						+ "<head>"
						+ "<script type='text/javascript' src='https://www.google.com/jsapi'></script>"
						+ "<script type='text/javascript'>"
						+ "google.load('visualization', '1', {packages:['gauge']});"
						+ " google.setOnLoadCallback(drawChart);"
						+ " function drawChart() {"
						+ " var data = google.visualization.arrayToDataTable(["
						+ " ['Label', 'Value'],"
						+ " ['Probability', "
						+ probability
						+ "],"

						+ " ]); var options = {"
						+ " width: 200, height: 200,"
						+ " redFrom: 75, redTo: 100,"
						+ " yellowFrom:50, yellowTo: 75,"

						+ " minorTicks: 5"
						+ "};"
						+ "var chart = new google.visualization.Gauge(document.getElementById('chart_div'));"
						+ " chart.draw(data, options);" + "  }" + " </script>"
						+ "</head>" + " <body>"
						+ "   <div id='chart_div'></div>" + "  </body>"
						+ "</html>";
				webview.setWebViewClient(new WebViewClient());
				webview.getSettings().setJavaScriptEnabled(true);
				// webview.loadUrl(url);
				webview.loadData(data, "text/html", null);
				outputRP.setText("Probability of Readmission in next 30 days: "
						+ String.valueOf(probability) + "%");
				outputRP.setTextSize(16);
				ViewGroup outputLayout = (ViewGroup) findViewById(R.id.FrameLayout1);
				outputLayout.addView(outputRP);

				JSONObject risks = outputFormat.getJSONObject("riskFactors");
				JSONArray array = risks.getJSONArray("name");
				Log.i("array length", String.valueOf(array.length()));

				ViewGroup RFLayout = (ViewGroup) findViewById(R.id.FrameLayout3);
				TextView riskFactorRP = new TextView(this);
				riskFactorRP.setText("Top Readmission Contributors are:");
				riskFactorRP.setTextSize(18);
				RFLayout.addView(riskFactorRP);
				for (int i = 0; i < array.length(); i++) {
					TextView riskView = new TextView(this);
					Log.i("riskFactors : name " + String.valueOf(i),
							array.getString(i));
					riskView.setText(i+1+") "+array.getString(i).replace("&lt", " < "));
					RFLayout.addView(riskView);
				}

				JSONObject readmissionContributors = outputFormat
						.getJSONObject("readmissionContributors");
				JSONArray array2 = readmissionContributors.getJSONArray("name");
				Log.i("array length", String.valueOf(array2.length()));

				ViewGroup RCLayout = (ViewGroup) findViewById(R.id.FrameLayout2);
				TextView riskContributorsRP = new TextView(this);
				riskContributorsRP.setText("Risk Factors Are:");
				riskContributorsRP.setTextSize(18);
				RCLayout.addView(riskContributorsRP);
				for (int i = 0; i < array2.length(); i++) {
					TextView RCView = new TextView(this);
					RCView.setText(i+1+") "+array2.getString(i));
					RCLayout.addView(RCView);
					Log.i("ReadmissionContributors : name " + String.valueOf(i),
							array2.getString(i));

				}

			} catch (JSONException e1) {

				e1.printStackTrace();
			}
		} 
	}

	private boolean isConnected() {
		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo currentNetworkInfo = connectivity.getActiveNetworkInfo();
		return currentNetworkInfo != null && currentNetworkInfo.isConnected();
	}

}
