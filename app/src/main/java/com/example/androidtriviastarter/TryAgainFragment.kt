package com.example.androidtriviastarter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtriviastarter.databinding.FragmentTryAgainBinding

class TryAgainFragment : Fragment() {

    private lateinit var binding: FragmentTryAgainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_try_again,container,false)
        binding.startAgainTry.setOnClickListener {
            it.findNavController().navigate(R.id.action_tryAgainFragment_to_gameFragment)
        }
        return binding.root
    }
}