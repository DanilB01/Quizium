package ru.tsu.quizium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuizListActivity extends AppCompatActivity {

    private final ArrayList<Quiz> quizList = new ArrayList<Quiz>();
    private final ArrayList<Category> categoryList = new ArrayList<Category>();
    private final ArrayList<RecyclerViewItem> resultItemList = new ArrayList<RecyclerViewItem>();

    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        dbRef = FirebaseDatabase.getInstance().getReference();


        InitCategories();
        InitQuizData();
        InitRecyclerViewDataList();
        RecyclerView recyclerView = findViewById(R.id.quizRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, resultItemList);
        recyclerView.setAdapter(adapter);
    }

    private void InitRecyclerViewDataList(){
        for(int i = 0; i < 4; i++){
            resultItemList.add(new RecyclerViewItem(categoryList.get(i)));
            for(int j = 0; j < 4; j++){
                resultItemList.add(new RecyclerViewItem(quizList.get(j)));
            }
        }
    }

    private void InitQuizData() {
        for(int i = 0; i < 4; i++){
            Category category = categoryList.get(i);
            quizList.add(new Quiz("Quiz 1", "Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1 Description of Quiz 1", "admin", R.drawable.english_grammar, category.getName()));
            quizList.add(new Quiz("Quiz 2", "Description of Quiz 2", "admin", R.drawable.english_vocabulary, category.getName()));
            quizList.add(new Quiz("Quiz 3", "Description of Quiz 3", "admin", R.drawable.math, category.getName()));
            quizList.add(new Quiz("Quiz 4", "Description of Quiz 4", "admin", R.drawable.math, category.getName()));
        }
    }

    private void InitCategories(){
        for(int i = 0; i < 4; i++){
            categoryList.add(new Category("Category " + i));
        }
    }
}