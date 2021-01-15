package com.loopbreakr.viewmodelform;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class SharedViewModel extends ViewModel {
    //Initialize variables and set them to empty strings (incase you are submitting data that can not be null and the user doesnt input a value. You can also write a method for this
    private String answerOneText = "";
    private String answerTwoText = "";
    private String answerThreeText = "";

    public void setAnswerOneText(CharSequence input) {
        answerOneText = input.toString();
    }

    public void setAnswerTwoText(CharSequence input) {
        answerTwoText = input.toString();
    }

    public void setAnswerThreeText(CharSequence input){
        answerThreeText = input.toString();
    }

    public String getAnswerOneText() {
        return answerOneText;
    }

    public String getAnswerTwoText() {
        return answerTwoText;
    }

    public String getAnswerThreeText() {
        return answerThreeText;
    }

    public String getAllAnswersString(){
        return "Answer 1: " + answerOneText + "\n Answer 2: " + answerTwoText + "\n Answer 3: " + answerThreeText;
    }

}
