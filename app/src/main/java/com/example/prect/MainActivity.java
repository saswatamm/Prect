package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());




        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



        paperOnboardingFragment.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int i, int i1) {
                if(i==1 && i1==2)
                {
                    if(user!=null)
                    {
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }
                }
            }
        });

        paperOnboardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {






                Intent intent = new Intent(MainActivity.this , Login.class);
                startActivity(intent);
                finish();

                /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment bf = new BlankFragment();
                fragmentTransaction.replace(R.id.fragment_container, bf);
                fragmentTransaction.commit();*/

            }
        });





    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Learn",
                "Wisdom is not a product of schooling but of the lifelong attempt to acquire it,\n- Albert Einstein",
                Color.parseColor("#D7e9f7"), R.drawable.online_learningnew, R.drawable.ic_baseline_add_24);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Help",
                "Helping one person might not change the whole world, but it could change the world for one person",
                Color.parseColor("#F0d9ff"), R.drawable.helping_handnew, R.drawable.ic_baseline_add_24);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Grow",
                "What you do makes a difference, and you have to decide to have what kind of difference you want to make,\n- Jane Goodall",
                Color.parseColor("#Ffe5b9"), R.drawable.startup, R.drawable.ic_baseline_add_24);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;

    }

    }
