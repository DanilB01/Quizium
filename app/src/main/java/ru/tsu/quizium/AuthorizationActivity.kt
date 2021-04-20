package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_authorization.*

class AuthorizationActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        registerButton.setOnClickListener {
            val intent = Intent(this@AuthorizationActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener {
            signIng(emailLoginEditText.text.toString(), passwordLoginEditText.text.toString())
        }
    }

    private fun signIng(email: String, password: String) {
        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@AuthorizationActivity, "Авторизация успешна", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@AuthorizationActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@AuthorizationActivity, "Не удалось авторизироваться", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}