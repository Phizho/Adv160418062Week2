package com.ubaya.adv160418062week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    var nilai = 0
    var jwbBenar = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).PlayerName
            txtTurn.text = "$playerName's Turn"
            generateSoal()
        }

        btnSubmit.setOnClickListener{
            val jawab = iptJawab.text.toString()

            if (Integer.parseInt(jawab) == jwbBenar) {
                nilai += 1
                generateSoal()
            } else {
                val action = GameFragmentDirections.actionMainFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun generateSoal() {
        val rand = Random()
        val soal1 = rand.nextInt(31)
        val soal2 = rand.nextInt(31)

        txtSoal.text = "$soal1 + $soal2"
        jwbBenar = soal1 + soal2

    }
}