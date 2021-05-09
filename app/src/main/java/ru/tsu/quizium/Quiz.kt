package ru.tsu.quizium

data class Quiz(
        val id: Int = 0,
        val name: String = "",
        val description: String = "",
        val author: String = "",
        val pictureName: String = "",
        val questions: List<Question> = emptyList()
)