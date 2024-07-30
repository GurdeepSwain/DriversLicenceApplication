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

        // Spinner setup
        val spinner: Spinner = view.findViewById(R.id.spinner_options)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_options_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                // An item was selected. You can retrieve the selected item using
                val selectedOption = parent.getItemAtPosition(pos).toString()
                Toast.makeText(requireContext(), "Selected: $selectedOption", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        // RadioGroup setup
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = view.findViewById(checkedId)
            Toast.makeText(requireContext(), "Selected: ${radioButton.text}", Toast.LENGTH_SHORT).show()
        }

        // Save button setup
        val button: Button = view.findViewById(R.id.button_save)
        button.setOnClickListener {
            Toast.makeText(activity, "Settings Saved", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}