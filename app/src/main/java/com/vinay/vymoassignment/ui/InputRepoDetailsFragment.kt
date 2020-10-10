package com.vinay.vymoassignment.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinay.vymoassignment.R

class InputRepoDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = InputRepoDetailsFragment()
    }

    private lateinit var viewModel: InputRepoDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_repo_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InputRepoDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}