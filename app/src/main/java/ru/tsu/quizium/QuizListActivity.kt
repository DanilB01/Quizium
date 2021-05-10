package ru.tsu.quizium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import ru.tsu.quizium.dto.Category
import ru.tsu.quizium.dto.Quiz
import ru.tsu.quizium.dto.RecyclerViewItem
import java.util.*

class QuizListActivity : AppCompatActivity() {

    private val categoryList = mutableListOf<Category>()
    private val resultItemList = ArrayList<RecyclerViewItem>()

    private val database by lazy { FirebaseDatabase.getInstance() }
    private val themeRef by lazy { database.getReference("theme") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_list)

        getQuizzes()
    }

    private fun getQuizzes(){
        themeRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                children.forEach {
                    val curCategory = it.getValue(Category::class.java)
                    if (curCategory != null) {
                        categoryList.add(curCategory)
                    }
                }
                for(category in categoryList){
                    resultItemList.add(RecyclerViewItem(category))
                    for(quiz in category.quizzes){
                        resultItemList.add(RecyclerViewItem(quiz))
                    }
                }
                val recyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
                val adapter = RecyclerViewAdapter(applicationContext, resultItemList)
                recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}