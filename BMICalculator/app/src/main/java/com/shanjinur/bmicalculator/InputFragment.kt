package com.shanjinur.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shanjinur.bmicalculator.databinding.FragmentInputBinding
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInputBinding>(inflater,R.layout.fragment_input,container,false)

        binding.heightInputText.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.heightInputText.clearFocus()
            }
            false
        })

        binding.weightInputText.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.weightInputText.clearFocus()
            }
            false
        })

        binding.calculateButton.setOnClickListener {view:View ->
            var height:Float = heightInputText.text.toString().toFloat()
            var weight:Float = weightInputText.text.toString().toFloat()

            // here I have to extensively check for empty strings

            var bmi = weight/(height*height)

            view.findNavController().navigate(InputFragmentDirections.actionInputFragmentToResultFragment(bmi))
        }

        return binding.root
    }
}