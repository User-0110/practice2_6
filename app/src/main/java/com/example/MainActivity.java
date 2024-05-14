package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.start_button);
        textView = findViewById(R.id.result);
        button.setOnClickListener(this);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        o -> {
            if (o.getData() != null) {
                double res = o.getData().getDoubleExtra("data", 0);
                Log.d("tag", "Получено значение: " + res);
                textView.setText("Разница чисел: " + res);
            }
        }
    );

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_button) {
            Intent intent = new Intent(this, WorkActivity.class);
            activityResultLauncher.launch(intent);
        }
    }
}