package ru.tsu.quizium

import ru.tsu.quizium.dto.Quiz

object CurrentQuiz {
    var quiz = Quiz()
    var curQuestionNum = 0
    var numberOfCorrectAnswers = 0
}