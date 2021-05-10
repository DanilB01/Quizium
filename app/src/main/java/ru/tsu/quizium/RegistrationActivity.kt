package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*
import ru.tsu.quizium.RegistrationActivity

class RegistrationActivity : AppCompatActivity() {

    private val mAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        createAccountButton.setOnClickListener {
            register(
                    emailRegistrationEditText.text.toString(),
                    passwordRegistrationEditText.text.toString()
            )
        }
    }

    private fun register(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@RegistrationActivity, "Авторизация успешна", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@RegistrationActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@RegistrationActivity, "Не удалось авторизироваться", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}