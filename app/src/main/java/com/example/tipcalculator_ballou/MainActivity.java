package com.example.tipcalculator_ballou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //declare edittexts, radioButtons, and buttons
    private EditText paymentET;
    private EditText peopleET;
    private EditText customTipAmount;
    private RadioGroup tipamounts;
    private Button reset;
    private Button calculate;
    //declare doubles to calculate tip payment
    //tipPercent
    private Double tipPercent = 0.0;
    //payment
    private Double payment;
    //people
    private Double people;
    //result
    private Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paymentET = (EditText) this.findViewById(R.id.payment);
        peopleET = (EditText) this.findViewById(R.id.people);
        customTipAmount = (EditText) this.findViewById(R.id.customTipAmount);
        tipamounts = (RadioGroup) this.findViewById(R.id.tipamounts);
        reset = (Button) this.findViewById(R.id.reset);
        calculate = (Button) this.findViewById(R.id.calculate);
        //onCheckedChange looks like it's an OnClickedListener that automatically has the button id
        tipamounts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //if id = (R.id.tipone)
                if (checkedId == R.id.tipOne){
                    //tipPercent = getString(R.string.tip1)
                    //remove % from end of string, then convert to double
                    tipPercent = percentStringToDouble(getString(R.string.tip1));
                }
                else if (checkedId == R.id.tipTwo){
                    //tipPercent = getString(R.string.tip2)
                    //remove % from end of string, then convert to double
                    tipPercent = percentStringToDouble(getString(R.string.tip2));
                }
                else if (checkedId == R.id.tipThree){
                    //tipPercent = getString(R.string.tip3)
                    //remove % from end of string, then convert to double
                    tipPercent = percentStringToDouble(getString(R.string.tip3));
                }
                else if (checkedId == R.id.tipFour){
                    //tipPercent = getString(R.strings.tip4)
                    //remove % from end of string, then convert to double
                    tipPercent = percentStringToDouble(getString(R.string.tip4));
                }
                else if (checkedId == R.id.customTip){
                    //get tipPercent from customTipAmount
                    tipPercent = percentStringToDouble(customTipAmount.getText().toString());
                }
                else {
                    //This should never happen
                    //tipPercent = 0
                    tipPercent = 0.0;
                }
            }
        });
        //when reset button is pressed, set everything back to default
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //when calculate button is pressed, calculate tip and go to another activity
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment = (Double.parseDouble(paymentET.getText().toString()));
                people = (Double.parseDouble(peopleET.getText().toString()));
                result = (((payment * tipPercent)/100 )+payment)/people;
            }
        });
    }
    //method to calculate percent from string
    public Double percentStringToDouble (String percentString){
        //check to see if percentString is valid (only numerals, one decimal point optional, ends with %)
        //       [(/d+%$)((/d)*\\.(/d)+%$)]
        if (percentString.matches("[(/d+%$)((/d)*\\.(/d)+%$)]")){
            //remove % from end, then convert to double
            return (Double.parseDouble(percentString.replace("%","")));
        }
        else {
            //message, and unique return value
            System.out.println("Enter a nonnegative number followed by a %.");
            System.out.println("1% , 1.0%, and .1% work, but -1%, 1.1.2%, and 1.% do not.");
            return -1.0;
        }
    }
}