package com.gzeinnumer.oneiday6v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.gzeinnumer.oneiday6v2.databinding.ActivityMainBinding;
import com.gzeinnumer.oneiday6v2.menu1.CountDownActivity;
import com.gzeinnumer.oneiday6v2.menu3.PrefActivity;

public class MainActivity extends AppCompatActivity {
    //acivity_main.xml
    //ActivityMainBinding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClik();
    }

    private void initOnClik() {
        binding.button13.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CountDownActivity.class);
            startActivity(intent);
        });
        binding.button15.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PrefActivity.class);
            startActivity(intent);
        });
    }
}