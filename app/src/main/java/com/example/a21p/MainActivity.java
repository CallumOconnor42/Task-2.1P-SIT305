package com.example.a21p;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner sourceUnitSpinner, destinationUnitSpinner;
    private EditText valueEditText;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceUnitSpinner = findViewById(R.id.sourceUnitSpinner);
        destinationUnitSpinner = findViewById(R.id.destinationUnitSpinner);
        valueEditText = findViewById(R.id.valueEditText);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(adapter);
        destinationUnitSpinner.setAdapter(adapter);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValue();
            }
        });
    }

    private void convertValue() {
        // Check if input value is empty
        if (valueEditText.getText().toString().isEmpty()) {
            resultTextView.setText("Please enter a value");
            return;
        }

        // Get input values
        String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
        String destinationUnit = destinationUnitSpinner.getSelectedItem().toString();
        double value = Double.parseDouble(valueEditText.getText().toString());

        // Check if source unit and destination unit are the same
        if (sourceUnit.equals(destinationUnit)) {
            resultTextView.setText("Source unit and destination unit are the same");
            return;
        }

        // Perform conversion based on selected units
        double result;
        if (sourceUnit.equals("Inch") && destinationUnit.equals("Centimeter")) {
            result = value * 2.54;
        } else if (sourceUnit.equals("Centimeter") && destinationUnit.equals("Inch")) {
            result = value / 2.54;
        } else if (sourceUnit.equals("Foot") && destinationUnit.equals("Centimeter")) {
            result = value * 30.48;
        } else if (sourceUnit.equals("Centimeter") && destinationUnit.equals("Foot")) {
            result = value / 30.48;
        } else if (sourceUnit.equals("Yard") && destinationUnit.equals("Centimeter")) {
            result = value * 91.44;
        } else if (sourceUnit.equals("Centimeter") && destinationUnit.equals("Yard")) {
            result = value / 91.44;
        } else if (sourceUnit.equals("Mile") && destinationUnit.equals("Kilometer")) {
            result = value * 1.60934;
        } else if (sourceUnit.equals("Kilometer") && destinationUnit.equals("Mile")) {
            result = value / 1.60934;
        } else if (sourceUnit.equals("Pound") && destinationUnit.equals("Kilogram")) {
            result = value * 0.453592;
        } else if (sourceUnit.equals("Kilogram") && destinationUnit.equals("Pound")) {
            result = value / 0.453592;
        } else if (sourceUnit.equals("Ounce") && destinationUnit.equals("Gram")) {
            result = value * 28.3495;
        } else if (sourceUnit.equals("Gram") && destinationUnit.equals("Ounce")) {
            result = value / 28.3495;
        } else if (sourceUnit.equals("Ton") && destinationUnit.equals("Kilogram")) {
            result = value * 907.185;
        } else if (sourceUnit.equals("Kilogram") && destinationUnit.equals("Ton")) {
            result = value / 907.185;
        } else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Fahrenheit")) {
            result = (value * 1.8) + 32;
        } else if (sourceUnit.equals("Fahrenheit") && destinationUnit.equals("Celsius")) {
            result = (value - 32) / 1.8;
        } else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Kelvin")) {
            result = value + 273.15;
        } else if (sourceUnit.equals("Kelvin") && destinationUnit.equals("Celsius")) {
            result = value - 273.15;
        } else {
            result = value; // Default, no conversion
            resultTextView.setText("Invalid conversion");
            return;
        }

        // Display result
        resultTextView.setText(String.format("%.2f", result));
    }


}
