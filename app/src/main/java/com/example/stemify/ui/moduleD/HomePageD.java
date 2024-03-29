package com.example.stemify.ui.moduleD;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stemify.R;
import com.example.stemify.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomePageD extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page_d, container, false);

        //change fragment name
        getActivity().setTitle("Health");

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.modD_TLHomePageD); //tab
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.modD_VPHomePageD); // page

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new HealthGuidance(), "HEALTH");
        vpAdapter.addFragment(new Counseling(),  "COUNSELING");
        vpAdapter.addFragment(new Community(), "COMMUNITY");
        viewPager.setAdapter(vpAdapter);

        return view;
    }
}