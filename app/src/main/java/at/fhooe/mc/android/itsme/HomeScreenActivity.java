package at.fhooe.mc.android.itsme;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;


public class HomeScreenActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,
																	No.OnFragmentInteractionListener,
																	Yes.OnFragmentInteractionListener,
																	Question.OnFragmentInteractionListener {

	public FrameLayout home;
	public ActionBar ab;

	public ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	private Fragment f;
	private static final int NUM_PAGES = 3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);

		// ------------------------ VIEW PAGER------------------------
		mPagerAdapter = new HomeScreenPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.home_pager);
		mViewPager.setAdapter(mPagerAdapter);

		mViewPager.setOnPageChangeListener(this);
		mViewPager.setCurrentItem(1);  //question
		home = (FrameLayout)findViewById(R.id.home);

		ab = getActionBar();
		ab.setIcon(R.drawable.itsme);
		ab.setDisplayShowTitleEnabled(false);
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

		Intent i = new Intent(HomeScreenActivity.this, FragmentSwipe.class);
		Bundle bundle = new Bundle();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.tags){
			bundle.putInt("item", 0);
			i.putExtras(bundle);
			startActivity(i);
		    finish();
			return true;
		} else if (id == R.id.profile){
			bundle.putInt("item", 1);
			i.putExtras(bundle);
			startActivity(i);
		    finish();
			return true;
		} else if( id == R.id.news) {
			bundle.putInt("item", 2);
			i.putExtras(bundle);
			startActivity(i);
		    finish();
			return true;
		} else if(id == R.id.matching){
			bundle.putInt("item", 3);
			i.putExtras(bundle);
			startActivity(i);
		    finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	GestureDetector.SimpleOnGestureListener simpleOnGestureListener
			= new GestureDetector.SimpleOnGestureListener(){

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT).show();
			return super.onDoubleTap(e);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
							   float velocityY) {
			String swipe = "";
			float edge = 50;

			// TODO Auto-generated method stub
			if((e1.getX() - e2.getX()) > edge){
				swipe += "Swipe Left\n";
			}else if((e2.getX() - e1.getX()) > edge){
				swipe += "Swipe Right\n";
			}else{
				swipe += "\n";
			}

			if((e1.getY() - e2.getY()) > edge){
				swipe += "Swipe Up\n";
			}else if((e2.getY() - e1.getY()) > edge){
				swipe += "Swipe Down\n";
			}else{
				swipe += "\n";
			}

			Toast.makeText(getApplicationContext(), swipe , Toast.LENGTH_SHORT).show();
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "onLongPress", Toast.LENGTH_SHORT).show();
			super.onLongPress(e);
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
			return super.onSingleTapConfirmed(e);
		}

	};

	GestureDetector gestureDetector
			= new GestureDetector(simpleOnGestureListener);

	@Override
	public void onPageScrolled(int i, float v, int i2) {

	}

	@Override
	public void onPageSelected(int i) {

	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}

	@Override
	public void onFragmentInteraction(Uri uri) {

	}

	private class HomeScreenPagerAdapter extends FragmentStatePagerAdapter {
		public HomeScreenPagerAdapter(FragmentManager fm) {super(fm);}

		@Override
		public Fragment getItem(int pos) {
			f = null;
			switch(pos) {
				case 0:
					f = new No();
					break;
				case 1:
					f = new Question();
					break;
				case 2:
					f = new Yes();
					break;
			}
			return f;
		}

		@Override
		public int getCount() {
			return NUM_PAGES;
		}
	}
}



