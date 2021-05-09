package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz_result.*

class QuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        quizNameTextView.text = CurrentQuiz.quiz.name
        resultTextView.text = "Ваш результат: ${CurrentQuiz.numberOfCorrectAnswers} из ${CurrentQuiz.quiz.questions.size}"

        retryTestButton.setOnClickListener {
            CurrentQuiz.numberOfCorrectAnswers = 0
            CurrentQuiz.curQuestionNum = 0
            val intent = Intent(this, QuizQuestionActivity::class.java)
            startActivity(intent)
            finish()
        }

        backToQuizListButton.setOnClickListener {
            finish()
        }
    }
}