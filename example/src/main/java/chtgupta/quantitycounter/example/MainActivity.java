package chtgupta.quantitycounter.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import chtgupta.quantitycounter.QuantityCounterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View root = findViewById(R.id.root);
        QuantityCounterView quantityCounter = findViewById(R.id.quantityCounter);

        quantityCounter.setValueListener(value -> {
            Snackbar.make(root, "onValueChange: " + value, Snackbar.LENGTH_SHORT).show();
        });

    }
}
