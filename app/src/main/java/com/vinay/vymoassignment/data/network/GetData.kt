package com.vinay.vymoassignment.data.network

import com.vinay.vymoassignment.data.models.RepoPulls
import io.reactivex.Observable
import retrofit2.http.GET

interface GetData {
    /* Not in use */
    @GET("pulls")
    fun getData() : Observable<List<RepoPulls>>
}