package com.example.shuhao20.finalapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {
    private TextView mResult, mComment;
    private int right;
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResult = findViewById(R.id.result);
        mComment = findViewById(R.id.comment);
        mBtn = findViewById(R.id.btn);
        right = 3;


        Intent intent = getIntent();
        right = intent.getIntExtra("right", 0);
        mResult.setText(right + "/5");
        if (right == 0 || right == 1) {
            mComment.setText("Catch up! You could be better!");
        } else if (right == 2 || right == 3) {
            mComment.setText("Keep moving!");
        } else {
            mComment.setText("Well done! Congradualations!");
        }

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
