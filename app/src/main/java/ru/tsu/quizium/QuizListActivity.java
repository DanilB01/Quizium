package ru.tsu.quizium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuizListActivity extends AppCompatActivity {

    private final ArrayList<Quiz> quizList = new ArrayList<Quiz>();
    private final ArrayList<Category> categoryList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        InitCategories();
        InitQuizData();
        RecyclerView recyclerView = findViewById(R.id.quizRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, quizList);
        recyclerView.setAdapter(adapter);
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