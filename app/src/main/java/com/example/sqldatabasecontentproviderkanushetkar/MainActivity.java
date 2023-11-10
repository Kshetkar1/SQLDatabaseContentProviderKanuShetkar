package com.example.sqldatabasecontentproviderkanushetkar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {


    Button resetBT;
    Button saveBT;
    Button view;
    RadioGroup gender;
    Spinner levels;
    EditText nationalNumberET, nameET, speciesET, HeightET, WeightET, hpET, attackET, DefenseET;
    TextView nationalNumberTV, nameTV, speciesTV, genderTV, heightTV, weightTV, levelTV, hpTV, attackTV, DefenseTV;

    String level;

    private View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
    };
    private AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                    Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(getApplicationContext(), "You didn't select anything", Toast.LENGTH_SHORT).show();
        }
    };

        View.OnClickListener resetListener = new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (view == findViewById(R.id.Reset)) {
                    nationalNumberET.setText("896");
                    nameET.setText("Glastrier");
                    speciesET.setText("Wild Horse Pokemon");
                    HeightET.setText("N/A");
                    WeightET.setText("800.0 kg");

                    hpET.setText("0");
                    attackET.setText("0");
                    DefenseET.setText("0");
                    levels.setSelection(0);
                    gender.clearCheck();


                    Toast.makeText(MainActivity.this, "Everything has been reset!!!!!!", Toast.LENGTH_SHORT).show();

                } else {
                    boolean check = true;
                    if (nationalNumberET.getText().toString().matches("") || !(0 <= Float.valueOf(nationalNumberET.getText().toString()) && Float.valueOf(nationalNumberET.getText().toString()) <= 1010)) {
                        check = false;
                        nationalNumberET.setTextColor(getResources().getColor(R.color.red));

                    }
                    if (nameET.getText().toString().matches("") || !(3 <= nameET.getText().toString().length() && nameET.getText().toString().length() <= 12)) {
                        check = false;
                        nameTV.setTextColor(getResources().getColor(R.color.red));
                    }
                    if (gender.getCheckedRadioButtonId() == -1) {
                        check = false;
                        genderTV.setTextColor(getResources().getColor(R.color.red));
                    }
                    if (hpET.getText().toString().matches("") || !(1 <= Float.valueOf(hpET.getText().toString()) && Float.valueOf(hpET.getText().toString()) <= 362)) {
                        check = false;
                        hpTV.setTextColor(getResources().getColor(R.color.red));

                    }
                    if (attackET.getText().toString().matches("") || !(5 <= Float.valueOf(attackET.getText().toString()) && Float.valueOf(attackET.getText().toString()) <= 526)) {
                        check = false;
                        attackTV.setTextColor(getResources().getColor(R.color.red));

                    }
                    if (DefenseET.getText().toString().matches("") || !(5 <= Float.valueOf(DefenseET.getText().toString()) && Float.valueOf(DefenseET.getText().toString()) <= 614)) {
                        check = false;
                        DefenseTV.setTextColor(getResources().getColor(R.color.red));
                        Toast.makeText(MainActivity.this, "Everything has been reset!!!!!!", Toast.LENGTH_SHORT).show();
                    }
                    if (HeightET.getText().toString().matches("") || !(0.3 <= Float.valueOf(HeightET.getText().toString()) && Float.valueOf(HeightET.getText().toString()) <= 19.99)) {
                        check = false;
                        heightTV.setTextColor(getResources().getColor(R.color.red));
                    }
                    if (WeightET.getText().toString().matches("") || !(0.1 <= Float.valueOf(WeightET.getText().toString()) && Float.valueOf(WeightET.getText().toString()) <= 820)) {
                        check = false;
                        weightTV.setTextColor(getResources().getColor(R.color.red));
                    }
                    if (!check) {
                        Toast.makeText(MainActivity.this, "Please fix all fields with red labels!", Toast.LENGTH_SHORT).show();
                    } else {

                        nationalNumberTV.setTextColor(Color.BLACK);
                        nameTV.setTextColor(Color.BLACK);
                        speciesTV.setTextColor(Color.BLACK);
                        genderTV.setTextColor(Color.BLACK);
                        heightTV.setTextColor(Color.BLACK);
                        weightTV.setTextColor(Color.BLACK);
                        levelTV.setTextColor(Color.BLACK);
                        hpTV.setTextColor(Color.BLACK);
                        attackTV.setTextColor(Color.BLACK);
                        DefenseTV.setTextColor(Color.BLACK);

                        ContentValues mNewValues = new ContentValues();

                        mNewValues.put(MyContentProvider.NationalNumber, nationalNumberET.getText().toString().trim());
                        mNewValues.put(MyContentProvider.Name, nameET.getText().toString().trim());

                        mNewValues.put(MyContentProvider.Species, speciesET.getText().toString().trim());
                        //radioButton5
                        //radioButton6

                        RadioButton radioButton5 = findViewById(R.id.radioButton5);
                        RadioButton radioButton6 = findViewById(R.id.radioButton6);
                        String genderLabel = "";
                        if (radioButton5.isChecked() == true && radioButton6.isChecked() == false) {
                            genderLabel = "Males";
                        } else if (radioButton5.isChecked() == false && radioButton6.isChecked() == true) {
                            genderLabel = "Females";
                        }

                            mNewValues.put(MyContentProvider.Gender, genderLabel);
                            mNewValues.put(MyContentProvider.Height, HeightET.getText().toString().trim());
                            mNewValues.put(MyContentProvider.Weight, WeightET.getText().toString().trim());


                            mNewValues.put(MyContentProvider.Level, Integer.parseInt(levels.getSelectedItem().toString()));
                            mNewValues.put(MyContentProvider.HP, hpET.getText().toString().trim());
                            mNewValues.put(MyContentProvider.Attack, attackET.getText().toString().trim());
                            mNewValues.put(MyContentProvider.Defense, DefenseET.getText().toString().trim());


                            getContentResolver().insert(MyContentProvider.CONTENT_URI, mNewValues);

                            //clear();


                            Toast.makeText(MainActivity.this, "Your entry has been submitted successfully!", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            };



//    View.OnClickListener submitlistener = new View.OnClickListener(){
//
//    String hpval = hp.getText().toString();
//    if(Integer.valueof(hpval)>700){
//        //this was a bunch of if statements thingy
//        }
//
//    {
//
//
//    }
//
//}


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                levels = findViewById(R.id.Level);
                nationalNumberET = findViewById(R.id.NationalNumber);
                nameET = findViewById(R.id.Name);
                speciesET = findViewById(R.id.Species);
                HeightET = findViewById(R.id.Height);
                WeightET = findViewById(R.id.Weight);
                hpET = findViewById(R.id.HP);
                attackET = findViewById(R.id.Attack);
                DefenseET = findViewById(R.id.DefenseET);
                gender = findViewById(R.id.Gender);
                resetBT = findViewById(R.id.Reset);
                saveBT = findViewById(R.id.Save);
                view = findViewById(R.id.view);

                levelTV = findViewById(R.id.levelTV);
                nationalNumberTV = findViewById(R.id.nationalNumberTV);
                nameTV = findViewById(R.id.nameTV);
                speciesTV = findViewById(R.id.speciesTV);
                heightTV = findViewById(R.id.heightTV);
                weightTV = findViewById(R.id.weightTV);
                hpTV = findViewById(R.id.hpTV);
                attackTV = findViewById(R.id.attackTV);
                DefenseTV = findViewById(R.id.DefenseTV);
                genderTV = findViewById(R.id.genderTV);


                nationalNumberET.setText("896");
                nameET.setText("Glastrier");
                speciesET.setText("Wild Horse Pokemon");
                HeightET.setText("N/A");
                WeightET.setText("800.0 kg");

                hpET.setText("0");
                attackET.setText("0");
                DefenseET.setText("0");
                resetBT.setOnClickListener(resetListener);
                saveBT.setOnClickListener(resetListener);
                view.setOnClickListener(submitListener);

                //Button resetButton = findViewById(R.id.Reset);


            }

            private void useStringResource() {
                String[] values = getResources().getStringArray(R.array.levels);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, values);
                levels.setAdapter(adapter);
            }
        };






//    private String initialText;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////
//        TextView textView = findViewById(R.id.myTextView);
//        initialText = textView.getText().toString();
//    }


