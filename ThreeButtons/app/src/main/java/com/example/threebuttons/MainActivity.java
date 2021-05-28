package com.example.threebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchParagraphOne(View view) {
        Intent intent = new Intent(this, ParagraphOne.class);
        startActivity(intent);
    }

    public void launchParagraphTwo(View view) {
        Intent intent = new Intent(this, ParagraphTwo.class);
        startActivity(intent);
    }
    public void launchParagraphThree(View view) {
        Intent intent = new Intent(this, ParagraphThree.class);
        startActivity(intent);
    }
}