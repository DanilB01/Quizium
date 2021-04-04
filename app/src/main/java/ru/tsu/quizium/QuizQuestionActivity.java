package ru.tsu.quizium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class QuizQuestionActivity extends AppCompatActivity
implements CompoundButton.OnCheckedChangeListener {

    ToggleButton[] answers = new ToggleButton[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        answers[0] = findViewById(R.id.option1Button);
        answers[1] = findViewById(R.id.option2Button);
        answers[2] = findViewById(R.id.option3Button);
        answers[3] = findViewById(R.id.option4Button);

        for(ToggleButton answer: answers)
            answer.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(IfNeedToRecheck()){
            RecheckButtons(buttonView.getId());
        }
    }

    private boolean IfNeedToRecheck() {
        int checkCounter = 0;
        for(ToggleButton answer: answers) {
            if(answer.isChecked())
                checkCounter++;
        }
        return !(checkCounter < 2);
    }

    private void RecheckButtons(int id) {
        for(ToggleButton answer: answers) {
            if(answer.isChecked() && answer.getId() != id){
                answer.setChecked(false);
                break;
            }
        }
    }
}