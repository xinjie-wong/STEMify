package com.example.stemify.ui.moduleA;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.stemify.R;
import com.example.stemify.TestActivity;

import java.util.ArrayList;
import java.util.List;

public class ResourceCommunityEducator extends Fragment {
    CommunityResourceAdapter communityResourceAdapter;
    RecyclerView recyclerViewComm;
    List<CommunityResourceItem> listOfItems;

    Button btnToOwnResources;
    public ResourceCommunityEducator() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initalizeData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resource_community_educator, container, false);

        // Setup button to lead to Educators' resources page
        btnToOwnResources = view.findViewById(R.id.BtnGoToOwnResources);
        btnToOwnResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGradeLibrary = new Intent(getContext(), EducatorResources.class); // change test activity later
                getContext().startActivity(goToGradeLibrary);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup RecyclerView for community resources
        recyclerViewComm = view.findViewById(R.id.RVCommunityResourceEdu);
        recyclerViewComm.setLayoutManager(new LinearLayoutManager(getContext()));
        communityResourceAdapter = new CommunityResourceAdapter(getContext(), listOfItems);
        recyclerViewComm.setAdapter(communityResourceAdapter);
        communityResourceAdapter.notifyDataSetChanged();

    }

    public void initalizeData(){
        // Initializing list of download items
        listOfItems = new ArrayList<CommunityResourceItem>();

        // Populate list with download items
        listOfItems.add(new CommunityResourceItem("Test1", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test2", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test3", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test4", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test5", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test6", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test7", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test8", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test9", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
        listOfItems.add(new CommunityResourceItem("Test10", "Sample description", "Kairos5106", R.drawable.pfp, R.drawable.sampleimage));
    }
}