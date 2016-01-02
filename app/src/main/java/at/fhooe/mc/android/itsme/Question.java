package at.fhooe.mc.android.itsme;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Question.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Question#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";
	private static final String TAG = "Itsme" ;

	private Context context;
	private View fragment_view;

	private float startXcoordinate,startYcoordinate,endXcoordinate,endYcoordinate;

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private OnFragmentInteractionListener mListener;

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment Question.
	 */
	// TODO: Rename and change types and number of parameters
	public static Question newInstance(String param1, String param2) {
		Question fragment = new Question();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	public Question() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		fragment_view = inflater.inflate(R.layout.fragment_question, container,false);
		fragment_view.setOnTouchListener(new View.OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event) {
				String swipe = "";
				float edge = 50;

				if(event.getAction() == MotionEvent.ACTION_DOWN){
					startXcoordinate = event.getX();
					startYcoordinate = event.getY();
				} else if(event.getAction() == MotionEvent.ACTION_UP){
					endXcoordinate = event.getX();
					endYcoordinate = event.getY();

//					if((startXcoordinate - endXcoordinate) > edge){
//						swipe += "Swipe Left\n";
//					}else if((endXcoordinate - startXcoordinate) > edge){
//						swipe += "Swipe Right\n";
//					}else{
//						swipe += "\n";
//					}

					if((startYcoordinate - endYcoordinate) > edge){
						swipe += "Swipe Up";
					}else if((endYcoordinate - startYcoordinate) > edge){
						swipe += "Swipe Down";
					}else{
						swipe += "\n";
					}

					startXcoordinate = 0;
					startYcoordinate = 0;
					endXcoordinate = 0;
					endYcoordinate = 0;

					Toast.makeText(getActivity(), swipe , Toast.LENGTH_SHORT).show();
					Log.i(TAG, swipe);
				}
				return true;
			}
		});
		return fragment_view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
			context = activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p/>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onFragmentInteraction(Uri uri);
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		// TODO Auto-generated method stub
//		return gestureDetector.onTouchEvent(event);
//	}

	GestureDetector.SimpleOnGestureListener simpleOnGestureListener
			= new GestureDetector.SimpleOnGestureListener(){

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "onDoubleTap", Toast.LENGTH_SHORT).show();
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

			Toast.makeText(getActivity(), swipe , Toast.LENGTH_SHORT).show();
			Log.i(TAG, swipe);
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity() , "onLongPress", Toast.LENGTH_SHORT).show();
			super.onLongPress(e);
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
			return super.onSingleTapConfirmed(e);
		}

	};

	GestureDetector gestureDetector
			= new GestureDetector(simpleOnGestureListener);

}
