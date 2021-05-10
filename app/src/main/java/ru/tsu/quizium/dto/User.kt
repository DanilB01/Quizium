package ru.tsu.quizium.dto

data class User(
        val name: String = "",
        val results: List<Result> = emptyList()
)
