package com.bignerdranch.android.geoquiz;

/**
 * Created by dave on 3/9/14.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

public int getQuestion() {
    return mQuestion;
}

public void setQuestion(int question) {
    mQuestion =  question;
}
public boolean isTrueQuestion() {
    return mTrueQuestion;
    }

public void setTrueQuestion(boolean trueQuestion) {
    mTrueQuestion = trueQuestion;
}

}