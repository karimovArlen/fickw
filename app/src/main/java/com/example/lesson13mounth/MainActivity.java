package com.example.lesson13mounth;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button go;
    private TextInputEditText pass_btn , user_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_btn = findViewById(R.id.f1);
        pass_btn = findViewById(R.id.f2);
        go = findViewById(R.id.GO);


        user_btn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {

                if (user_btn.getText().toString().length() > 0) {
                    go.setBackgroundColor(getColor(R.color.black));
                } else {
                    go.setBackgroundColor(getColor(R.color.teal_700));



            }


        }
    });
    }
}
