package ru.tsu.quizium.dto

data class Quiz(
        val id: String = "",
        val name: String = "",
        val description: String = "",
        val author: String = "",
        val pictureName: String = "",
        val questions: List<Question> = emptyList()
)