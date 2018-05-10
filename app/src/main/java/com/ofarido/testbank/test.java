package com.ofarido.testbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TextView;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SpannableString[] spannableStrings = changeQuestion(1);
        TextView textView = findViewById(R.id.testText);
        textView.setText(spannableStrings[0]);
//        SpannableString question = null, answer1 = null, answer2 = null, answer3 = null, answer4 = null, answer5 = null;
//        int questionIndex = 0;
//
//
//        //string arrayi qebul edir
//        String[] myString = getResources().getStringArray(R.array.test);
//
//        for (int i = 0; i < 6; i++) {
//
//            String string = myString[questionIndex + i]; //[1]
//            //Log.d("cool", string);
//
//            SpannableString spannableString = null;
//
//            if (string.contains("(|")) {
//                //question text i spannableString e elave edir
//                spannableString = new SpannableString(string.substring(0, string.indexOf("(|")));
//                //Log.d("cool", spannableString.toString());
//
//                while (string.contains("(|")) {
//
//                    //wekilin bawlangic index ini qebul edir
//                    int indexA = Integer.parseInt(string.substring(string.indexOf("(|") + 2, string.indexOf("|)")));
//                    //Log.d("cool", String.valueOf(indexA));
//
//                    //weklin son index ini qebul edir
//                    int indexB = Integer.parseInt(string.substring(string.indexOf("{|") + 2, string.indexOf("|}")));
//                    //Log.d("cool", String.valueOf(indexB));
//
//                    //weklin adini qebul edir
//                    String imageName = string.substring(string.indexOf("[|") + 2, string.indexOf("|]"));
//                    //Log.d("cool", imageName);
//
//                    //string den elave edilmiw wekilin data sini silir
//                    string = string.substring(string.indexOf("|]") + 2);
//                    //Log.d("cool", string);
//
//                    //wekili spannableString e elave edir
//                    int resource = getResources().getIdentifier(imageName, "drawable", getPackageName());
//                    ImageSpan imageSpan = new ImageSpan(this, resource);
//                    spannableString.setSpan(imageSpan, indexA, indexB, 0);
//
//                }
//            } else {
//                spannableString = SpannableString.valueOf(string);
//            }
//
//            if (i == 0) {
//                question = spannableString;
//            } else if (i == 1) {
//                answer1 = spannableString;
//            } else if (i == 2) {
//                answer2 = spannableString;
//            } else if (i == 3) {
//                answer3 = spannableString;
//            } else if (i == 4) {
//                answer4 = spannableString;
//            } else if (i == 5) {
//                answer5 = spannableString;
//            }
//        }
//
//
//        Log.d("cool", String.valueOf(question));
//        Log.d("cool", String.valueOf(answer1));
//        Log.d("cool", String.valueOf(answer2));
//        Log.d("cool", String.valueOf(answer3));
//        Log.d("cool", String.valueOf(answer4));
//        Log.d("cool", String.valueOf(answer5));
//
//        TextView testText = findViewById(R.id.testText);
//        testText.setText(question);
//
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
