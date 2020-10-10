package com.vinay.vymoassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinay.vymoassignment.R
import com.vinay.vymoassignment.data.network.GithubAPI
import com.vinay.vymoassignment.data.repositories.RepoPullsRepository
import kotlinx.android.synthetic.main.list_repo_data_fragment.*

class ListRepoDataFragment : Fragment() {

    private lateinit var factory: PullsViewModelFactory
    private lateinit var viewModel: ListRepoDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_repo_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = GithubAPI(requireArguments().getString(getString(R.string.git_owner_name)), requireArguments().getString(getString(R.string.git_repo_name)))
        val repository = RepoPullsRepository(api)

        factory = PullsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(ListRepoDataViewModel::class.java)

        viewModel.getPulls()

        viewModel.pulls.observe(viewLifecycleOwner, Observer { pulls ->
            recycler_view_pulls.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PullsAdapter(pulls)
            }
        })
    }

}