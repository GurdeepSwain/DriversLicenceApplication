package com.example.mobilecomputingassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display, container, false)

        val name = arguments?.getString("name")
        val email = arguments?.getString("email")
        val occupation = arguments?.getString("occupation")
        val gender = arguments?.getString("gender")

        val textView = view.findViewById<TextView>(R.id.textViewDisplay)
        textView.text = "Name: $name\nEmail: $email\nOccupation: $occupation\nGender: $gender"

        return view
    }
}