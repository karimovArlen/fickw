package com.example.lesson13mounth;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity<input> extends AppCompatActivity {

    private Button go;
    private TextInputEditText pass_btn, user_btn;
    private TextInputLayout user, pass;
    private ImageView car;
    private String login;
    private int lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_btn = findViewById(R.id.f1);
        pass_btn = findViewById(R.id.f2);
        car = findViewById(R.id.car_img);
        go = findViewById(R.id.GO);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.dop);
        go.setOnClickListener(view -> go_j());
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


        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(car);

    }


    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }


    }

    private boolean validate_name() {
        if (user_btn.getText().toString().trim().isEmpty()) {
            user.setError("EnterName");
            requestFocus(user_btn);
            return false;
        }
        return true;


    }

    private boolean validate_pass() {
        if (pass_btn.getText().toString().trim().isEmpty()) {
            pass.setError("Ввидите пароль!");
            requestFocus(pass_btn);
            return false;
        } else {
            if (pass_btn.getText().toString().trim().length() < 6) {
                pass.setError("Пароль не должен быть меньше 6 ");
                requestFocus(pass_btn);
                return false;
            }
        }
        return true;


    }

    private void go_j() {
        if (!validate_name()) {
            return;
        }
        if (!validate_pass()) {
            return;
        }


        String sname = user_btn.getText().toString().trim() + "";
        String snam = pass_btn.getText().toString().trim() + "";
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDate();
            }
        });
    }
    public void sendDate()
    {
        login = user_btn.getText().toString().trim();
        lock = Integer.parseInt(pass_btn.getText().toString().trim());
        Intent i = new Intent(MainActivity.this,MainActivity2.class);


        i.putExtra(MainActivity2.NAME,login);
        i.putExtra(MainActivity2.AGE,lock);


        startActivity(i);
    }

}

