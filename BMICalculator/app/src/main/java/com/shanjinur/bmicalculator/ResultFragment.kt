package com.shanjinur.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.shanjinur.bmicalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding
    lateinit var args: ResultFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentResultBinding>(inflater,R.layout.fragment_result,container,false)

        args = ResultFragmentArgs.fromBundle(requireArguments())

        setHasOptionsMenu(true)

        Toast.makeText(this.context,args.toString(),Toast.LENGTH_SHORT).show()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    private fun shareSuccess(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, this.args.toString())
        return shareIntent
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shareAction -> startActivity(shareSuccess())
        }
        return super.onOptionsItemSelected(item)
    }
}