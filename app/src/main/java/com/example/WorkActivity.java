package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.R;

public class WorkActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        Button work_button = findViewById(R.id.work_button);
        EditText editText1 = findViewById(R.id.number1);
        EditText editText2 = findViewById(R.id.number2);
        EditText editText3 = findViewById(R.id.number3);
        work_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.work_button) {
                    if (!editText1.getText().toString().isEmpty() && !editText2.getText().toString().isEmpty() && !editText3.getText().toString().isEmpty()) {
                        double result = Double.parseDouble(editText1.getText().toString()) - Double.parseDouble(editText2.getText().toString()) - Double.parseDouble(editText3.getText().toString());
                        Log.d("Tag", "Посчитано значение");
                        Intent intent = new Intent();
                        intent.putExtra("data", result);
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Что-то не так ввели...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}