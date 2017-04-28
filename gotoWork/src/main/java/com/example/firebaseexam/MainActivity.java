package com.example.firebaseexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mMyRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 출근
        // DB에 출근기록
        // Write a message to the mDatabase
        mDatabase = FirebaseDatabase.getInstance();
//        mMyRef = mDatabase.getReference("users").child("1");
//
//        mMyRef.setValue(new Login(true));
        mMyRef = mDatabase.getReference().child("users").child("1");

        mMyRef.setValue(new Login(true));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // DB 퇴근 기록
        mMyRef.setValue(new Login(false));
    }
}
