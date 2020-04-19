package com.example.foothillactivities;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.foothillactivities.myFragments.StatisticDisplay1;
import com.example.foothillactivities.myFragments.StatisticDisplay2;

import com.example.foothillactivities.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements StatisticDisplay1.OnFragmentInteractionListener, StatisticDisplay2.OnFragmentInteractionListener {
	SectionsPagerAdapter sectionsPagerAdapter;
	ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
		viewPager = findViewById(R.id.view_pager);
		viewPager.setAdapter(sectionsPagerAdapter);
		TabLayout tabs = findViewById(R.id.tabs);
		tabs.setupWithViewPager(viewPager);


	}


	@Override
	public void display2Actions() {

	}



	  ////////  StatisticDispla1 Interface Method

	/*******************************************************************************************************************************
		resetActivityPage2() is an interface method, located in the StatistiDisplay1 fragment,  that resets all statistics in the
		StatisticalDisplay2 (  Activity Page2 tab) to zero
	********************************************************************************************************************************* */

	@Override
	public void resetActivityPage2() {

		sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
		viewPager = findViewById(R.id.view_pager);
		viewPager.setAdapter(sectionsPagerAdapter);
		TabLayout tabs = findViewById(R.id.tabs);
		tabs.setupWithViewPager(viewPager);
	}


}