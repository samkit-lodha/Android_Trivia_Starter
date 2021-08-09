package com.example.androidtriviastarter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.androidtriviastarter.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding : FragmentGameBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var currQuestion : String
    private lateinit var currAnswer : MutableList<String>
    private var correct : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setQuestion()

        binding.submitButton.setOnClickListener {
            val checkId = binding.answersGroup.checkedRadioButtonId
            var answerId = 0

            when(checkId){
                R.id.answer1 -> answerId = 1
                R.id.answer2 -> answerId = 2
                R.id.answer3 -> answerId = 3
            }

            if(currAnswer[answerId]==viewModel.getQuestion(viewModel.index).answers[0]){
                correct++
            }

            viewModel.increment()
            if(viewModel.index==viewModel.totalQue){
                viewModel.index = 0
                if(correct==viewModel.totalQue){
                    it.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment2)
                }
                else{
                    it.findNavController().navigate(R.id.action_gameFragment_to_tryAgainFragment2)
                }
            }
            else{
                setQuestion()
            }
        }
        return binding.root
    }

    private fun setQuestion() {
        val temp : QuestionAnswer = viewModel.getQuestion(viewModel.index)
        currQuestion = temp.question
        currAnswer = temp.answers.toMutableList()
        currAnswer.shuffle()

        binding.setQue = QuestionAnswer(currQuestion,currAnswer)
    }
}