package com.shanjinur.creatingafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shanjinur.creatingafragment.databinding.FragmentAboutBinding
import com.shanjinur.creatingafragment.databinding.FragmentTitleBinding

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
            R.layout.fragment_about,container,false)

        return binding.root
    }
}