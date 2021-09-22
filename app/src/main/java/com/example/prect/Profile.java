package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {
    TextView name,email,signOut;
    ImageView imageView;
    TextView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        signOut = findViewById(R.id.signOut);
        imageView = findViewById(R.id.back_profile);
        chat = findViewById(R.id.chat);



        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSerYvZbO_AGSGPs0tPffzajNZAC5qP_No86wcqgtDcucCytxQ/viewform");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



        String Name = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        String Email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        name.setText(Name);
        email.setText(Email);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(Profile.this, Login.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,HomePage.class);
                startActivity(intent);

            }
        });
    }
}