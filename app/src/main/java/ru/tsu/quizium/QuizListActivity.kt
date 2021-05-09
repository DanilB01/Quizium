package ru.tsu.quizium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*

class QuizListActivity : AppCompatActivity() {

    private val quizList = ArrayList<Quiz>()
    private val categoryList = mutableListOf<Category>()
    private val resultItemList = ArrayList<RecyclerViewItem>()

    /*private val mAuth: FirebaseAuth? = null
    private var dbRef: DatabaseReference? = null*/

    private val database by lazy { FirebaseDatabase.getInstance() }
    private val themeRef by lazy { database.getReference("theme") }

    private val quizRef by lazy { database.getReference(AppConst.KEY_QUIZ) }
    private val langRef by lazy { quizRef.child(AppConst.KEY_LANGUAGE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_list)

        //dbRef = FirebaseDatabase.getInstance().reference
        /*initCategories()
        initQuizData()
        initRecyclerViewDataList()*/

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

    /*private fun initRecyclerViewDataList() {
        for (i in 0..3) {
            resultItemList.add(RecyclerViewItem(categoryList[i]))
            for (j in 0..3) {
                resultItemList.add(RecyclerViewItem(quizList[j]))
            }
        }
    }

   private fun initQuizData() {
        for (i in 0..3) {
            val category = categoryList[i]
            quizList.add(Quiz("Quiz 1", "Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1", "admin", R.drawable.english_grammar, category.name))
            quizList.add(Quiz("Quiz 2", "Description of Quiz 2", "admin", R.drawable.english_vocabulary, category.name))
            quizList.add(Quiz("Quiz 3", "Description of Quiz 3", "admin", R.drawable.math, category.name))
            quizList.add(Quiz("Quiz 4", "Description of Quiz 4", "admin", R.drawable.math, category.name))
        }
    }

    private fun initCategories() {
        for (i in 0..3) {
            categoryList.add(Category("Category $i"))
        }
    }*/
}