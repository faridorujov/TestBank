package com.ofarido.testbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GroupActivity extends AppCompatActivity {

    ExpandableListView mExpandableListView;

    String[] years = {"2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005"};
    String[] examName = {"Sınaq imtahanı 1", "Sınaq imtahanı 2", "Qəbul imtahaı"};
    String[] subjects = {"Riyaziyyat", "Azərbaycan dili", "Ingilis dili", "Kimya", "Fizika"};

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        final String groupName = getIntent().getExtras().getString("groupName");
        mTextView = findViewById(R.id.toolbar_tv);
        mTextView.setText(groupName);

        ImageView backButton = findViewById(R.id.backArrow_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupActivity.super.onBackPressed();
            }
        });

        mExpandableListView = findViewById(R.id.expandableListView);

        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(getApplicationContext());
        mExpandableListView.setAdapter(expandableListViewAdapter);

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            int previousItem = -1;

            @Override
            public void onGroupExpand(int i) {
                if(i != previousItem){
                    mExpandableListView.collapseGroup(previousItem);
                    previousItem = i;
                }
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                TextView textView = (TextView) view;

                Intent intent = new Intent(GroupActivity.this, ExamLauncherActivity.class);
                intent.putExtra("examName", textView.getText().toString());
                startActivity(intent);


                return true;
            }
        });
    }

}
