package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val email = mAuth!!.currentUser?.email
        userEmailTextView.text = email

        changeUserTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, AuthorizationActivity::class.java)
            startActivity(intent)
        }
        selectQuizButton.setOnClickListener {
            val intent = Intent(this@MainActivity, QuizListActivity::class.java)
            startActivity(intent)
        }
        rankingButton.setOnClickListener {
            val intent = Intent(this@MainActivity, QuizResultActivity::class.java)
            startActivity(intent)
        }
    }
}