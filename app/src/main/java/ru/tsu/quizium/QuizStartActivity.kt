package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz_start.*
import kotlinx.android.synthetic.main.item_quiz.view.*

class QuizStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_start)

        val quiz = CurrentQuiz.quiz
        val picId = resources.getIdentifier(quiz.pictureName, "drawable", packageName)
        val questionNumber = quiz.questions.size
        quizNameStartTextView.text = quiz.name
        quizImageView.setImageDrawable(resources.getDrawable(picId))
        descriptionOnStartTextView.text = quiz.description
        questionsNumberTextView.text = "Вопросов в тесте: $questionNumber"
        quizAuthorTextView.text = "Автор: ${quiz.author}"

        startQuizButton.setOnClickListener {
            CurrentQuiz.numberOfCorrectAnswers = 0
            CurrentQuiz.curQuestionNum = 0
            val intent = Intent(this, QuizQuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}