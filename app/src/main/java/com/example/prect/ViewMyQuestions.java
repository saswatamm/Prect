package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ViewMyQuestions extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_questions);


        imageView = findViewById(R.id.back_viewmyquestions);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewMyQuestions.this,HomePage.class);
                startActivity(intent);
            }
        });

        FirebaseRecyclerOptions<Model> options = new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Personal Questions").child(userId),Model.class )
                .build();

        customAdapter = new CustomAdapter(options);
        recyclerView.setAdapter(customAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        customAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        customAdapter.stopListening();
    }
}