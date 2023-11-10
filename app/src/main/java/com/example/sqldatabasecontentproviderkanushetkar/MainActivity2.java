package com.example.sqldatabasecontentproviderkanushetkar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("Range")
public class MainActivity2 extends AppCompatActivity {

    EditText nationalNumberET, nameET, speciesET, HeightET, WeightET, hpET, attackET, DefenseET;
    TextView nationalNumberTV, nameTV, speciesTV, genderTV, heightTV, weightTV, levelTV, hpTV, attackTV, DefenseTV;

    Button backToMainPage;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        backToMainPage = findViewById(R.id.backToMainPage);
        delete = findViewById(R.id.deleteButton);
        backToMainPage.setOnClickListener(submitListener);
        //delete.setOnClickListener(deleteListener);
    }

    private View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        }
    };








    ContentValues mNewValues = new ContentValues();


//    View.OnClickListener deleteListener = new View.OnClickListener() {
//
//
//
//        @Override
////        public void onClick(View v) {
//
//
//            mNewValues.put(MyContentProvider.NationalNumber, nationalNumberTV.getText().toString().trim());
//            String mSelectionClause = MyContentProvider.NationalNumber + " = ? ";
//
//            String[] mSelectionArgs = { mNewValues.getText().toString().trim(),
//                    mNewValues.getText().toString().trim() };
//
//            int mRowsDeleted = getContentResolver().delete(MyContentProvider.CONTENT_URI, mSelectionClause,
//                    mSelectionArgs);
//
//            clear();
//        }
//    };



}