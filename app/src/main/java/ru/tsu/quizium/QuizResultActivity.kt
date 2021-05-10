package ru.tsu.quizium

import  ru.tsu.quizium.dto.Result
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_quiz_result.*

class QuizResultActivity : AppCompatActivity() {

    private val mAuth by lazy { FirebaseAuth.getInstance() }
    private val database by lazy { FirebaseDatabase.getInstance() }
    private val usersRef by lazy { database.getReference("users") }

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

            val result = Result(CurrentQuiz.quiz.id, CurrentQuiz.numberOfCorrectAnswers)
            usersRef.child(mAuth.currentUser!!.uid).child(result.id.toString()).setValue(result)

            finish()
        }
    }
}