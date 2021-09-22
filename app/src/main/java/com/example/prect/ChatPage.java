package com.example.prect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ChatPage extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
        Crisp.configure(getApplicationContext(), "a7ac590d-b7f6-43c9-95e9-eee54ab4da86");
        Intent crispIntent = new Intent(this, ChatActivity.class);
        startActivity(crispIntent);
       // https://www.google.com/


    }
}