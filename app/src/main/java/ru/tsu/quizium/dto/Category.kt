package ru.tsu.quizium.dto

data class Category(
        val name: String = "",
        val id: Int = 0,
        val quizzes: List<Quiz> = emptyList()
)