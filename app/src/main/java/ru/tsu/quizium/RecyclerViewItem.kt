package ru.tsu.quizium

class RecyclerViewItem {
    val quiz: Quiz?
    val category: Category?
    val typeCode: Int

    internal constructor(quiz: Quiz?) {
        this.quiz = quiz
        category = null
        typeCode = RecyclerViewDataTypeCode.TYPE_QUIZ
    }

    internal constructor(category: Category?) {
        quiz = null
        this.category = category
        typeCode = RecyclerViewDataTypeCode.TYPE_CATEGORY
    }

}