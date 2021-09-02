package com.example.soccerquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.soccerquiz.databinding.FragmentGolBinding


class GolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentGolBinding>(inflater,R.layout.fragment_gol, container, false)

        //binding.golFragment = this

        binding.oneMoreTime.setOnClickListener{
            view: View->
            view.findNavController().navigate(
                R.id.action_golFragment_to_quizFragment
            )
        }

        return binding.root
    }
}