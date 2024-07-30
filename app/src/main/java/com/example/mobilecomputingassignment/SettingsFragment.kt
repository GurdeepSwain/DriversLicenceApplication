package com.example.mobilecomputingassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.mobilecomputingassignment.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val nameEditText: EditText = view.findViewById(R.id.editTextName)
        val emailEditText: EditText = view.findViewById(R.id.editTextEmail)
        val spinner: Spinner = view.findViewById(R.id.spinner_options)
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)

        // Spinner setup
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_options_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Save button setup
        val button: Button = view.findViewById(R.id.button_save)
        button.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val occupation = spinner.selectedItem.toString()
            val gender = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)?.text.toString()

            // Display the entered information
            val displayFragment = DisplayFragment()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("email", email)
            bundle.putString("occupation", occupation)
            bundle.putString("gender", gender)
            displayFragment.arguments = bundle

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, displayFragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        return view
    }
}