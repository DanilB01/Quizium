package ru.tsu.quizium

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_authorization.*
import ru.tsu.quizium.dto.Result

class AuthorizationActivity : AppCompatActivity() {

    private val mAuth by lazy { FirebaseAuth.getInstance() }

    private val database by lazy { FirebaseDatabase.getInstance() }
    private val ref by lazy { database.reference }

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
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        //val result = Result(1, 500)
                        //ref.child(mAuth.currentUser!!.uid).child(result.id.toString()).setValue(result)

                        Toast.makeText(this@AuthorizationActivity, "Авторизация успешна", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@AuthorizationActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@AuthorizationActivity, "Не удалось авторизироваться", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}