package com.vinay.vymoassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        val model=ViewModelProviders.of(activity!!).get(InputRepoDetailsViewModel::class.java)

        model.message.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                Toast.makeText(activity, model.message.toString(), Toast.LENGTH_LONG).show();
            }
        })
        val api = GithubAPI()
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