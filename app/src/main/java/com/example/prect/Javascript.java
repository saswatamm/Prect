package com.example.prect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class Javascript extends Fragment {

    RecyclerView recyclerView;
    CustomAdapter1 customAdapter;
    public Javascript() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_javascript, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Model1> options =(new FirebaseRecyclerOptions.Builder<Model1>()

                .setQuery(FirebaseDatabase.getInstance().getReference("Questions Asked").child("JavaScript"), Model1.class)
                .build());
        customAdapter = new CustomAdapter1(options);
        recyclerView.setAdapter(customAdapter);
       return view;
    }
}