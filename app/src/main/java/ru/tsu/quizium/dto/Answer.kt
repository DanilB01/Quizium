package ru.tsu.quizium.dto

data class Answer(
        val id: Int = 0,
        val value: String = "",
        val correct: Boolean = false
)
