package com.shanjinur.databinding

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shanjinur.databinding.databinding.ActivityMainBinding
import com.shanjinur.databinding.model.Personal
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var personal: Personal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.imageView.visibility = View.INVISIBLE

        personal = Personal()

        binding.personalInfo = personal

        binding.editTextTextPersonName.setOnEditorActionListener(OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                editTextTextPersonName.clearFocus()
            }
            false
        })

        binding.doneButton.text = "Submit"

        binding.doneButton.setOnClickListener {
            binding.apply {
                editTextTextPersonName.visibility = View.GONE
                doneButton.visibility = View.GONE
                personal.name = editTextTextPersonName.text.toString()
                imageView.visibility = View.VISIBLE
                invalidateAll()
            }
        }
    }
}