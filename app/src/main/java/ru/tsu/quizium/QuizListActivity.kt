package ru.tsu.quizium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class QuizListActivity : AppCompatActivity() {
    private val quizList = ArrayList<Quiz>()
    private val categoryList = ArrayList<Category>()
    private val resultItemList = ArrayList<RecyclerViewItem>()
    private val mAuth: FirebaseAuth? = null
    private var dbRef: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_list)
        dbRef = FirebaseDatabase.getInstance().reference
        InitCategories()
        InitQuizData()
        InitRecyclerViewDataList()
        val recyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        val adapter = RecyclerViewAdapter(this, resultItemList)
        recyclerView.adapter = adapter
    }

    private fun InitRecyclerViewDataList() {
        for (i in 0..3) {
            resultItemList.add(RecyclerViewItem(categoryList[i]))
            for (j in 0..3) {
                resultItemList.add(RecyclerViewItem(quizList[j]))
            }
        }
    }

    private fun InitQuizData() {
        for (i in 0..3) {
            val category = categoryList[i]
            quizList.add(Quiz("Quiz 1", "Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1", "admin", R.drawable.english_grammar, category.name))
            quizList.add(Quiz("Quiz 2", "Description of Quiz 2", "admin", R.drawable.english_vocabulary, category.name))
            quizList.add(Quiz("Quiz 3", "Description of Quiz 3", "admin", R.drawable.math, category.name))
            quizList.add(Quiz("Quiz 4", "Description of Quiz 4", "admin", R.drawable.math, category.name))
        }
    }

    private fun InitCategories() {
        for (i in 0..3) {
            categoryList.add(Category("Category $i"))
        }
    }
}