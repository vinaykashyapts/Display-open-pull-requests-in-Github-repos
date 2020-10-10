package com.vinay.vymoassignment.ui

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
    private lateinit var vm : InputRepoDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_repo_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this!!).get(InputRepoDetailsViewModel::class.java)

        val ownerName=view.findViewById<View>(R.id.gitOwnerName) as EditText
        val repoName=view.findViewById<View>(R.id.gitRepoName) as EditText
        val btn=view.findViewById<View>(R.id.submit) as Button

        btn.setOnClickListener {view ->

            if(ownerName.text.isNullOrEmpty() || repoName.text.isNullOrEmpty()) {
                Toast.makeText(activity, "Enter details", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            var input = Input(ownerName.text.toString(), repoName.text.toString())

            viewModel!!.setMsgCommunicator(input)

            val myfragment = ListRepoDataFragment()

            val args = Bundle()
            args.putString(getString(R.string.git_owner_name), input.owner_name)
            args.putString(getString(R.string.git_repo_name), input.repo_name)
            myfragment.arguments = args

            requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, myfragment)
            .commit()
        }
    }

}