package com.vinay.vymoassignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinay.vymoassignment.R
import com.vinay.vymoassignment.data.models.RepoPulls
import com.vinay.vymoassignment.databinding.RepoItemBinding

class PullsAdapter(
    private val pulls: List<RepoPulls>
) : RecyclerView.Adapter<PullsAdapter.PullsViewHolder>() {

    override fun getItemCount() = pulls.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PullsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.repo_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PullsViewHolder, position: Int) {
        holder.repoItemBinding.repo = pulls[position]
    }

    inner class PullsViewHolder(
        val repoItemBinding: RepoItemBinding
    ) : RecyclerView.ViewHolder(repoItemBinding.root)
}