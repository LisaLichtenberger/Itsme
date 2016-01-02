package at.fhooe.mc.android.itsme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import at.fhooe.mc.android.itsme.tutorial.Tutorial;


public class SplashScreen extends Activity {

	private static final String TAG = "Itsme";
	Handler mHandler = new Handler();
	final String PREFS_NAME = "firstStart";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ActionBar ab = getActionBar();
		ab.hide();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		final SharedPreferences settings = this.getPreferences(Context.MODE_PRIVATE);

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if (settings.getBoolean("firstLaunch", true)) {
					//the app is being launched for first time, do something
					Log.d("Comments", "First time");

					Intent i = new Intent(SplashScreen.this, Tutorial.class);
					startActivity(i);
					finish();

					settings.edit().putBoolean("firstLaunch", false).commit();
				} else {
					Intent i = new Intent(SplashScreen.this, HomeScreenActivity.class);
					startActivity(i);
					finish();
				}

			}
		}, 3000);
	}
}
