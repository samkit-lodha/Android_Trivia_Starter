package com.example.androidtriviastarter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtriviastarter.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {

    private lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_won,container,false)

        binding.startAgainWon.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment2)
        }

        return binding.root
    }
}