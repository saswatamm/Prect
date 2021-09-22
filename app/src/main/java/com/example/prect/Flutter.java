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


public class Flutter extends Fragment {


    RecyclerView recyclerView;
    CustomAdapter1 customAdapter;

    public Flutter() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_flutter, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Model1> options =(new FirebaseRecyclerOptions.Builder<Model1>()

                .setQuery(FirebaseDatabase.getInstance().getReference("Questions Asked").child("Flutter"), Model1.class)
                .build());
        customAdapter = new CustomAdapter1(options);
        recyclerView.setAdapter(customAdapter);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        customAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        customAdapter.stopListening();
    }
}