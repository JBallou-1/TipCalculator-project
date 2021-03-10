package com.example.tipcalculator_ballou;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //declare edittexts, radioButtons, and buttons
    private EditText payment;
    private EditText people;
    private EditText customTipAmount;
    private RadioGroup tipamounts;
    private RadioButton selected;
    private Button reset;
    private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        payment = (EditText) this.findViewById(R.id.payment);
        people = (EditText) this.findViewById(R.id.people);
        customTipAmount = (EditText) this.findViewById(R.id.customTipAmount);
        tipamounts = (RadioGroup) this.findViewById(R.id.tipamounts);
        reset = (Button) this.findViewById(R.id.reset);
        calculate = (Button) this.findViewById(R.id.calculate);
        //have tipamounts set a listener that, when clicked, calls getCheckedRadioButtonID() and do things depending on what that returns
    }
}