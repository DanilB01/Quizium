package ru.tsu.quizium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthSettings
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_ranking.*
import ru.tsu.quizium.dto.Category
import ru.tsu.quizium.dto.RankingItem
import ru.tsu.quizium.dto.RecyclerViewItem
import ru.tsu.quizium.dto.User
import java.util.ArrayList

class RankingActivity : AppCompatActivity() {

    private val userResultsList = mutableListOf<RankingItem>()

    private val mAuth by lazy { FirebaseAuth.getInstance() }
    private val database by lazy { FirebaseDatabase.getInstance() }
    private val usersRef by lazy { database.getReference("users") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        getUsersResults()
    }

    private fun getUsersResults(){
        usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                children.forEach {
                    val curUserResult = it.getValue(User::class.java)
                    if (curUserResult != null) {
                        val curUserRank = RankingItem()
                        curUserRank.userName = curUserResult.name

                        var sumUserPoints = 0
                        for(result in curUserResult.results){
                            sumUserPoints += result.points
                        }
                        curUserRank.point = sumUserPoints

                        userResultsList.add(curUserRank)
                    }
                }

                userResultsList.sortByDescending{ it.point }

                val recyclerView = findViewById<RecyclerView>(R.id.usersRankingRecyclerView)
                val adapter = RankingRecyclerViewAdapter(applicationContext, userResultsList)
                recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}