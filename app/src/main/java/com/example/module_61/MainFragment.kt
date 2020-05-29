package com.example.module_61

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*

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


        childFragmentManager.beginTransaction()
            .add(R.id.container_main, ListFragment())
//            .addToBackStack(null)
            .commit()


    }
//    fun addDetail() {
//        childFragmentManager.beginTransaction()
//            .add(R.id.container_main, DetailFragment.newInstance(text()))
//            .addToBackStack(null)
//            .commit()
//    }
//    fun text(): String{
//        var text : String = "text"
//        view.let { it as ViewGroup }
//            .children
//            .mapNotNull { it as? TextView }
//            .forEach { text = it.text.toString()}
//        return text
//    }

    override fun onItemSelected(text: String) {
        childFragmentManager.beginTransaction()
            .add(R.id.container_main, DetailFragment.newInstance(text))
            .addToBackStack(null)
            .commit()


    }

    }





