package ru.tsu.quizium.dto

import ru.tsu.quizium.AppConst

class RecyclerViewItem {
    val quiz: Quiz?
    val category: Category?
    val typeCode: Int

    internal constructor(quiz: Quiz?) {
        this.quiz = quiz
        category = null
        typeCode = AppConst.TYPE_QUIZ
    }

    internal constructor(category: Category?) {
        quiz = null
        this.category = category
        typeCode = AppConst.TYPE_CATEGORY
    }

}