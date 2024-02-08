package com.college.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.college.converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private static final Float CONVERSION_RATE = 0.80F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "Enter onCreate()");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button buttonConvert = binding.convertButton;

        buttonConvert.setOnClickListener(view -> {
            convertCurrency(view);
        });

        Log.i("MainActivity", "Exit onCreate()");
    }

    public void convertCurrency(View view) {
        Log.i("MainActivity", "Enter convertCurrency() ");

        EditText inputView = binding.entryId;
        String inputAmount = inputView.getText().toString();

        TextView resultView = binding.resultId;

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;

            // Use string resource for "Euros"
            String resultString = getString(R.string.result_format, resultFloat);
            resultView.setText(resultString);
        }

        Log.i("MainActivity", "Exit convertCurrency() ");
    }
}
