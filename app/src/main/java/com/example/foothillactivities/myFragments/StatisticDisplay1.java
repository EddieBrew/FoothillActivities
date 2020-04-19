package com.example.foothillactivities.myFragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.foothillactivities.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatisticDisplay1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatisticDisplay1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticDisplay1 extends Fragment implements View.OnClickListener {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private TextView numberWalkUpTextView, numberTrespassersTextView, numberFeltLakeTextView;
	private TextView numberOffTrailTextView, numberForbiddenItemsTextView, numberPetsTextView;

	private OnFragmentInteractionListener mListener;



	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		//void onFragmentInteraction(Uri uri);

		public void resetActivityPage2();
	}



	public StatisticDisplay1() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment StatisticDisplay1.
	 */
	// TODO: Rename and change types and number of parameters
	public static StatisticDisplay1 newInstance(String param1, String param2) {
		StatisticDisplay1 fragment = new StatisticDisplay1();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_statistic_display1, container, false);

		Button incrementFeltLakebtn = view.findViewById(R.id.incrementCoyotesbtn);
		incrementFeltLakebtn.setOnClickListener(this);

		numberFeltLakeTextView = view.findViewById(R.id.numberFeltLakeTextView);//decrements count
		numberFeltLakeTextView.setOnClickListener(this);

		Button incrementPetsbtn = view.findViewById(R.id.incrementPetsbtn);
		incrementPetsbtn.setOnClickListener(this);

		numberPetsTextView = view.findViewById(R.id.numberBikesTaggedTextView);
		numberPetsTextView.setOnClickListener(this);

		Button incrementOffTrailbtn = view.findViewById(R.id.incrementMountainLionsbtn);
		incrementOffTrailbtn.setOnClickListener(this);

		numberOffTrailTextView = view.findViewById(R.id.numberOffTrailTextView);
		numberOffTrailTextView.setOnClickListener(this);

		Button incrementForbiddenItemsbtn = view.findViewById(R.id.incrementForbiddenItemsbtn);
		incrementForbiddenItemsbtn.setOnClickListener(this);

		numberForbiddenItemsTextView = view.findViewById(R.id.numberWorkingDogsTextView);
		numberForbiddenItemsTextView.setOnClickListener(this);

		Button incrementWalkUpsbtn = view.findViewById(R.id.incrementWalkUpsbtn);
		incrementWalkUpsbtn.setOnClickListener(this);

		numberWalkUpTextView = view.findViewById(R.id.numberWalkUpTextView);
		numberWalkUpTextView.setOnClickListener(this);

		Button incrementTrespassersbtn = view.findViewById(R.id.incrementTrespassersbtn);
		incrementTrespassersbtn.setOnClickListener(this);

		numberTrespassersTextView = view.findViewById(R.id.numberTrespassersTextView);
		numberTrespassersTextView.setOnClickListener(this);

		Button resetBtn = view.findViewById(R.id.resetBtn);
		resetBtn.setOnClickListener(this);

		return view;
	}
	@Override
	public void onClick(View view) {
		int buttonSelector;
		switch(view.getId()){
			case R.id.incrementCoyotesbtn:
				buttonSelector = 0;
				increment(buttonSelector);
				break;
			case R.id.numberFeltLakeTextView:
				buttonSelector = 0;
				decrement(buttonSelector);
				break;
			case  R.id.incrementPetsbtn:
				buttonSelector = 1;
				increment(buttonSelector);
				break;
			case R.id.numberBikesTaggedTextView:
				buttonSelector = 1;
				decrement(buttonSelector);
				break;
			case R.id.incrementMountainLionsbtn:
				buttonSelector = 2;
				increment(buttonSelector);
				break;
			case R.id.numberOffTrailTextView:
				buttonSelector = 2;
				decrement(buttonSelector);
				break;
			case R.id.incrementForbiddenItemsbtn:
				buttonSelector = 3;
				increment(buttonSelector);
				break;
			case R.id.numberWorkingDogsTextView:
				buttonSelector = 3;
				decrement(buttonSelector);
				break;
			case R.id.incrementWalkUpsbtn:
				buttonSelector = 4;
				increment(buttonSelector);
				break;
			case R.id.numberWalkUpTextView:
				buttonSelector = 4;
				decrement(buttonSelector);
				break;
			case R.id.incrementTrespassersbtn:
				buttonSelector = 5;
				increment(buttonSelector);
				break;
			case R.id.numberTrespassersTextView:
				buttonSelector = 5;
				decrement(buttonSelector);
				break;
			case R.id.resetBtn:
				playSpecificSound(R.raw.resetbeep);
				onButtonPressed();
				break;

			default:
		}


	}
	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed() {
		if (mListener != null) {
			mListener.resetActivityPage2();
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}


	/*********************************************************************************
	 *  increment() increments the counters
	 * @pre none
	 * @parameter none
	 * @post none
	 **********************************************************************************/
	public void increment(int selector){
		switch(selector){
			case 0:
				int feltLakeNumber =  Integer.parseInt((String) numberFeltLakeTextView.getText());
				feltLakeNumber++;
				numberFeltLakeTextView.setText(String.valueOf(feltLakeNumber));
				break;
			case 1:

				int animalNumber =  Integer.parseInt((String) numberPetsTextView.getText());
				animalNumber++;
				numberPetsTextView.setText(String.valueOf(animalNumber));
				break;
			case 2:

				int offTrailNumber =  Integer.parseInt((String) numberOffTrailTextView.getText());
				offTrailNumber++;
				numberOffTrailTextView.setText(String.valueOf(offTrailNumber));
				break;
			case 3:
				int forbiddenNumber =  Integer.parseInt((String) numberForbiddenItemsTextView.getText());
				forbiddenNumber++;
				numberForbiddenItemsTextView.setText(String.valueOf(forbiddenNumber));
				break;
			case 4:
				int walkUpNumber =  Integer.parseInt((String) numberWalkUpTextView.getText());
				walkUpNumber++;
				numberWalkUpTextView.setText(String.valueOf(walkUpNumber));
				break;
			case 5:
				int trespassersNumber =  Integer.parseInt((String) numberTrespassersTextView.getText());
				trespassersNumber++;
				numberTrespassersTextView.setText(String.valueOf(trespassersNumber));
				break;
		}
		playSpecificSound(R.raw.incrementbeep);
	}


	/*********************************************************************************
	 *  decrement() increments the counters
	 * @pre none
	 * @parameter none
	 * @post none
	 **********************************************************************************/
	public void decrement(int selector){
		switch(selector){
			case 0:
				int feltLakeNumber =  Integer.parseInt((String) numberFeltLakeTextView.getText());
				feltLakeNumber--;
				if(feltLakeNumber < 0){//prevents displaying a negative number
					numberFeltLakeTextView.setText("0");
					feltLakeNumber = 0;
				}else {
					numberFeltLakeTextView.setText(String.valueOf(feltLakeNumber));
				}
				break;
			case 1:
				int animalNumber =  Integer.parseInt((String) numberPetsTextView.getText());
				animalNumber--;
				if(animalNumber < 0){//prevents displaying a negative number
					numberPetsTextView.setText("0");
					animalNumber = 0;
				}else {
					numberPetsTextView.setText(String.valueOf(animalNumber));
				}
				break;
			case 2:
				int offTrailNumber =  Integer.parseInt((String) numberOffTrailTextView.getText());
				offTrailNumber--;
				if(offTrailNumber < 0){//prevents displaying a negative number
					numberOffTrailTextView.setText("0");
					offTrailNumber = 0;
				}else {
					numberOffTrailTextView.setText(String.valueOf(offTrailNumber));
				}
				break;
			case 3:
				int forbiddenNumber =  Integer.parseInt((String) numberForbiddenItemsTextView.getText());
				forbiddenNumber--;
				if(forbiddenNumber < 0){//prevents displaying a negative number
					numberForbiddenItemsTextView.setText("0");
					forbiddenNumber = 0;
				}else {
					numberForbiddenItemsTextView.setText(String.valueOf(forbiddenNumber));
				}
				break;
			case 4:
				int walkUpNumber =  Integer.parseInt((String) numberWalkUpTextView.getText());
				walkUpNumber--;
				if(walkUpNumber < 0){//prevents displaying a negative number
					numberWalkUpTextView.setText("0");
					walkUpNumber = 0;
				}else {
					numberWalkUpTextView.setText(String.valueOf(walkUpNumber));
				}
				break;
			case 5:
				int trespassersNumber =  Integer.parseInt((String) numberTrespassersTextView.getText());
				trespassersNumber--;
				if(trespassersNumber < 0){//prevents displaying a negative number
					numberTrespassersTextView.setText("0");
					trespassersNumber = 0;
				}else {
					numberTrespassersTextView.setText(String.valueOf(trespassersNumber));
				}
				break;
		}
		playSpecificSound(R.raw.decrementbeep);
	}



	/*********************************************************************************
	 *  playSpecificSound() plays an audio sound when the pressing the various buttons
	 *  in the app
	 *
	 * @pre none
	 * @parameter none
	 * @post none
	 **********************************************************************************/
	private void playSpecificSound(int resource){
		MediaPlayer mPlayer = MediaPlayer.create(getContext(), resource);
		mPlayer .start();;

	}
}
