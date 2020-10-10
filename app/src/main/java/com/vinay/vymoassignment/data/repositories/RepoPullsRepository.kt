package com.vinay.vymoassignment.data.repositories

import com.vinay.vymoassignment.data.network.GithubAPI

class RepoPullsRepository(
    private val api: GithubAPI
) : SafeApiRequest() {

    suspend fun getRepoPulls() = apiRequest { api.getRepoPulls() }

}