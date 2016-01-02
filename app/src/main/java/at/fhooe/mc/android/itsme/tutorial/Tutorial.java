package at.fhooe.mc.android.itsme.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import at.fhooe.mc.android.itsme.HomeScreenActivity;
import at.fhooe.mc.android.itsme.R;


public class Tutorial extends Activity implements View.OnClickListener {

	private static final String TAG = "Itsme";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);

		Button b = null;
		b = (Button)findViewById(R.id.skip);
		b.setOnClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_tutorial, menu);
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

	@Override
	public void onClick(View _view) {
		switch(_view.getId()) {
			case R.id.skip: {
				Intent i = new Intent(Tutorial.this, HomeScreenActivity.class);
				startActivity(i);
				finish();
			}
			break;
			default: {
				Log.i(TAG, "Invalid click encountered in TutorialActivity...");
			}
		}
	}
}
