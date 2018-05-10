package com.ofarido.testbank;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExamActivity extends AppCompatActivity {

    TextView toolbar_textView;
    ImageView backButton, nextButton;
    TextView question_textView, answer1_textView, answer2_textView, answer3_textView, answer4_textView, answer5_textView;
    FloatingActionButton more_fab, home_fab, finish_fab, time_fab;
    TextView time_TextView;
    ImageView answer1_icon, answer2_icon, answer3_icon, answer4_icon, answer5_icon;
    int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        toolbar_section();
        questions_section();
        answer1_icon = findViewById(R.id.answer1_icon);
        answer2_icon = findViewById(R.id.answer2_icon);
        answer3_icon = findViewById(R.id.answer3_icon);
        answer4_icon = findViewById(R.id.answer4_icon);
        answer5_icon = findViewById(R.id.answer5_icon);


        currentQuestionIndex = 1;

        toolbar_textView.setText("Sual  " + String.valueOf(currentQuestionIndex));

        SpannableString[] spannableStrings = changeQuestion(currentQuestionIndex);
        question_textView.setText(spannableStrings[0]);
        answer1_textView.setText(spannableStrings[1]);
        answer2_textView.setText(spannableStrings[2]);
        answer3_textView.setText(spannableStrings[3]);
        answer4_textView.setText(spannableStrings[4]);
        answer5_textView.setText(spannableStrings[5]);

        if (currentQuestionIndex == 1) {
            backButton.setVisibility(View.GONE);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestionIndex += 1;
                backButton.setVisibility(View.VISIBLE);

                toolbar_textView.setText("Sual  " + String.valueOf(currentQuestionIndex));

                SpannableString[] spannableStrings = changeQuestion(currentQuestionIndex);
                question_textView.setText(spannableStrings[0]);
                answer1_textView.setText(spannableStrings[1]);
                answer2_textView.setText(spannableStrings[2]);
                answer3_textView.setText(spannableStrings[3]);
                answer4_textView.setText(spannableStrings[4]);
                answer5_textView.setText(spannableStrings[5]);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestionIndex -= 1;

                if (currentQuestionIndex == 1) {
                    backButton.setVisibility(View.GONE);
                }

                toolbar_textView.setText("Sual  " + String.valueOf(currentQuestionIndex));

                SpannableString[] spannableStrings = changeQuestion(currentQuestionIndex);
                question_textView.setText(spannableStrings[0]);
                answer1_textView.setText(spannableStrings[1]);
                answer2_textView.setText(spannableStrings[2]);
                answer3_textView.setText(spannableStrings[3]);
                answer4_textView.setText(spannableStrings[4]);
                answer5_textView.setText(spannableStrings[5]);
            }
        });
        more_section();
    }


    long startTime = 0;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = (seconds / 60);
            seconds = seconds % 60;
            int hours = (minutes / 60);
            minutes = minutes % 60;

            time_TextView.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    private void toolbar_section() {
        backButton = findViewById(R.id.backArrow_imageView);
        nextButton = findViewById(R.id.accout_imageView);
        backButton.setImageResource(R.drawable.ic_action_back);
        nextButton.setImageResource(R.drawable.ic_action_next);
    }

    private void questions_section() {
        toolbar_textView = findViewById(R.id.toolbar_tv);

        question_textView = findViewById(R.id.question_textView);
        answer1_textView = findViewById(R.id.answer1_textView);
        answer2_textView = findViewById(R.id.answer2_textView);
        answer3_textView = findViewById(R.id.answer3_textView);
        answer4_textView = findViewById(R.id.answer4_textView);
        answer5_textView = findViewById(R.id.answer5_textView);
    }

    private void more_section() {
        time_TextView = findViewById(R.id.time_textView);
        more_fab = findViewById(R.id.more_fab);

        final LinearLayout home_layout = findViewById(R.id.home_layout);
        final LinearLayout finish_layout = findViewById(R.id.finish_layout);
        final LinearLayout time_layout = findViewById(R.id.time_layout);

        final Animation rotate_anim = AnimationUtils.loadAnimation(ExamActivity.this, R.anim.rotate_anim);
        final Animation rotate_back_anim = AnimationUtils.loadAnimation(ExamActivity.this, R.anim.rotate_back_anim);
        final Animation open_anim = AnimationUtils.loadAnimation(ExamActivity.this, R.anim.open_anim);
        final Animation close_anim = AnimationUtils.loadAnimation(ExamActivity.this, R.anim.close_anim);


        more_fab.setOnClickListener(new View.OnClickListener() {

            boolean isOpen = false;

            @Override
            public void onClick(View view) {
                if (isOpen) {
                    home_layout.setVisibility(View.GONE);
                    finish_layout.setVisibility(View.GONE);
                    time_layout.setVisibility(View.GONE);

                    more_fab.startAnimation(rotate_back_anim);

                    home_layout.startAnimation(close_anim);
                    finish_layout.startAnimation(close_anim);
                    time_layout.startAnimation(close_anim);

                    answer1_textView.startAnimation(open_anim);
                    answer2_textView.startAnimation(open_anim);
                    answer3_textView.startAnimation(open_anim);
                    answer4_textView.startAnimation(open_anim);
                    answer5_textView.startAnimation(open_anim);

                    isOpen = false;
                } else {
                    home_layout.setVisibility(View.VISIBLE);
                    finish_layout.setVisibility(View.VISIBLE);
                    time_layout.setVisibility(View.VISIBLE);

                    more_fab.startAnimation(rotate_anim);

                    home_layout.startAnimation(open_anim);
                    finish_layout.startAnimation(open_anim);
                    time_layout.startAnimation(open_anim);

                    answer1_textView.startAnimation(close_anim);
                    answer2_textView.startAnimation(close_anim);
                    answer3_textView.startAnimation(close_anim);
                    answer4_textView.startAnimation(close_anim);
                    answer5_textView.startAnimation(close_anim);

                    isOpen = true;
                }
            }
        });

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

        home_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder home_builder = new AlertDialog.Builder(ExamActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.home_dialog, null);
                Button yesButton = mView.findViewById(R.id.yes_button);
                Button noButton = mView.findViewById(R.id.no_button);

                home_builder.setView(mView);
                final AlertDialog dialog = home_builder.create();
                dialog.show();

                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
    }

    int selectedTag = 0;
    public void answer_selecting(View view) {
        ImageView imageButton = (ImageView) view;
        String tag = (String) imageButton.getTag();

        if (selectedTag != 0) {
            ImageView unchecked_image = findViewById(selectedTag);
            String unchecked_tag = (String) unchecked_image.getTag();
            String resource = "ic_launcher_answer" + unchecked_tag + "_unchecked";
            unchecked_image.setImageResource(getApplicationContext().getResources().getIdentifier(resource, "mipmap", getApplicationContext().getPackageName()));

            if (tag.equals(unchecked_tag)) {
                selectedTag = 0;
                return;
            }
        }

        selectedTag = imageButton.getId();

        if (tag.equals("1")) {
            imageButton.setImageResource(R.mipmap.ic_launcher_answer1_checked);
        } else if (tag.equals("2")) {
            imageButton.setImageResource(R.mipmap.ic_launcher_answer2_checked);
        } else if (tag.equals("3")) {
            imageButton.setImageResource(R.mipmap.ic_launcher_answer3_checked);
        } else if (tag.equals("4")) {
            imageButton.setImageResource(R.mipmap.ic_launcher_answer4_checked);
        } else if (tag.equals("5")) {
            imageButton.setImageResource(R.mipmap.ic_launcher_answer5_checked);
        }
    }

    public SpannableString[] changeQuestion(int questionIndex) {
        SpannableString[] questionAndAnswers = new SpannableString[6];

        //array deki her 6 ci string den bawliyir suallar
        questionIndex = 6 * (questionIndex - 1);

        //string arrayi qebul edir
        String[] myString = getResources().getStringArray(R.array.test);

        for (int i = 0; i < 6; i++) {

            String string = myString[questionIndex + i];
            //Log.d("cool", string);

            SpannableString spannableString;

            if (string.contains("(|")) {
                //question text i spannableString e elave edir
                spannableString = new SpannableString(string.substring(0, string.indexOf("(|")));
                //Log.d("cool", spannableString.toString());

                while (string.contains("(|")) {

                    //wekilin bawlangic index ini qebul edir
                    int indexA = Integer.parseInt(string.substring(string.indexOf("(|") + 2, string.indexOf("|)")));
                    //Log.d("cool", String.valueOf(indexA));

                    //weklin son index ini qebul edir
                    int indexB = Integer.parseInt(string.substring(string.indexOf("{|") + 2, string.indexOf("|}")));
                    //Log.d("cool", String.valueOf(indexB));

                    //weklin adini qebul edir
                    String imageName = string.substring(string.indexOf("[|") + 2, string.indexOf("|]"));
                    //Log.d("cool", imageName);

                    //string den elave edilmiw wekilin data sini silir
                    string = string.substring(string.indexOf("|]") + 2);
                    //Log.d("cool", string);

                    //wekili spannableString e elave edir
                    int resource = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    ImageSpan imageSpan = new ImageSpan(this, resource);
                    spannableString.setSpan(imageSpan, indexA, indexB, 0);

                }
            } else {
                spannableString = SpannableString.valueOf(string);
            }

            questionAndAnswers[i] = spannableString;
        }

        Log.d("cool", String.valueOf(questionAndAnswers[0]));
        Log.d("cool", String.valueOf(questionAndAnswers[1]));
        Log.d("cool", String.valueOf(questionAndAnswers[2]));
        Log.d("cool", String.valueOf(questionAndAnswers[3]));
        Log.d("cool", String.valueOf(questionAndAnswers[4]));
        Log.d("cool", String.valueOf(questionAndAnswers[5]));

        return questionAndAnswers;
    }


}
