package com.example.shuhao20.finalapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shuhao20.finalapplication.DataBaseHelper.DatabaseHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private DatabaseHelper dbh;
    private List<Quiz> quizzes;
    private RadioGroup mRg;
    private RadioButton mRb_1, mRb_2, mRb_3, mRb_4;
    private Button mBtn;
    private TextView mTv_id;
    private TextView mTv_description;
    private TextView mTv_ex;
    private ImageView mIv;
    private Random random = new Random();
    final int rint = random.nextInt(4);
    private String[] wrongOptions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        dbh = new DatabaseHelper(QuizActivity.this);
        dbh.cleanDatabase();

        mRg = findViewById(R.id.rg);
        mRb_1 = findViewById(R.id.rb_1);
        mRb_2 = findViewById(R.id.rb_2);
        mRb_3 = findViewById(R.id.rb_3);
        mRb_4 = findViewById(R.id.rb_4);
        mBtn = findViewById(R.id.btn);
        mTv_id = findViewById(R.id.tv_id);
        mTv_description = findViewById(R.id.tv_description);
        mTv_ex = findViewById(R.id.tv_ex);
        mIv = findViewById(R.id.iv);



        Quiz q1 = new Quiz();
        q1.setQuizId(1);
        q1.setDesc("This is question");
        q1.setRightOption("This is the right option");
        q1.setWrongOptions(new String[]{"first wrong option","second","third"});
        q1.setExplanation("This is the explanation");
        q1.setChapter(1);
        dbh.createQuiz(q1);

        quizzes = dbh.getAllCategory(1);
        mTv_id.setText(String.valueOf(quizzes.get(0).getQuizId()) + ". ");
        mTv_description.setText(quizzes.get(0).getDesc());


        if (rint == 0) {
            mRb_1.setText(quizzes.get(0).getRightOption());
            wrongOptions = quizzes.get(0).getWrongOptions();
            mRb_2.setText(wrongOptions[0]);
            mRb_3.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 1) {
            mRb_2.setText(quizzes.get(0).getRightOption());
            wrongOptions = quizzes.get(0).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_3.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 2) {
            mRb_3.setText(quizzes.get(0).getRightOption());
            wrongOptions = quizzes.get(0).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_2.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 3) {
            mRb_4.setText(quizzes.get(0).getRightOption());
            wrongOptions = quizzes.get(0).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_2.setText(wrongOptions[1]);
            mRb_3.setText(wrongOptions[2]);
        }

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtn.setText("Next Question");
                mBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                if (rint == 0) {
                    if (mRb_1.isChecked()) {
                        mIv.setImageResource(R.mipmap.right);
                    } else {
                        mIv.setImageResource(R.mipmap.wrong);
                        mTv_ex.setText(quizzes.get(0).getExplanation());

                    }
                } else if (rint == 1) {
                    if (mRb_2.isChecked()) {
                        mIv.setImageResource(R.mipmap.right);
                    } else {
                        mIv.setImageResource(R.mipmap.wrong);
                        mTv_ex.setText(quizzes.get(0).getExplanation());
                    }
                } else if (rint == 2) {
                    if (mRb_3.isChecked()) {
                        mIv.setImageResource(R.mipmap.right);
                    } else {
                        mIv.setImageResource(R.mipmap.wrong);
                        mTv_ex.setText(quizzes.get(0).getExplanation());
                    }
                } else if (rint == 3) {
                    if (mRb_4.isChecked()) {
                        mIv.setImageResource(R.mipmap.right);
                    } else {
                        mIv.setImageResource(R.mipmap.wrong);
                        mTv_ex.setText(quizzes.get(0).getExplanation());
                    }
                }
            }
        });











        //SQLiteDatabase db = new DatabaseHelper(QuizActivity.this).getWritableDatabase();
        //quizzes = dbh.getAllCategory(1999);
        //mTv.setText(String.valueOf(quizzes.get(0).getChapter()));
        //Log.i("DATABASE SETTING", quizzes.get(0).getChapter());
        //mTv.setText(quizzes.get(0).getChapter());
        //List<Quiz> quizes = new ArrayList<Quiz>();
        //quizes.add(q1);
        //mTv.setText(quizes.get(0).getChapter());
        //System.out.println(quizzes.get(0).getChapter());
    }
}
