package at.fhooe.mc.android.itsme;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class FragmentSwipe extends FragmentActivity implements ViewPager.OnPageChangeListener,Tags.OnFragmentInteractionListener,
		News.OnFragmentInteractionListener,Matching.OnFragmentInteractionListener,Profile.OnFragmentInteractionListener, ActionBar.TabListener {

	/**
	 * The number of pages (wizard steps) to show in this demo.
	 */
	private static final int NUM_PAGES = 4;

	/**
	 * The pager widget, which handles animation and allows swiping horizontally to access previous
	 * and next wizard steps.
	 */
	private ViewPager mViewPager;

	/**
	 * The pager adapter, which provides the pages to the view pager widget.
	 */
	private PagerAdapter mPagerAdapter;

	private Fragment f;
	private ActionBar ab;
	public String[] tabsName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_swipe);

		// ------------------------ VIEW PAGER------------------------
		mPagerAdapter = new FragmentSwipePagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter);

		mViewPager.setOnPageChangeListener(this);

		ab = getActionBar();
		ab.setIcon(R.drawable.logo);
		ab.setDisplayShowTitleEnabled(false);
//		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// ---------------------------ACTION BAR TABS--------------------------

//		tabsName = getResources().getStringArray(R.array.tabs);
//		// Add 4 tabsName, specifying the tab's text and TabListener
//		for(int i = 0; i < NUM_PAGES; i++) {
//			ab.addTab(ab.newTab().setText(tabsName[i]).setTabListener(this));
//		}


		ab.setDisplayHomeAsUpEnabled(true);
		ab.setHomeButtonEnabled(true);
//		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#75c25a")));
		getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
//		ab.setHomeAsUpIndicator(R.drawable.logo);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_fragment_swipe, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.tags) {

			return true;
		} else if(id == R.id.profile){
			return true;
		} else if(id == R.id.matching){
			return true;
		} else if(id == R.id.news){
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

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

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	private class FragmentSwipePagerAdapter extends FragmentStatePagerAdapter {

		public FragmentSwipePagerAdapter(FragmentManager fm) { super(fm);}

		@Override
		public Fragment getItem(int pos) {
			f = null;
			switch(pos) {
				case 0:
					f = new Tags();
					break;
				case 1:
					f = new Profile();
					break;
				case 2:
					f = new News();
					break;
				case 3:
					f = new Matching();
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
