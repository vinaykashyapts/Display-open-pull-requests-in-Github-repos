package com.vinay.vymoassignment.ui

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.vinay.vymoassignment.R
import com.vinay.vymoassignment.data.models.Input
import com.vinay.vymoassignment.databinding.InputRepoDetailsFragmentBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this!!).get(InputRepoDetailsViewModel::class.java)

        val btn=view.findViewById<View>(R.id.submit) as Button

        btn.setOnClickListener {view ->

            lateinit var vm : InputRepoDetailsFragmentBinding
            lateinit var input : Input
            input.owner_name = vm.inputBinding.owner_name
            input.repo_name = vm.inputBinding.repo_name

            viewModel!!.setMsgCommunicator(input)

            val myfragment = ListRepoDataFragment()
            //myfragment.arguments = Bundle().apply { putParcelable() }
            requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, myfragment)
            .commit()
        }
    }

}