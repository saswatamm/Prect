package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GiveAnswer extends AppCompatActivity {
    TextView question;
    EditText answer;
    TextView send;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_answer);

        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        send = findViewById(R.id.send);
        imageView = findViewById(R.id.back_AnswerPage);


        Bundle bundle = getIntent().getExtras();

        String qns = bundle.getString("question");
        String uid = bundle.getString("uid");
        String lang = bundle.getString("language");
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();




        question.setText(qns);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiveAnswer.this, SellersPage.class);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1 = answer.getText().toString();
                if(answer1.length()<30)
                {
                    Toast.makeText(getApplicationContext(), "Answer must be greater than 30 letters", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DatabaseReference dref2 = FirebaseDatabase.getInstance().getReference("AllHistory");
                    dref2.child(qns).child("Answered").setValue(userId);
                    DatabaseReference dref3 = FirebaseDatabase.getInstance().getReference("Questions Asked").child(lang).child(uid);
                    dref3.removeValue();
                    Task<Void> dref4 = FirebaseDatabase.getInstance().getReference("Personal Questions").child(uid).child(lang).child("answer").setValue(answer1);
                    Intent intent = new Intent(GiveAnswer.this, SellersPage.class);
                    startActivity(intent);

                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GiveAnswer.this, SellersPage.class);
        startActivity(intent);
    }
}