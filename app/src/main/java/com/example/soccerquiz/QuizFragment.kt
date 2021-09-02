package com.example.soccerquiz

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.soccerquiz.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private val quizItems: MutableList<QuizItem> = mutableListOf(
        QuizItem("How many players does each team have on the pitch when a soccer match starts?",
            listOf("11", "8", "12")),
        QuizItem("What should be the circumference of a Size 5 (adult) football?",
            listOf("27\" to 28\"", "24\" to 25\"", "23\" to 24\"")),
        QuizItem("What is given to a player for a very serious personal foul on an opponent?",
            listOf("Red Card", "Green Card", "Yellow Card")),
        QuizItem("To most places in the world, soccer is known as what?",
            listOf("Football", "Footgame", "Legball")),
        QuizItem("Offside. If a player is offside, what action does the referee take?",
            listOf("Awards an indirect free kick to the opposing team",
                "Awards a penalty to the opposing team",
                "Awards a yellow card to the player")),
        QuizItem("What should be the circumference of a Size 5 (adult) football?",
            listOf("17", "11", "23")),
        QuizItem("Excluding the goalkeeper, what part of the body cannot touch the ball?",
            listOf("Arm", "Head", "Shoulder"))
    )

    lateinit var cur: QuizItem
    lateinit var answers: MutableList<String>
    private var quizItemIndex = 0
    private val numberOfQuestions = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(inflater,R.layout.fragment_quiz, container, false)
        getRundomQuizItem()

        binding.quizFragment = this

        binding.pass.setOnClickListener{
            view: View->
            val selectedCheckbox = binding.quizRadioGroup.checkedRadioButtonId
            if(selectedCheckbox != 1){
                var answerIndex = 0
                when(selectedCheckbox){
                    R.id.firstRadioBtn->answerIndex = 0
                    R.id.SecondRadioBtn->answerIndex = 1
                    R.id.ThirdRadioBtn->answerIndex = 2
                }

                if(answers[answerIndex] == cur.answer[0]){
                    quizItemIndex++
                    if(quizItemIndex < numberOfQuestions){
                        setQuizItem()
                        binding.invalidateAll()
                    }else{
                        view.findNavController().navigate(
                            R.id.action_quizFragment_to_golFragment
                        )
                        //go golFragment
                    }

                }else{
                    view.findNavController().navigate(
                        R.id.action_quizFragment_to_missFragment
                    )
                    //go miss
                }
            }
        }

        setHasOptionsMenu(true)



        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun getRundomQuizItem(){
        quizItems.shuffle()

        quizItemIndex = 0
        setQuizItem()
    }

    private fun setQuizItem(){
        cur = quizItems[quizItemIndex]
        answers = cur.answer.toMutableList()
        answers.shuffle()
    }
}