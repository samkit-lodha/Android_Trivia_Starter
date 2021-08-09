package com.example.androidtriviastarter

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val questions = listOf<QuestionAnswer>(
        QuestionAnswer("What is Android Jetpack?", listOf("All of these", "Tools", "Documentation", "Libraries")),
        QuestionAnswer("What is the base class for layouts?", listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        QuestionAnswer("What layout do you use for complex screens?", listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"))
    )

    fun getQuestion(index : Int) : QuestionAnswer {
        return questions[index]
    }

    var index : Int = 0
    val totalQue : Int = 3

    fun increment(){
        index++
    }
}