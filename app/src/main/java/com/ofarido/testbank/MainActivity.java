package com.ofarido.testbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button qrup1_btn;
    Button qrup2_btn;
    Button qrup3_btn;
    Button qrup4_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView backArrow_ImageView = findViewById(R.id.backArrow_imageView);
        backArrow_ImageView.setVisibility(View.INVISIBLE);

        qrup1_btn = findViewById(R.id.qrup1_btn);
        qrup1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                intent.putExtra("groupName","I qrup");
                startActivity(intent);

            }
        });

        qrup2_btn = findViewById(R.id.qrup2_btn);
        qrup2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, test.class);
                intent.putExtra("groupName","II qrup");
                startActivity(intent);
            }
        });

        qrup3_btn = findViewById(R.id.qrup3_btn);
        qrup3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                intent.putExtra("groupName","III qrup");
                startActivity(intent);
            }
        });

        qrup4_btn = findViewById(R.id.qrup4_btn);
        qrup4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                intent.putExtra("groupName","IV qrup");
                startActivity(intent);
            }
        });


    }
}
