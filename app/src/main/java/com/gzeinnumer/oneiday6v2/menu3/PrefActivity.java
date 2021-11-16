package com.gzeinnumer.oneiday6v2.menu3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.gzeinnumer.oneiday6v2.R;
import com.gzeinnumer.oneiday6v2.databinding.ActivityMainBinding;
import com.gzeinnumer.oneiday6v2.databinding.ActivityPrefBinding;

import java.util.Map;

public class PrefActivity extends AppCompatActivity {

    private ActivityPrefBinding binding;

    public static final String SHARED_PREFERENCE_NAME = "com.example.basicandroid.day6.datastorage.Day6SharedPreferenceFragment";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrefBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        initView();

        readSavedDataFromSharedPreference();
    }

    private void initView() {
        binding.spButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = binding.spTextInputLayout.getEditText().getText().toString();
                String value = binding.spTextInputLayout2.getEditText().getText().toString();
                saveDataToSharedPreferenceAsync(key, value);
            }
        });

        binding.spButtonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSavedDataFromSharedPreference();
            }
        });
    }

    private void saveDataToSharedPreferenceAsync(String key, String value){
        sharedPreferences.edit().putString(key, value).apply();
    }

    private void readSavedDataFromSharedPreference(){
        String text = "";
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            text += "Key :"+ entry.getKey() + " ; Value : " + entry.getValue().toString() + "\n";
        }
        binding.spTVFromFile.setText(text);
    }
}