package ru.tsu.quizium;

public class RecyclerViewItem {

    private Quiz quiz;
    private Category category;
    private int typeCode;

    RecyclerViewDataTypeCode type = new RecyclerViewDataTypeCode();

    RecyclerViewItem(Quiz quiz){
        this.quiz = quiz;
        this.category = null;
        this.typeCode = type.TYPE_QUIZ;
    }
    RecyclerViewItem(Category category){
        this.quiz = null;
        this.category = category;
        this.typeCode = type.TYPE_CATEGORY;
    }
}
