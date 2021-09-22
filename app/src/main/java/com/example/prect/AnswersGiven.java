package com.example.prect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class AnswersGiven extends AppCompatActivity {
    TextView answer,send,question1;
    TextView btn;
    EditText support;
    ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_given);
        answer = findViewById(R.id.answer);
        imageView = findViewById(R.id.back_answers_given);

        question1 = findViewById(R.id.question);
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Bundle bundle = getIntent().getExtras();
        support = findViewById(R.id.support);
        send = findViewById(R.id.send);
        String lang1 = bundle.getString("lang");
        String question = bundle.getString("question");
        btn = findViewById(R.id.ok);
        int f=1;
        question1.setText(question);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = support.getText().toString();
                if (query.length() < 10) {
                    Toast.makeText(getApplicationContext(), "Query can't be less than 10 letters", Toast.LENGTH_SHORT).show();
                }
                else {
                    Task<Void> dref3 = FirebaseDatabase.getInstance().getReference("Support").child(userId).setValue(query);
                    support.setText("");
                    Toast.makeText(getApplicationContext(), "Your issue will be solved as early as possible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnswersGiven.this, ViewMyQuestions.class);
                startActivity(intent);
            }
        });

        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Personal Questions").child(userId).child(lang1).child("answer");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    answer.setText(snapshot.getValue(String.class));

                }
                else
                {
                    answer.setText("Answer not provided yet");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(AnswersGiven.this)
                        .setTitle("Delete entry")
                        .setMessage("Wanna delete this to ask new question on " + lang1 + "?")


                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Task<Void> dref1 = FirebaseDatabase.getInstance().getReference("Personal Questions").child(userId).child(lang1).removeValue();
                                Intent intent = new Intent(AnswersGiven.this,HomePage.class);
                                startActivity(intent);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}