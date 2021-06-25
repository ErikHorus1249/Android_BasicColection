package com.example.testpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName;
    Button btnAdd;
    SharedPreferences sharedPreferences;
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getBaseContext().getSharedPreferences("infosaver", MODE_PRIVATE);
        tvName = findViewById(R.id.tvName);
        btnAdd = findViewById(R.id.btnAdd);
        edName = findViewById(R.id.edName);

        String mess = sharedPreferences.getString("name", "");
        if(!mess.equals(""))
            tvName.setText("Xin chao "+mess);

        add();
    }

    public void add(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String name  = edName.getText().toString().trim();
                editor.putString("name",name);
                editor.commit();
                Toast.makeText(getBaseContext(), "Them thanh cong User " +name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}