package ru.tsu.quizium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuizListActivity extends AppCompatActivity {

    private final ArrayList<Quiz> quizList = new ArrayList<Quiz>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        InitQuizData();
        RecyclerView recyclerView = findViewById(R.id.quizRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, quizList);
        recyclerView.setAdapter(adapter);
    }

    private void InitQuizData() {
        quizList.add(new Quiz("Quiz 1", "Description of Quiz 1", "admin", R.drawable.english_grammar));
        quizList.add(new Quiz("Quiz 2", "Description of Quiz 2", "admin", R.drawable.english_vocabulary));
        quizList.add(new Quiz("Quiz 3", "Description of Quiz 3", "admin", R.drawable.math));
        quizList.add(new Quiz("Quiz 4", "Description of Quiz 4", "admin", R.drawable.math));
    }
}