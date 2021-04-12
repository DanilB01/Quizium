package ru.tsu.quizium;

public class RecyclerViewItem {

    private final Quiz quiz;
    private final Category category;
    private final int typeCode;

    private final RecyclerViewDataTypeCode type = new RecyclerViewDataTypeCode();

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

    public int getTypeCode(){
        return typeCode;
    }

    public Quiz getQuiz(){
        return quiz;
    }

    public Category getCategory() {
        return category;
    }
}
