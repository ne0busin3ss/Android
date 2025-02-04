package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {


    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.questions_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
            new TrueFalse(R.string.question_Dave, true),
    };

    private int mCurrentIndex = 0;
    private void updateQuestion() {
        int question =mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if(userPressedTrue == answerTrue) {
            messageResId = R.string.correct_toast;
        } else {
                messageResId = R.string.incorrect_toast;
            }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fragment);

    mQuestionTextView =(TextView)findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mTrueButton = (Button)findViewById(R.id.button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton = (Button)findViewById(R.id.button2);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                checkAnswer (false);
            }

            });
        mNextButton = (Button)findViewById(R.id.button3);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
             }

           });
           updateQuestion();

        mPreviousButton = (Button)findViewById(R.id.button4);
        mPreviousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
               mCurrentIndex--;
                if (mCurrentIndex < 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                }
                //mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;
                updateQuestion();
            }

        });

        updateQuestion();
    }
}


