package ru.tsu.quizium

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class QuizQuestionActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    var answers = arrayOfNulls<ToggleButton>(4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        answers[0] = findViewById(R.id.option1Button)
        answers[1] = findViewById(R.id.option2Button)
        answers[2] = findViewById(R.id.option3Button)
        answers[3] = findViewById(R.id.option4Button)
        for (answer in answers) answer!!.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (IfNeedToRecheck()) {
            RecheckButtons(buttonView.id)
        }
    }

    private fun IfNeedToRecheck(): Boolean {
        var checkCounter = 0
        for (answer in answers) {
            if (answer!!.isChecked) checkCounter++
        }
        return checkCounter >= 2
    }

    private fun RecheckButtons(id: Int) {
        for (answer in answers) {
            if (answer!!.isChecked && answer.id != id) {
                answer.isChecked = false
                break
            }
        }
    }
}