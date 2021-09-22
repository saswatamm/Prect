package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class HomePage extends AppCompatActivity {

    Button btn;
    TextView txt,chat,name;
    RelativeLayout post,whatsnew,btn3,bnt2;

    ImageView bitmoji;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bitmoji = findViewById(R.id.bitmoji);
        name = findViewById(R.id.name);
        //btn = findViewById(R.id.signOut);
        txt = findViewById(R.id.welcometext);
        post = findViewById(R.id.btn3);
        btn3 = findViewById(R.id.btn);
        chat = findViewById(R.id.chat);
        whatsnew = findViewById(R.id.whatsnew);
        bitmoji = findViewById(R.id.bitmoji);


        bitmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Profile.class);
                startActivity(intent);

            }
        });

        whatsnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(HomePage.this, whatsnew.class);
                startActivity(intent);*/
            }
        });

        bitmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,Profile.class);
                startActivity(intent);
            }
        });

        String user = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

        int index = 0;
        for(int i=0;i<user.length();i++)
        {
            if(user.charAt(i)==' ')
            {
                index = i;
                break;
            }
        }
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentTime = getCurrentTimeStamp();
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                Task<Void> dref = FirebaseDatabase.getInstance().getReference("Chat Requests").child(currentTime).child(userId).setValue(email);
                /*Intent intent = new Intent(HomePage.this, ChatPage.class);
                startActivity(intent);*/
                Crisp.configure(getApplicationContext(), "24315b73-8eab-42e6-ba2e-8874da5cfa2d");
                Intent crispIntent = new Intent(HomePage.this, ChatActivity.class);
                startActivity(crispIntent);

            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, PostQuestion.class);
                startActivity(intent);
                finish();
            }
        });
        //Changing first letter of name to uppercase
        String username = user.substring(1,index+1);
        String first = user.substring(0,1).toUpperCase();
        user = user.substring(0,index+1);
        username = first + username;
        txt.setText("Hi,");
        name.setText(username);







      /*  btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
        bnt2 = findViewById(R.id.bnt2);
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ViewMyQuestions.class);
                startActivity(intent);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, PostQuestion.class);
                startActivity(intent);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, SellersPage.class);
                startActivity(intent);

            }
        });



    }

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public void onBackPressed() {

        finishAffinity();
        finish();

    }
}