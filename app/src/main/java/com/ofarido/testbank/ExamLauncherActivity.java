package com.ofarido.testbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class ExamLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_launcher);

        String title = getIntent().getExtras().getString("examName");
        TextView mTextView = findViewById(R.id.toolbar_tv);
        mTextView.setText(title);

        ImageView backButton = findViewById(R.id.backArrow_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamLauncherActivity.super.onBackPressed();
            }
        });

        Button launcherButton = findViewById(R.id.launcherButton);
        launcherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamLauncherActivity.this, ExamActivity.class);
                startActivity(intent);
            }
        });


    }

    boolean sb1_status = true;
    boolean sb2_status = true;
    boolean sb3_status = true;
    boolean sb4_status = true;
    boolean sb5_status = true;

    public void addSubject(View view){



        if(view.getTag().toString().equals("subject1")){

            ImageView sb1_img = findViewById(R.id.subject1_imageView);

            if(sb1_status) {
                sb1_img.setImageResource(R.drawable.ic_action_addbutton);
                sb1_status = false;
            } else {
                sb1_img.setImageResource(R.drawable.ic_action_removebutton);
                sb1_status = true;
            }
        }

        if(view.getTag().toString().equals("subject2")){

            ImageView sb1_img = findViewById(R.id.subject2_imageView);

            if(sb2_status) {
                sb1_img.setImageResource(R.drawable.ic_action_addbutton);
                sb2_status = false;
            } else {
                sb1_img.setImageResource(R.drawable.ic_action_removebutton);
                sb2_status = true;
            }
        }

        if(view.getTag().toString().equals("subject3")){

            ImageView sb1_img = findViewById(R.id.subject3_imageView);

            if(sb3_status) {
                sb1_img.setImageResource(R.drawable.ic_action_addbutton);
                sb3_status = false;
            } else {
                sb1_img.setImageResource(R.drawable.ic_action_removebutton);
                sb3_status = true;
            }
        }

        if(view.getTag().toString().equals("subject4")){

            ImageView sb1_img = findViewById(R.id.subject4_imageView);

            if(sb4_status) {
                sb1_img.setImageResource(R.drawable.ic_action_addbutton);
                sb4_status = false;
            } else {
                sb1_img.setImageResource(R.drawable.ic_action_removebutton);
                sb4_status = true;
            }
        }

        if(view.getTag().toString().equals("subject5")){

            ImageView sb1_img = findViewById(R.id.subject5_imageView);

            if(sb5_status) {
                sb1_img.setImageResource(R.drawable.ic_action_addbutton);
                sb5_status = false;
            } else {
                sb1_img.setImageResource(R.drawable.ic_action_removebutton);
                sb5_status = true;
            }
        }
    }
}
