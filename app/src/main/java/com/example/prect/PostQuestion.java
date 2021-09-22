package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostQuestion extends AppCompatActivity {
    TextView save;
    EditText editText;
    static int f=-1;
    ImageView back;
    TextView Java, Kotlin, Flutter, PhoneGap,Python, Swift ,ReactNative, Ionic, HTML, CSS, JavaScript, selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_question);

        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        editText = findViewById(R.id.editText);
        Java = findViewById(R.id.Java);
        Kotlin = findViewById(R.id.Kotlin);
        Flutter = findViewById(R.id.Flutter);

        Python = findViewById(R.id.Python);
        Swift = findViewById(R.id.Swift);
        ReactNative = findViewById(R.id.ReactNative);
        Ionic = findViewById(R.id.Ionic);
        HTML = findViewById(R.id.HTML);
        CSS = findViewById(R.id.CSS);
        JavaScript = findViewById(R.id.JavaScript);
        selected = findViewById(R.id.selected);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostQuestion.this,HomePage.class);
                startActivity(intent);
            }
        });

        Java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Java is Selected");
                f=1;
            }
        });
        Kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Kotlin is Selected");
                f=2;
            }
        });
        Flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Flutter is Selected");
                f=3;
            }
        });

        Python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Python is Selected");
                f=5;
            }
        });
        Swift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Swift is Selected");
                f=6;
            }
        });
        ReactNative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("ReactNative is Selected");
                f=7;
            }
        });
        Ionic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("Ionic is Selected");
                f=8;
            }
        });
        HTML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("HTML is Selected");
                f=9;
            }
        });
        CSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("CSS is Selected");
                f=10;
            }
        });
        JavaScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText("JavaScript is Selected");
                f=11;
            }
        });




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = editText.getText().toString();
                question = question.trim();
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Questions Asked");
                DatabaseReference dref2 = FirebaseDatabase.getInstance().getReference("AllHistory");
                dref2.child(question).child("Asked").setValue(userId);
                DatabaseReference dref1 = FirebaseDatabase.getInstance().getReference("Personal Questions").child(userId);
                switch (f)
                {
                    case 1: dref.child("Java").child(userId).child("Question").setValue(question);
                            dref.child("Java").child(userId).child("Language").setValue("Java");
                            dref.child("Java").child(userId).child("uid").setValue(userId);



                            dref1.child("Java").child("Language").setValue("Java");
                            dref1.child("Java").child("Question").setValue(question);
                    break;
                    case 2: dref.child("Kotlin").child(userId).child("Question").setValue(question);
                        dref.child("Kotlin").child(userId).child("Language").setValue("Kotlin");
                        dref.child("Kotlin").child(userId).child("uid").setValue(userId);
                        dref1.child("Kotlin").child("Language").setValue("Kotlin");
                        dref1.child("Kotlin").child("Question").setValue(question);
                    break;
                    case 3: dref.child("Flutter").child(userId).child("Question").setValue(question);
                        dref.child("Flutter").child(userId).child("Language").setValue("Flutter");
                        dref.child("Flutter").child(userId).child("uid").setValue(userId);
                        dref1.child("Flutter").child("Language").setValue("Flutter");
                        dref1.child("Flutter").child("Question").setValue(question);
                    break;
                    case 4: dref.child("PhoneGap").child(userId).child("Question").setValue(question);
                        dref.child("PhoneGap").child(userId).child("Language").setValue("PhoneGap");
                        dref.child("PhoneGap").child(userId).child("uid").setValue(userId);
                        dref1.child("PhoneGap").child("Language").setValue("PhoneGap");
                        dref1.child("PhoneGap").child("Question").setValue(question);
                    break;
                    case 5: dref.child("Python").child(userId).child("Question").setValue(question);
                        dref.child("Python").child(userId).child("Language").setValue("Python");
                        dref.child("Python").child(userId).child("uid").setValue(userId);
                        dref1.child("Python").child("Language").setValue("Python");
                        dref1.child("Python").child("Question").setValue(question);
                    break;
                    case 6: dref.child("Swift").child(userId).child("Question").setValue(question);
                        dref.child("Swift").child(userId).child("Language").setValue("Swift");
                        dref.child("Swift").child(userId).child("uid").setValue(userId);
                        dref1.child("Swift").child("Language").setValue("Swift");
                        dref1.child("Swift").child("Question").setValue(question);
                    break;
                    case 7: dref.child("ReactNative").child(userId).child("Question").setValue(question);
                        dref.child("ReactNative").child(userId).child("Language").setValue("ReactNative");
                        dref.child("ReactNative").child(userId).child("uid").setValue(userId);
                        dref1.child("ReactNative").child("Language").setValue("ReactNative");
                        dref1.child("ReactNative").child("Question").setValue(question);
                    break;
                    case 8: dref.child("Ionic").child(userId).child("Question").setValue(question);
                        dref.child("Ionic").child(userId).child("Language").setValue("Ionic");
                        dref.child("Ionic").child(userId).child("uid").setValue(userId);
                        dref1.child("Ionic").child("Language").setValue("Ionic");
                        dref1.child("Ionic").child("Question").setValue(question);
                    break;
                    case 9: dref.child("HTML").child(userId).child("Question").setValue(question);
                        dref.child("HTML").child(userId).child("Language").setValue("HTML");
                        dref.child("HTML").child(userId).child("uid").setValue(userId);
                        dref1.child("HTML").child("Language").setValue("HTML");
                        dref1.child("HTML").child("Question").setValue(question);
                    break;
                    case 10: dref.child("CSS").child(userId).child("Question").setValue(question);
                        dref.child("CSS").child(userId).child("Language").setValue("CSS");
                        dref.child("CSS").child(userId).child("uid").setValue(userId);
                        dref1.child("CSS").child("Language").setValue("CSS");
                        dref1.child("CSS").child("Question").setValue(question);
                    break;
                    case 11: dref.child("JavaScript").child(userId).child("Question").setValue(question);
                        dref.child("JavaScript").child(userId).child("Language").setValue("JavaScript");
                        dref.child("JavaScript").child(userId).child("uid").setValue(userId);
                        dref1.child("JavaScript").child("Language").setValue("JavaScript");
                        dref1.child("JavaScrpit").child("Question").setValue(question);
                    break;
                    case -1:
                        Toast.makeText(getApplicationContext(), "Please select a topic", Toast.LENGTH_SHORT).show();
                        break;


                }
                if(f!=-1) {
                    selected.setText("");
                    //C:\Users\saswa\AndroidStudioProjects\Prect\app\build\outputs\apk\debug   imp
                    editText.setText("");
                    Toast.makeText(PostQuestion.this, " Question submitted successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}