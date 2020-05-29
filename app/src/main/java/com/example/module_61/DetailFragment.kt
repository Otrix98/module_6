package com.example.module_61

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment(R.layout.fragment_detail) {

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
        inputText.text = requireArguments().getString(KEY_LOGIN)

    }
    companion object {

        private const val KEY_LOGIN = "key_login"

        fun newInstance(text: String): DetailFragment {
            return DetailFragment().whithArguments {
                putString(KEY_LOGIN, text)
            }
        }
    }


    }
