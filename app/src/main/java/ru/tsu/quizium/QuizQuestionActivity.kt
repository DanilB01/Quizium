package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    var answers = arrayOfNulls<ToggleButton>(4)
    var isLastQuestion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)


        val question = CurrentQuiz.quiz.questions[CurrentQuiz.curQuestionNum]
        questionNumberTitleTextView.text = "Вопрос ${CurrentQuiz.curQuestionNum + 1}"
        questionTitleTextView.text = question.name

        option1Button.text = question.answers[0].value
        option1Button.textOn = question.answers[0].value
        option1Button.textOff = question.answers[0].value

        option2Button.text = question.answers[1].value
        option2Button.textOn = question.answers[1].value
        option2Button.textOff = question.answers[1].value

        option3Button.text = question.answers[2].value
        option3Button.textOn = question.answers[2].value
        option3Button.textOff = question.answers[2].value

        option4Button.text = question.answers[3].value
        option4Button.textOn = question.answers[3].value
        option4Button.textOff = question.answers[3].value

        if(CurrentQuiz.curQuestionNum == CurrentQuiz.quiz.questions.size - 1) {
            nextQuestionButton.text = "Завершить"
            isLastQuestion = true
        }

        answers[0] = findViewById(R.id.option1Button)
        answers[1] = findViewById(R.id.option2Button)
        answers[2] = findViewById(R.id.option3Button)
        answers[3] = findViewById(R.id.option4Button)
        for (answer in answers) answer!!.setOnCheckedChangeListener(this)

        nextQuestionButton.setOnClickListener {
            val answer = getCheckedButtonAnswer(question)
            if(answer != null && answer.correct){
                CurrentQuiz.numberOfCorrectAnswers++
            }
            val intent =
                    if(isLastQuestion)
                        Intent(this, QuizResultActivity::class.java)
                    else {
                        CurrentQuiz.curQuestionNum++
                        Intent(this, QuizQuestionActivity::class.java)
                    }
            startActivity(intent)
            finish()
        }

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

    private fun getCheckedButtonAnswer(question: Question): Answer?{
        if(option1Button.isChecked)
            return question.answers[0]
        if(option2Button.isChecked)
            return question.answers[1]
        if(option3Button.isChecked)
            return question.answers[2]
        if(option4Button.isChecked)
            return question.answers[3]
        else
            return null
    }
}