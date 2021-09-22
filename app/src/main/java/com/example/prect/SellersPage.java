package com.example.prect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SellersPage extends AppCompatActivity {
    TextView warning;
    int f=0;
    TextView java,kotlin, html,css,javascript,reactnative, flutter,ionic, phonegap,apply;
    static String lang;
    LinearLayout linearLayout;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers_page);
        apply = findViewById(R.id.apply);
        warning = findViewById(R.id.Warning);
        linearLayout = findViewById(R.id.linearLayout);
        imageView = findViewById(R.id.back_sellerspage);


        java = findViewById(R.id.java);
        kotlin = findViewById(R.id.kotlin);
        html = findViewById(R.id.HTML);
        css = findViewById(R.id.CSS);
        javascript = findViewById(R.id.JavaScript);
        reactnative = findViewById(R.id.ReactNative);
        flutter = findViewById(R.id.Flutter);
        ionic = findViewById(R.id.Ionic);




        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSerYvZbO_AGSGPs0tPffzajNZAC5qP_No86wcqgtDcucCytxQ/viewform");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellersPage.this, HomePage.class);
                startActivity(intent);
            }
        });


        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Sellers").child(userId);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    if(!snapshot.child("Java").exists())
                    {
                        java.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("Kotlin").exists())
                    {
                        kotlin.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("HTML").exists())
                    {
                        html.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("CSS").exists())
                    {
                        css.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("JavaScript").exists())
                    {
                        javascript.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("Flutter").exists())
                    {
                        flutter.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("Ionic").exists())
                    {
                        ionic.setVisibility(View.GONE);
                    }
                    if(!snapshot.child("ReactNative").exists())
                    {
                        reactnative.setVisibility(View.GONE);
                    }





                }
                else
                {
                    //java,kotlin, html,css,javascript,reactnative, flutter,ionic,

                    java.setEnabled(false);
                    kotlin.setEnabled(false);
                    html.setEnabled(false);
                    css.setEnabled(false);
                    javascript.setEnabled(false);
                    reactnative.setEnabled(false);
                    flutter.setEnabled(false);
                    ionic.setEnabled(false);
                    linearLayout.setVisibility(View.INVISIBLE);
                    warning.setVisibility(View.VISIBLE);
                    warning.setText("Currently you are not a helpmate, please apply here");
                    apply.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








   /*     DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Sellers").child(userId);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    warning.setVisibility(View.INVISIBLE);
                    f=1;
                }
                else
                {
                    warning.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(f==1)
        {*/






            java.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Java kotlin = new Java();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.linearLayout, kotlin);
                    transaction.commit();



                }
            });
            kotlin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Kotlin kotlin = new Kotlin();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.linearLayout, kotlin);
                    transaction.commit();


                }
            });
            html.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HTML kotlin = new HTML();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.linearLayout, kotlin);
                    transaction.commit();
                }
            });
            css.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CSS kotlin = new CSS();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.linearLayout, kotlin);
                    transaction.commit();
                }
            });
            javascript.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Javascript kotlin = new Javascript();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.linearLayout, kotlin);
                    transaction.commit();
                }
            });

        reactnative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReactNative kotlin = new ReactNative();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, kotlin);
                transaction.commit();
            }
        });
        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Flutter kotlin = new Flutter();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, kotlin);
                transaction.commit();
            }
        });
        ionic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ionic kotlin = new Ionic();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, kotlin);
                transaction.commit();
            }
        });








        }


}