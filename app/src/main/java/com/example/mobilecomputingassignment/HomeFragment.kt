package com.example.mobilecomputingassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonShowFragment: Button = view.findViewById(R.id.btn_show_fragment)
        buttonShowFragment.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, MyFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        return view
    }
}