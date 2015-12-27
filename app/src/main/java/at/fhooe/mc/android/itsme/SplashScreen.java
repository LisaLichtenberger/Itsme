package at.fhooe.mc.android.itsme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends Activity {

	private static final String TAG = "Itsme";
	Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ActionBar ab = getActionBar();
		ab.hide();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Log.i(TAG, "now in Thread");
				Intent i = new Intent(SplashScreen.this, HomeScreenActivity.class);
				Log.i(TAG, "startActivity");
				startActivity(i);
				finish();
			}
		}, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_home_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
