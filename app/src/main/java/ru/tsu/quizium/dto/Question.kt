package ru.tsu.quizium.dto

data class Question(
        val id: Int = 0,
        val name: String = "",
        val answers: List<Answer> = emptyList()
)
