package com.vinay.vymoassignment.data.network

import com.vinay.vymoassignment.data.models.RepoPulls
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GithubAPI {

    @GET("pulls")
    suspend fun getRepoPulls() : Response<List<RepoPulls>>


    companion object{
        operator fun invoke(ownerName: String?, repoName: String?) : GithubAPI {

            val URL = "https://api.github.com/repos/" + ownerName + "/" + repoName + "/"

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build()
                .create(GithubAPI::class.java)
        }
    }
}