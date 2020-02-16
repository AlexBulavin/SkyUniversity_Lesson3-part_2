package com.example.android.navigation

import android.os.Bundle
import android.text.Html
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_about.*
import android.view.LayoutInflater


/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container,false)
        binding.playButton.setOnClickListener {v: View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment()) }
                //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu) //Создаём меню
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
                view!!.findNavController()) //Выбор элемента из списка меню

        || super.onOptionsItemSelected(item)

    }

}
