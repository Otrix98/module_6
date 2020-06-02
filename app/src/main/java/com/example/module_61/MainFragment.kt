package com.example.module_61


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class MainFragment: Fragment(R.layout.fragment_main), ItemSelectListener {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tabletSize = resources.getBoolean(R.bool.isTablet)
        if (!tabletSize) {
        childFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.container_main, ListFragment())
            .addToBackStack(null)
            .commit()
    }

    }

    override fun onItemSelected(text: String) {
        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(R.id.container_main, DetailFragment.newInstance(text))
            .commit()


    }


    }





