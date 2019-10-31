package com.example.n;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textBox,textBox1,textBox2;
    Button passButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = (EditText)findViewById(R.id.textBox);
        textBox1 = (EditText)findViewById(R.id.textBox1);
        textBox2 = (EditText)findViewById(R.id.textBox2);
        passButton = (Button)findViewById(R.id.passButton);

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textBox.getText().toString();
                String s = textBox2.getText().toString();
                String st = textBox1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), aa.class);
                intent.putExtra("message", str);
                intent.putExtra("messag", st);
                intent.putExtra("messa", s);

                startActivity(intent);
            }
        });
    }
}