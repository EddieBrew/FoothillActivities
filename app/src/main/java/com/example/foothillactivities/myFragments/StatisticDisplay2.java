package com.example.foothillactivities.myFragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
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
 * {@link StatisticDisplay2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatisticDisplay2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticDisplay2 extends Fragment implements View.OnClickListener {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;
	private TextView numberCoyotesTextView, numberBikesTaggedTextView, numberMountainLionsTextView, numberWorkingDogsTextView, numberWalkUpTextView, numberTrespassersTextView ;


	private OnFragmentInteractionListener mListener;



	//Interface methods to interact with MainActivity
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		//void onFragmentInteraction(Uri uri);

		public void display2Actions();
	}



	public StatisticDisplay2() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment StatisticDisplay2.
	 */
	// TODO: Rename and change types and number of parameters
	public static StatisticDisplay2 newInstance(String param1, String param2) {
		StatisticDisplay2 fragment = new StatisticDisplay2();
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
		View view =  inflater.inflate(R.layout.fragment_statistic_display2, container, false);

		Button incrementCoyotesbtn = view.findViewById(R.id.incrementCoyotesbtn);
		incrementCoyotesbtn.setOnClickListener(this);

		numberCoyotesTextView= view.findViewById(R.id.numberCoyotesTextView);//decrements count
		numberCoyotesTextView.setOnClickListener(this);

		Button incrementBikesTaggedbtn = view.findViewById(R.id.incrementBikesTaggedbtn);
		incrementBikesTaggedbtn.setOnClickListener(this);

		numberBikesTaggedTextView = view.findViewById(R.id.numberBikesTaggedTextView);
		numberBikesTaggedTextView.setOnClickListener(this);

		Button incrementMountainLionsbtn = view.findViewById(R.id.incrementMountainLionsbtn);
		incrementMountainLionsbtn.setOnClickListener(this);

		numberMountainLionsTextView = view.findViewById(R.id.numberMountainLionsTextView);
		numberMountainLionsTextView.setOnClickListener(this);

		Button incrementWorkingDogsbtn = view.findViewById(R.id.incrementWorkingDogsbtn);
		incrementWorkingDogsbtn.setOnClickListener(this);

		numberWorkingDogsTextView = view.findViewById(R.id.numberWorkingDogsTextView);
		numberWorkingDogsTextView.setOnClickListener(this);

		Button incrementWalkUpsbtn = view.findViewById(R.id.incrementWalkUpsbtn);
		incrementWalkUpsbtn.setOnClickListener(this);

		numberWalkUpTextView = view.findViewById(R.id.numberWalkUpTextView);
		numberWalkUpTextView.setOnClickListener(this);

		Button incrementTrespassersbtn = view.findViewById(R.id.incrementTrespassersbtn);
		incrementTrespassersbtn.setOnClickListener(this);

		numberTrespassersTextView = view.findViewById(R.id.numberTrespassersTextView);
		numberTrespassersTextView.setOnClickListener(this);


		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.display2Actions();
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

	@Override
	public void onClick(View view) {
		int buttonSelector;
		switch(view.getId()){
			case R.id.incrementCoyotesbtn:
				buttonSelector = 0;
				increment(buttonSelector);
				break;
			case R.id.numberCoyotesTextView:
				buttonSelector = 0;
				decrement(buttonSelector);
				break;
			case  R.id.incrementBikesTaggedbtn:
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
			case R.id.numberMountainLionsTextView:
				buttonSelector = 2;
				decrement(buttonSelector);
				break;
			case R.id.incrementWorkingDogsbtn:
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
			default:
		}

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
				int coyotesNumber =  Integer.parseInt((String) numberCoyotesTextView.getText());
				coyotesNumber++;
				numberCoyotesTextView.setText(String.valueOf(coyotesNumber));
				break;
			case 1:
				int animalNumber =  Integer.parseInt((String) numberBikesTaggedTextView.getText());
				animalNumber++;
				numberBikesTaggedTextView.setText(String.valueOf(animalNumber));
				break;
			case 2:
				int mountainLionsNumber =  Integer.parseInt((String) numberMountainLionsTextView.getText());
				mountainLionsNumber++;
				numberMountainLionsTextView.setText(String.valueOf(mountainLionsNumber));
				break;
			case 3:
				int forbiddenNumber =  Integer.parseInt((String) numberWorkingDogsTextView.getText());
				forbiddenNumber++;
				numberWorkingDogsTextView.setText(String.valueOf(forbiddenNumber));
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
			default:
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
				int coyotesNumber =  Integer.parseInt((String) numberCoyotesTextView.getText());
				coyotesNumber--;
				if(coyotesNumber < 0){//prevents displaying a negative number
					numberCoyotesTextView.setText("0");
					coyotesNumber = 0;
				}else {
					numberCoyotesTextView.setText(String.valueOf(coyotesNumber));
				}
				break;
			case 1:
				int animalNumber =  Integer.parseInt((String) numberBikesTaggedTextView.getText());
				animalNumber--;
				if(animalNumber < 0){//prevents displaying a negative number
					numberBikesTaggedTextView.setText("0");
					animalNumber = 0;
				}else {
					numberBikesTaggedTextView.setText(String.valueOf(animalNumber));
				}
				break;
			case 2:
				int offTrailNumber =  Integer.parseInt((String) numberMountainLionsTextView.getText());
				offTrailNumber--;
				if(offTrailNumber < 0){//prevents displaying a negative number
					numberMountainLionsTextView.setText("0");
					offTrailNumber = 0;
				}else {
					numberMountainLionsTextView.setText(String.valueOf(offTrailNumber));
				}
				break;
			case 3:
				int forbiddenNumber =  Integer.parseInt((String) numberWorkingDogsTextView.getText());
				forbiddenNumber--;
				if(forbiddenNumber < 0){//prevents displaying a negative number
					numberWorkingDogsTextView.setText("0");
					forbiddenNumber = 0;
				}else {
					numberWorkingDogsTextView.setText(String.valueOf(forbiddenNumber));
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


		MediaPlayer mPlayer = null;
		try {

			mPlayer = MediaPlayer.create(getContext(), resource);
			mPlayer.start();;

			mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {
					mp.release();

				};
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
