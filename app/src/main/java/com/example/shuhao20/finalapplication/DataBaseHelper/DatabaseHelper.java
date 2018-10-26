package com.example.shuhao20.finalapplication.DataBaseHelper;

import android.content.ClipData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.util.Log;

import com.example.shuhao20.finalapplication.Quiz;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "3634Database";

    //TABLE NAMES
    private static final String TABLE_QUIZ = "quiz";

    //COLUNM NAMES
    private static final String KEY_Q_ID = "quizId"; //int
    private static final String Q_DESC = "desc";
    private static final String Q_RIGHTOPTION = "rightOption";
    private static final String Q_WRONGOPTIONS_1 = "wrongOptions_1";
    private static final String Q_WRONGOPTIONS_2 = "wrongOptions_2";
    private static final String Q_WRONGOPTIONS_3 = "wrongOptions_3";
    private static final String Q_CHAPTER = "chapter";
    private static final String Q_EXPLANATION = "explanation";

    private static final String CREATE_TABLE_QUIZ = "CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ +"("
            + KEY_Q_ID + " INTEGER PRIMARY KEY asc,"
            + Q_DESC + " TEXT,"
            + Q_RIGHTOPTION + " TEXT, "
            + Q_WRONGOPTIONS_1 + " TEXT, "
            + Q_WRONGOPTIONS_2 + " TEXT, "
            + Q_WRONGOPTIONS_3 + " TEXT, "
            + Q_EXPLANATION + " TEXT, "
            + Q_CHAPTER + " INTEGER"
            + ")";

    //Oncreate
    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_QUIZ);
        Log.i("DATABASE SETTING", "TABLE CREATION COMPLETED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void cleanDatabase(){
        // on upgrade drop older tables
        Log.i("CLEAN", "START CLEANING");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUIZ);

        onCreate(db);
        Log.i("CLEAN", "DATABASE CLEANED");
        db.close();
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
    public long createQuiz(Quiz newQuiz) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Q_ID, newQuiz.getQuizId());
        values.put(Q_DESC, newQuiz.getDesc());
        values.put(Q_RIGHTOPTION, newQuiz.getRightOption());
        values.put(Q_WRONGOPTIONS_1, newQuiz.getWrongOptions()[0]);
        values.put(Q_WRONGOPTIONS_2, newQuiz.getWrongOptions()[1]);
        values.put(Q_WRONGOPTIONS_3, newQuiz.getWrongOptions()[2]);
        values.put(Q_CHAPTER, newQuiz.getChapter());
        values.put(Q_EXPLANATION, newQuiz.getExplanation());

        // insert row
        long quiz_id = db.insert(TABLE_QUIZ, null, values);
        db.close();
        return quiz_id;
    }

    //CATEGORY //id
    public List<Quiz> getAllCategory(int chapter) {
        List<Quiz> quizes = new ArrayList<Quiz>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUIZ + " WHERE " + Q_CHAPTER + " = " + chapter;

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if(c != null) {
            if (c.moveToFirst()) {
                do {
                    Quiz q = new Quiz();
                    q.setQuizId(c.getInt(c.getColumnIndex(KEY_Q_ID)));
                    q.setDesc(c.getString(c.getColumnIndex(Q_DESC)));
                    q.setRightOption(c.getString(c.getColumnIndex(Q_RIGHTOPTION)));
                    q.setExplanation(c.getString(c.getColumnIndex(Q_EXPLANATION)));

                    String[] wrongOptions = new String[3];
                    wrongOptions[0] = c.getString(c.getColumnIndex(Q_WRONGOPTIONS_1));
                    wrongOptions[1] = c.getString(c.getColumnIndex(Q_WRONGOPTIONS_2));
                    wrongOptions[2] = c.getString(c.getColumnIndex(Q_WRONGOPTIONS_3));
                    q.setWrongOptions(wrongOptions);
                    q.setChapter(c.getInt(c.getColumnIndex(Q_CHAPTER)));

                    // adding to the list
                    quizes.add(q);
                } while (c.moveToNext());
            }
        }
        c.close();
        db.close();
        return quizes;
    }

	/*public void deleteToDo(long tado_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, KEY_ID + " = ?",
                new String[] { String.valueOf(tado_id) });
        db.close();
    }*/
}

